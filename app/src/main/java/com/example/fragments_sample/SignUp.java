package com.example.fragments_sample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        FirebaseAuth auth;
        EditText signupEmail, signupPassword;
        Button signupButton;
        TextView loginRedirectText;

        auth = FirebaseAuth.getInstance();
        signupEmail = findViewById(R.id.signup_email);
        signupPassword = findViewById(R.id.signup_password);
        signupButton = findViewById(R.id.signup_button);
        loginRedirectText = findViewById(R.id.loginRedirectText);

        signupButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String user = signupEmail.getText().toString().trim();
                String pass = signupPassword.getText().toString().trim();

                if(user.isEmpty()){
                    signupEmail.setError("E-mail field is empty");
                }

                if(pass.isEmpty()){
                    signupPassword.setError("Password field is empty");
                } else{
                    auth.createUserWithEmailAndPassword(user, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(SignUp.this, "Registration successful", Toast.LENGTH_SHORT).show();

                                // adding email to database
                                String userEmail = user;
                                String userId = user.substring(0, user.indexOf("@"));
                                BadgeDataClass bdc = new BadgeDataClass(userEmail, false, false, false, false, false);
                                FirebaseDatabase.getInstance().getReference("badges/"+userId).setValue(bdc).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if(task.isSuccessful()){
                                            finish();
                                        }
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(SignUp.this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                                    }
                                });

                                startActivity(new Intent(SignUp.this, LogIn.class));
                            } else {
                                Toast.makeText(SignUp.this, "Registration unsuccessful"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUp.this, LogIn.class));
            }
        });
    }
}