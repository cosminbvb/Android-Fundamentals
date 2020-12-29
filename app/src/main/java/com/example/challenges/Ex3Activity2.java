package com.example.challenges;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Ex3Activity2 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex3_2);

        TextView textView3 = findViewById(R.id.TextView3);
        textView3.setText("Message received");
        TextView textView4 = findViewById(R.id.TextView4);
        textView4.setText(getIntent().getStringExtra("message"));

        findViewById(R.id.send2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = findViewById(R.id.message2);
                String text = editText.getText().toString();
                if(text.isEmpty()){
                    editText.setError("Can't be empty");
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("reply", text);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}
