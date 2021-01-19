package com.example.challenges;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements PersonListener {

    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layoutManager);

        recyclerViewAdapter = new RecyclerViewAdapter();
        recyclerView.setAdapter(recyclerViewAdapter);

        DataSource dataSource = new DataSource(this);
        dataSource.getPersons(this);
    }

    @Override
    public void onPersonsFetchedFromServer(final List<Person> personList) {
        //metoda e apelata de pe alt thread (nu main) si nu are voie sa updateze ui ul
        //deci trebuie rulat tot de main thread
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                recyclerViewAdapter.setData(personList);
            }
        });
    }
}
