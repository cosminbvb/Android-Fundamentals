package com.example.challenges;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //ex1();
        //ex2(); //not done
        ex3();
    }

    private void ex1(){
        setContentView(R.layout.activity_main);
    }

    private void ex2(){

        setContentView(R.layout.recycler);

        List<Student> students = getStudentList();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        StudentRecyclerAdapter adapter = new StudentRecyclerAdapter(students);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    private List<Student> getStudentList(){

        List<Student> students = new ArrayList<Student>();

        students.add(new Student("FirstName1","LastName1"));
        students.add(new Student("FirstName2","LastName2"));
        students.add(new Student("FirstName3","LastName3"));
        students.add(new Student("FirstName4","LastName4"));
        students.add(new Student("FirstName5","LastName5"));
        students.add(new Student("FirstName6","LastName6"));
        students.add(new Student("FirstName7","LastName7"));
        students.add(new Student("FirstName8","LastName8"));
        students.add(new Student("FirstName9","LastName9"));
        students.add(new Student("FirstName10","LastName10"));
        students.add(new Student("FirstName11","LastName11"));
        students.add(new Student("FirstName12","LastName12"));

        return students;
    }

    private void ex3(){
        setContentView(R.layout.happy_holidays);
    }

}