package com.example.fragments_sample;

import static java.lang.Integer.parseInt;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BadgesFragment extends Fragment {

    Button b1, b2, b3, b4, b5;
    ProgressBar pb;
    TextView pb_text;

    int prog = 0;
    boolean btn1 = false;
    boolean btn2 = false;
    boolean btn3 = false;
    boolean btn4 = false;
    boolean btn5 = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_badges, container, false);

        String userEmail;
        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = auth.getCurrentUser();

        if (currentUser != null) {
            userEmail = currentUser.getEmail();
        } else {
            userEmail = " ";
        }

        pb = view.findViewById(R.id.progress_bar);
        pb_text= view.findViewById(R.id.text_view_progress);


        b1 = view.findViewById(R.id.b1);
        b2 = view.findViewById(R.id.b2);
        b3 = view.findViewById(R.id.b3);
        b4 = view.findViewById(R.id.b4);
        b5 = view.findViewById(R.id.b5);

        String userId = userEmail.substring(0, userEmail.indexOf("@"));
        DatabaseReference dref1 = FirebaseDatabase.getInstance().getReference("badges/"+userId+"/b1");
        DatabaseReference dref2 = FirebaseDatabase.getInstance().getReference("badges/"+userId+"/b2");
        DatabaseReference dref3 = FirebaseDatabase.getInstance().getReference("badges/"+userId+"/b3");
        DatabaseReference dref4 = FirebaseDatabase.getInstance().getReference("badges/"+userId+"/b4");
        DatabaseReference dref5 = FirebaseDatabase.getInstance().getReference("badges/"+userId+"/b5");
        DatabaseReference dref6 = FirebaseDatabase.getInstance().getReference("requests/"+userId);

        dref1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Retrieve the value using getValue()
                boolean value = dataSnapshot.getValue(boolean.class);
                if (value){
                    prog += 20;
                    btn1 = true;
                    b1.setBackgroundColor(Color.parseColor("#62a65e"));
                    refreshProgress();
                }

                dref6.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            RequestClass req = dataSnapshot.getValue(RequestClass.class);
                            if(Objects.equals(req.getBadgeId(), "b1")){
                                b1.setBackgroundColor(Color.parseColor("#e0cd22"));
                                b1.setEnabled(false);
                            }
                        } else {
                            // Data does not exist or is empty
                            // Handle the case accordingly
                            // ...
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        // Handle any errors
                        // ...
                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Handle any error that occurred during data retrieval
            }
        });

        dref2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Retrieve the value using getValue()
                boolean value = dataSnapshot.getValue(boolean.class);
                if (value){
                    prog += 20;
                    btn2 = true;
                    b2.setBackgroundColor(Color.parseColor("#62a65e"));
                    refreshProgress();

                }

                dref6.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            RequestClass req = dataSnapshot.getValue(RequestClass.class);
                            if(Objects.equals(req.getBadgeId(), "b2")){
                                b2.setBackgroundColor(Color.parseColor("#e0cd22"));
                                b2.setEnabled(false);
                            }
                        } else {
                            // Data does not exist or is empty
                            // Handle the case accordingly
                            // ...
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        // Handle any errors
                        // ...
                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Handle any error that occurred during data retrieval
            }
        });

        dref3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Retrieve the value using getValue()
                boolean value = dataSnapshot.getValue(boolean.class);
                if (value){
                    prog += 20;
                    btn3= true;
                    b3.setBackgroundColor(Color.parseColor("#62a65e"));
                    refreshProgress();

                }

                dref6.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            RequestClass req = dataSnapshot.getValue(RequestClass.class);
                            if(Objects.equals(req.getBadgeId(), "b3")){
                                b3.setBackgroundColor(Color.parseColor("#e0cd22"));
                                b3.setEnabled(false);
                            }
                        } else {
                            // Data does not exist or is empty
                            // Handle the case accordingly
                            // ...
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        // Handle any errors
                        // ...
                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Handle any error that occurred during data retrieval
            }
        });

        dref4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Retrieve the value using getValue()
                boolean value = dataSnapshot.getValue(boolean.class);
                if (value){
                    prog += 20;
                    btn4 = true;
                    b4.setBackgroundColor(Color.parseColor("#62a65e"));
                    refreshProgress();
                }

                dref6.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            RequestClass req = dataSnapshot.getValue(RequestClass.class);
                            if(Objects.equals(req.getBadgeId(), "b4")){
                                b4.setBackgroundColor(Color.parseColor("#e0cd22"));
                                b4.setEnabled(false);
                            }
                        } else {
                            // Data does not exist or is empty
                            // Handle the case accordingly
                            // ...
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        // Handle any errors
                        // ...
                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Handle any error that occurred during data retrieval
            }
        });

        dref5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Retrieve the value using getValue()
                boolean value = dataSnapshot.getValue(boolean.class);
                if (value){
                    prog += 20;
                    btn5 = true;
                    b5.setBackgroundColor(Color.parseColor("#62a65e"));
                    refreshProgress();

                }

                dref6.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            RequestClass req = dataSnapshot.getValue(RequestClass.class);
                            if(Objects.equals(req.getBadgeId(), "b5")){
                                b5.setBackgroundColor(Color.parseColor("#e0cd22"));
                                b5.setEnabled(false);
                            }
                        } else {
                            // Data does not exist or is empty
                            // Handle the case accordingly
                            // ...
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        // Handle any errors
                        // ...
                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Handle any error that occurred during data retrieval
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!btn1){
                    buttonAlert("Badge 1", "b1");
                }

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!btn2){
                    buttonAlert("Badge 2", "b2");
                }

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!btn3){
                    buttonAlert("Badge 3", "b3");
                }

            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!btn4){
                    buttonAlert("Badge 4", "b4");
                }
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!btn5){
                    buttonAlert("Badge 5", "b5");
                }
            }
        });


        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        pb.setProgress(prog);
        pb_text.setText(prog + "%");
        // Update the toolbar title
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (activity != null) {
            ActionBar actionBar = activity.getSupportActionBar();
            if (actionBar != null) {
                actionBar.setTitle("Badges/Achievements");
            }
        }
    }

    public void buttonAlert(String title, String badgeId){
        AlertDialog.Builder ad = new AlertDialog.Builder(getActivity());
        ad.setTitle(title).setMessage("Set badge goal/description here").setCancelable(false).setPositiveButton("Complete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // update badge achievement to pending
                String userEmail;
                FirebaseAuth auth = FirebaseAuth.getInstance();
                FirebaseUser currentUser = auth.getCurrentUser();

                if (currentUser != null) {
                    userEmail = currentUser.getEmail();
                } else {
                    userEmail = " ";
                }

                String userId = userEmail.substring(0, userEmail.indexOf("@"));

                RequestClass request = new RequestClass(userEmail, badgeId, "pending");
                FirebaseDatabase.getInstance().getReference("requests/"+userId).setValue(request).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            refreshFragment(parseInt(badgeId.substring(1)));
                            Toast.makeText(getActivity(), "Request sent", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getActivity(), e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                    }
                });


//                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("badges/"+userId);
//                Map<String, Object> updates = new HashMap<>();
//                updates.put(badgeId, true);
//                databaseReference.updateChildren(updates);
//                refreshFragment(parseInt(badgeId.substring(1)));
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        AlertDialog alertDialog = ad.create();
        alertDialog.show();
    }

    public void refreshFragment(int id){
//        prog+=20;
        switch(id){
            case 1:
                b1.setBackgroundColor(Color.parseColor("#e0cd22"));
                btn1 = true;
                break;
            case 2:
                b2.setBackgroundColor(Color.parseColor("#e0cd22"));
                btn2 = true;
                break;
            case 3:
                b3.setBackgroundColor(Color.parseColor("#e0cd22"));
                btn3 = true;
                break;
            case 4:
                b4.setBackgroundColor(Color.parseColor("#e0cd22"));
                btn4 = true;
                break;
            case 5:
                b5.setBackgroundColor(Color.parseColor("#e0cd22"));
                btn5 = true;
                break;
        }

        refreshProgress();
    }

    public void refreshProgress(){
        pb.setProgress(prog);
        pb_text.setText(prog + "%");
    }
}