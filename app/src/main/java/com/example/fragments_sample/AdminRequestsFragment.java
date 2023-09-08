package com.example.fragments_sample;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.Array;
import java.util.List;

public class AdminRequestsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_admin_requests, container, false);

        DatabaseReference dref = FirebaseDatabase.getInstance().getReference("requests");

        dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
//                Iterable<DataSnapshot> requestDataList = dataSnapshot.getChildren();
                for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                    // Retrieve the data for each node
                    View cardView = inflater.inflate(R.layout.request_card, null);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                    );

                    String key = childSnapshot.getKey();
                    RequestClass value = childSnapshot.getValue(RequestClass.class);

                    LinearLayout ll = view.findViewById(R.id.scroll_requests);

                    TextView userId = cardView.findViewById(R.id.userId);
                    int uniqueId1 = View.generateViewId();
                    if(userId!=null){
                        userId.setId(uniqueId1);
                        userId.setText(key);
                    }

                    TextView badgeNo = cardView.findViewById(R.id.badgeNo);
                    int uniqueId2 = View.generateViewId();
                    if(badgeNo!=null) {
                        badgeNo.setId(uniqueId2);
                        badgeNo.setText(value.getBadgeId());
                    }

                    Button viewReq = cardView.findViewById(R.id.viewButton);
                    int buttonId = View.generateViewId();
                    if(viewReq!=null){
                        viewReq.setId(buttonId);
                    }

                    if(cardView.getParent() != null) {
                        ((ViewGroup)cardView.getParent()).removeView(cardView); // <- fix
                    }
                    cardView.setLayoutParams(layoutParams);
                    ll.addView(cardView, ll.getChildCount());

                    if(viewReq!=null){
                        viewReq.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                AlertDialog.Builder ad = new AlertDialog.Builder(getActivity());
                                ad.setTitle("Badge Request").setMessage(userId.getText().toString()+": "+badgeNo.getText().toString()).setCancelable(false).setPositiveButton("Approve", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        FirebaseDatabase.getInstance().getReference("badges/"+userId.getText().toString()).child(value.getBadgeId()).setValue(true);
                                        DatabaseReference dref = FirebaseDatabase.getInstance().getReference("requests/"+userId.getText().toString());
                                        // delete request
                                        dref.removeValue()
                                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                    @Override
                                                    public void onSuccess(Void aVoid) {
                                                        Toast.makeText(getActivity(), "Request removed", Toast.LENGTH_SHORT).show();
                                                        refreshFragment();
                                                    }
                                                })
                                                .addOnFailureListener(new OnFailureListener() {
                                                    @Override
                                                    public void onFailure(@NonNull Exception e) {
                                                        // An error occurred while removing the value
                                                    }
                                                });
                                        ll.removeView(userId.getRootView());

                                    }
                                }).setNegativeButton("Decline", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        // delete request
                                        DatabaseReference dref = FirebaseDatabase.getInstance().getReference("requests/"+userId.getText().toString());
                                        dref.removeValue()
                                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                    @Override
                                                    public void onSuccess(Void aVoid) {
                                                        Toast.makeText(getActivity(), "Request removed", Toast.LENGTH_SHORT).show();
                                                        refreshFragment();
                                                    }
                                                })
                                                .addOnFailureListener(new OnFailureListener() {
                                                    @Override
                                                    public void onFailure(@NonNull Exception e) {
                                                        // An error occurred while removing the value
                                                    }
                                                });
                                        ll.removeView(userId.getRootView());
                                        dialogInterface.cancel();
                                    }
                                });

                                AlertDialog alertDialog = ad.create();
                                alertDialog.show();
                            }
                        });
                    }

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Handle any errors
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
                actionBar.setTitle("Approve/Decline Requests");
            }
        }

    }

    public void refreshFragment(){
        MainAdminActivity main = (MainAdminActivity) getActivity();
        if(main!=null){
            main.refreshRequests();
        }
    }

}