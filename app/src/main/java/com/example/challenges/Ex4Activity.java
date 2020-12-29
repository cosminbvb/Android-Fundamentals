package com.example.challenges;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Ex4Activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex4);

        findViewById(R.id.linkButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               EditText editText = findViewById(R.id.linkEditText);
               String link = editText.getText().toString();

               Intent intent = new Intent(Intent.ACTION_VIEW);
               intent.setData(Uri.parse(link));
               if(intent.resolveActivity(getPackageManager())!=null){
                   startActivity(intent);
               }
            }
        });

        findViewById(R.id.locationButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* https://developers.google.com/maps/documentation/urls/android-intents */
                EditText editText = findViewById(R.id.locationEditText);
                String location = "geo:0,0?q="+editText.getText().toString();

                Uri uri = Uri.parse(location);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });

        findViewById(R.id.shareButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* https://developer.android.com/training/sharing/send */
                EditText editText = findViewById(R.id.shareEditText);
                String text = editText.getText().toString();

                Intent sendIntent = new Intent(Intent.ACTION_SEND);
                sendIntent.setType("text/plain");
                sendIntent.putExtra(Intent.EXTRA_TEXT, text);

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);

            }
        });

        findViewById(R.id.phoneButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = findViewById(R.id.phoneEditText);
                String phone = "tel:"+editText.getText().toString();

                Uri uri = Uri.parse(phone);
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
            }
        });
    }
}
