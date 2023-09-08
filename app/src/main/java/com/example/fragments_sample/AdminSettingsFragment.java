package com.example.fragments_sample;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AdminSettingsFragment extends Fragment {

    String userEmail;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_admin_settings, container, false);

//        TextView user = view.findViewById(R.id.userName);
//        FirebaseAuth auth = FirebaseAuth.getInstance();
//        FirebaseUser currentUser = auth.getCurrentUser();
//
//        if (currentUser != null) {
//            userEmail = currentUser.getEmail();
//        }
//        String username = userEmail.substring(0, userEmail.indexOf("@"));
//        user.setText(username);

        // initialising list
        ListView settings = view.findViewById(R.id.settingsList);
        String[] listItems = new String[]{"Update E-mail Address", "Change Password"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1, android.R.id.text1, listItems);
        settings.setAdapter(adapter);

        settings.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String itemValue = (String) settings.getItemAtPosition(i);
                switch (itemValue) {
                    case "Change Password":
//                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//                        builder.setTitle("Change Password");
//
//                        // Set the custom layout for the dialog
//                        LayoutInflater inflater = getLayoutInflater();
//                        View dialogView = inflater.inflate(R.layout.dialog_layout, null);
//                        builder.setView(dialogView);
//
//                        // Get references to the text fields
//                        EditText textField1 = dialogView.findViewById(R.id.textField1);
//                        EditText textField2 = dialogView.findViewById(R.id.textField2);
//
//                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                String text1 = textField1.getText().toString();
//                                String text2 = textField2.getText().toString();
//
//                                if(text1!=text2){
//                                    textField1.setError("Passwords do not match");
//                                    textField2.setError("Passwords do not match");
//                                } else{
//                                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//                                    String newPassword = text1;
//
//                                    user.updatePassword(newPassword)
//                                            .addOnCompleteListener(new OnCompleteListener<Void>() {
//                                                @Override
//                                                public void onComplete(@NonNull Task<Void> task) {
//                                                    if (task.isSuccessful()) {
//                                                        Toast.makeText(getActivity(), "Password updated successfully", Toast.LENGTH_SHORT).show();
//                                                        dialog.dismiss();
//                                                    } else {
//                                                        Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
//                                                        dialog.dismiss();
//                                                    }
//                                                }
//                                            });
//                                }
//
//
//                            }
//                        });
//
//                        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                dialog.dismiss();
//                            }
//                        });
//
//                        AlertDialog dialog = builder.create();
//                        dialog.show();

                        break;

                    case "Update E-mail Address":
//                        AlertDialog.Builder email_builder = new AlertDialog.Builder(getActivity());
//                        email_builder.setTitle("Update E-mail");
//
//                        // Set the custom layout for the dialog
//                        LayoutInflater inflater1 = getLayoutInflater();
//                        View dialogView1 = inflater1.inflate(R.layout.dialog_layout1, null);
//                        email_builder.setView(dialogView1);
//
//                        // Get references to the text fields
//                        EditText field = dialogView1.findViewById(R.id.textField1);
//
//                        email_builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                String email = field.getText().toString();
//
//                                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//
//                                user.updateEmail(email)
//                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
//                                            @Override
//                                            public void onComplete(@NonNull Task<Void> task) {
//                                                if (task.isSuccessful()) {
//                                                    Toast.makeText(getActivity(), "Email updated successfully", Toast.LENGTH_SHORT).show();
//                                                    dialog.dismiss();
//                                                } else {
//                                                    Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
//                                                    dialog.dismiss();
//                                                }
//                                            }
//                                        });
//
//
//                            }
//                        });
//
//                        email_builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                dialog.dismiss();
//                            }
//                        });
//
//                        AlertDialog dialog1 = email_builder.create();
//                        dialog1.show();
                        break;

//                    case "Contact Your Administrator":
//                        // call associated admin (get phone number from database)
//                        break;
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
                actionBar.setTitle("Settings");
            }
        }

    }
}