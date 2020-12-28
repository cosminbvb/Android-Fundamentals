package com.example.challenges;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Listener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.second_frame, new SecondFragment(), "tag")
                .commit();
    }

    @Override
    public void analyze(String height) {
        SecondFragment fragment = (SecondFragment) getSupportFragmentManager().findFragmentByTag("tag");
        fragment.setHeight(height);
    }
}