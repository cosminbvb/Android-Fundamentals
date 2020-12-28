package com.example.challenges;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {

    private View viewById;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.new_activity, container, false);
    }

    private String height = null;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewById = view.findViewById(R.id.analyze);
        evaluateAnalyzaState();
        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    int heightInCm = Integer.valueOf(height);

                    if(heightInCm <= 0){
                        Toast.makeText(getActivity(), "Invalid height", Toast.LENGTH_LONG).show();
                    }

                    String isEnough;
                    if(heightInCm > 180){
                        isEnough = "YES";
                    } else {
                        isEnough = "NO";
                    }

                    Intent intent = new Intent();
                    intent.putExtra("result", isEnough);

                    Toast.makeText(getActivity(), "Was my height enough? - " + isEnough, Toast.LENGTH_LONG).show();

                } catch (Exception e){
                    Toast.makeText(getActivity(), "Invalid height", Toast.LENGTH_LONG).show();
                } finally {
                    height = null;
                    evaluateAnalyzaState();
                }

            }
        });
    }

    public void setHeight(String height) {
        this.height = height;
        evaluateAnalyzaState();
    }

    private void evaluateAnalyzaState(){
        viewById.setEnabled(height!=null);
    }
}
