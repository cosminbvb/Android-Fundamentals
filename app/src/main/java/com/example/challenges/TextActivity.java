package com.example.challenges;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TextActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_scroll);

        TextView textView = findViewById(R.id.text_scroll);

        String choice = getIntent().getStringExtra("text");
        assert choice != null;
        if(choice.equals("one")){
            textView.setText(R.string.text1);
        }
        if(choice.equals("two")){
            textView.setText(R.string.text2);
        }
        if(choice.equals("three")){
            textView.setText(R.string.text3);
        }
    }
}
