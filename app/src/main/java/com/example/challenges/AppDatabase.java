package com.example.challenges;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Person.class}, version = 1)
public abstract class AppDatabase  extends RoomDatabase {

    public abstract PersonDao personDao();

    private static AppDatabase INSTANCE;

    public static AppDatabase getDataBase(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class,
                    "mydb")
                    .build();
        }
        return INSTANCE;
    }

}
