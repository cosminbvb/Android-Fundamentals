package com.example.challenges;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Ex3Activity1 extends AppCompatActivity {

    private static final int REQUEST_CODE = 1000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex3_1);

        findViewById(R.id.send1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = findViewById(R.id.message1);
                String text = editText.getText().toString();
                if(text.isEmpty()){
                    editText.setError("Can't be empty");
                    return;
                }
                Intent intent = new Intent(Ex3Activity1.this, Ex3Activity2.class);
                intent.putExtra("message", text);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE){
            if(resultCode == Activity.RESULT_OK){
                TextView textView1 = findViewById(R.id.TextView1);
                textView1.setText("Reply received");
                TextView textView2 = findViewById(R.id.TextView2);
                textView2.setText(data.getStringExtra("reply"));
            }
        }
    }
}
