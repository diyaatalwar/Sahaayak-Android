package com.example.fragments_sample;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ResourcesFragment extends Fragment {

    String email;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_resources, container, false);
        Button btn = view.findViewById(R.id.ls1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.geeksforgeeks.org/resume-building-resources-and-tips/"));
                startActivity(i);
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
                actionBar.setTitle("Resources");
            }
        }
    }



//    public void bankAccount(View view) {
//        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://fi.money/blogposts/opening-an-online-bank-account-a-step-by-step-guide"));
//        startActivity(i);
//    }
//
//    public void publicSpeaking(View view) {
//        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.nytimes.com/guides/year-of-living-better/how-to-speak-in-public"));
//        startActivity(i);
//    }
//
//    public void buildResume(View view) {
//        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.geeksforgeeks.org/resume-building-resources-and-tips/"));
//        startActivity(i);
//    }
//
//    public void interviewPrep(View view) {
//        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.geeksforgeeks.org/top-10-job-interview-tips-for-freshers/"));
//        startActivity(i);
//    }
//
//    public void sampleQuestions(View view) {
//        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://novoresume.com/career-blog/interview-questions-and-best-answers-guide"));
//        startActivity(i);
//    }
//
//
//    public void openCoursera(View view) {
//        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.coursera.org/"));
//        startActivity(i);
//    }
//
//
//    public void openUdemy(View view) {
//        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.udemy.com/"));
//        startActivity(i);
//    }
//
//    public void openVolunteer(View view) {
//        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://volunteeringwithindia.org/"));
//        startActivity(i);
//    }
//
//    public void driversLicense(View view) {
//        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.geeksforgeeks.org/resume-building-resources-and-tips/"));
//        startActivity(i);
//    }
}