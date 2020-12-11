package com.example.challenges;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //ex1();
        //ex2();
        //ex3();
        ex4();
    }

    private void ex1(){
        setContentView(R.layout.activity_main);
        final EditText email = findViewById(R.id.email);
        final EditText phone = findViewById(R.id.phone);
        final CheckBox terms = findViewById(R.id.checkbox);
        Button submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean validEmail = validateEmail(email);
                boolean validPhone = validatePhone(phone);
                boolean checked = terms.isChecked();
                if(validEmail && validPhone && checked){
                    String show = email.getText().toString()+"\n"+phone.getText().toString();
                    Toast.makeText(getApplicationContext(), show, Toast.LENGTH_LONG).show();
                }
                if(!checked){
                    terms.setError("Required");
                }
            }
        });
    }

    private boolean validateEmail(EditText email){
        String content = email.getText().toString();
        if(content.isEmpty()){
            email.setError("Required");
            return false;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(content).matches()){
            email.setError("Invalid email");
            return false;
        }
        return true;
    }

    private boolean validatePhone(EditText phone){
        String content = phone.getText().toString();
        if(content.isEmpty()){
            phone.setError("Required");
            return false;
        }
        for(char c : content.toCharArray()){
            if (Character.getNumericValue(c)>9){
                phone.setError("Invalid character");
                return false;
            }
        }
        if(content.length()!=10){
            phone.setError("Invalid length");
            return false;
        }
        return true;
    }

    private void ex2(){
        setContentView(R.layout.scroll_view);
    }

    private void ex3(){
        setContentView(R.layout.frame_layout);
    }

    private void ex4(){

        setContentView(R.layout.spinner_ex);

        List<String> list = getList();

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);


        Spinner spin = (Spinner)findViewById(R.id.spinner);
        spin.setAdapter(adapter);

         spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 String selectedItem = adapter.getItem(position);
                 Toast.makeText(MainActivity.this, "Selected: " + selectedItem, Toast.LENGTH_SHORT).show();
             }

             @Override
             public void onNothingSelected(AdapterView<?> parent) {

             }
         });
    }

    private List<String> getList(){
        List<String> list = new ArrayList<String>();
        list.add("Cupcake");
        list.add("Donut");
        list.add("Eclair");
        list.add("KitKat");
        list.add("Pie");

        return list;
    }

}