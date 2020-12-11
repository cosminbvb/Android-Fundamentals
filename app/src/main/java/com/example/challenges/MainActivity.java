package com.example.challenges;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Animal> animals = getAnimals();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        AnimalRecyclerAdapter adapter = new AnimalRecyclerAdapter(animals);

        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private List<Animal> getAnimals(){
        ArrayList<Animal> animals = new ArrayList<>();

        animals.add(new Animal("Fluffy", "Cat", 1000));
        animals.add(new Animal("Max", "Dog", 2000));
        animals.add(new Animal("Bolt", "Cat", 3000));
        animals.add(new Animal("Ion", "Cat", 2000));
        animals.add(new Animal("Little", "Hamster", 1000));
        animals.add(new Animal("Lessie", "Dog", 3000));
        animals.add(new Animal("Spark", "Dog", 4000));
        animals.add(new Animal("Dani Motanu", "Cat", 1000));
        animals.add(new Animal("Bacon", "Pig", 2000));
        animals.add(new Animal("Paco", "Parrot", 6000));
        animals.add(new Animal("Fluffy", "Cat", 1000));
        animals.add(new Animal("Max", "Dog", 2000));
        animals.add(new Animal("Bolt", "Cat", 3000));
        animals.add(new Animal("Ion", "Cat", 2000));
        animals.add(new Animal("Little", "Hamster", 1000));
        animals.add(new Animal("Lessie", "Dog", 3000));
        animals.add(new Animal("Spark", "Dog", 4000));
        animals.add(new Animal("Dani Motanu", "Cat", 1000));
        animals.add(new Animal("Bacon", "Pig", 2000));
        animals.add(new Animal("Paco", "Parrot", 6000));

        return animals;
    }
}