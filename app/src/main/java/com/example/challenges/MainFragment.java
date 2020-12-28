package com.example.challenges;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final EditText heightEdit = view.findViewById(R.id.edit_text_height);

        view.findViewById(R.id.navigate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String height = heightEdit.getText().toString();
                ((Listener) getActivity()).analyze(height);
                //Intent intent = new Intent(getActivity(), NewActivity.class);
                //intent.putExtra("height", heightEdit.getText().toString());
                //getActivity().startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private static final int REQUEST_CODE = 1000;

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE){
            if(resultCode == Activity.RESULT_OK){
                if(data != null){
                    String result = data.getStringExtra("result");
                    Toast.makeText(getActivity(), "Was my height enough? - " + result, Toast.LENGTH_LONG).show();
                }
            } else if (resultCode == Activity.RESULT_CANCELED){
                Toast.makeText(getActivity(), "Invalid height", Toast.LENGTH_LONG).show();
            }
        }
    }

}
