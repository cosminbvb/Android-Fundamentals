package com.example.challenges;

import android.content.Context;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataSource {

    private final Context context;

    private static Retrofit retrofit;

    public DataSource(Context context) {
        this.context = context;
    }

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://raw.githubusercontent.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }

    public void getPersons(final PersonListener listener) {
        GithubApi githubApi = getRetrofit().create(GithubApi.class);
        githubApi.getPersons()
                .enqueue(new Callback<List<Person>>() {
                    @Override
                    public void onResponse(Call<List<Person>> call, Response<List<Person>> response) {
                        if (response.isSuccessful()) {
                            Log.d("tag", "response was successful");
                            final List<Person> personList = response.body();
                            listener.onPersonsFetchedFromServer(response.body());

                            //salvam in database persoanele:
                            //pe un alt thread pt ca nu avem voie pe main thread
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    AppDatabase.getDataBase(context).personDao().deleteAll();
                                    AppDatabase.getDataBase(context).personDao().insertAllPersons(personList);
                                }
                            }).start();

                        }
                    }

                    @Override
                    public void onFailure(Call<List<Person>> call, Throwable throwable) {
                        Log.d("tag", "response was failed");
                        //cand nu am reusit sa luam datele de pe server intoarcem ce avem stocat in bd
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                List<Person> people = AppDatabase.getDataBase(context).personDao().getPersons();
                                listener.onPersonsFetchedFromServer(people);
                            }
                        }).start();
                    }
                });
    }
}
