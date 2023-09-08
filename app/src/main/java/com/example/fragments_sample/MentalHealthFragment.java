package com.example.fragments_sample;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MentalHealthFragment extends Fragment {

    String age;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mental_health, container, false);

        EditText ageEditText = view.findViewById(R.id.ageEditText);
        EditText workInterfereEditText = view.findViewById(R.id.work_interfere_input);
        EditText noEmployeesEditText = view.findViewById(R.id.no_employees_input);
        EditText remoteWorkEditText = view.findViewById(R.id.remote_work_input);
        EditText techCompanyEditText = view.findViewById(R.id.tech_company_input);

        Button bt=view.findViewById(R.id.Score);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                age = ageEditText.getText().toString();
                String workInterfere = workInterfereEditText.getText().toString();
                String noEmployees =noEmployeesEditText.getText().toString();
                String remoteWork = remoteWorkEditText.getText().toString();
                String techCompany = techCompanyEditText.getText().toString();
                Log.d("Age",age);
                if(age.equals("18")){
                    Toast.makeText(getActivity(), "High Risk" , Toast.LENGTH_SHORT).show();
                }
                if(age.equals("20")){
                    if(workInterfere.equals("yes") && noEmployees.equals("5") && remoteWork.equals("yes") && techCompany.equals("yes")){
                        Toast.makeText(getActivity(), "High Risk" , Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(getActivity(), "Low Risk" , Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Update the toolbar title
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (activity != null) {
            ActionBar actionBar = activity.getSupportActionBar();
            if (actionBar != null) {
                actionBar.setTitle("Mental Health Tracker");
            }
        }
    }
}