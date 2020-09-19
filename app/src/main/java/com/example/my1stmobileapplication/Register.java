package com.example.my1stmobileapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class register extends AppCompatActivity{
    EditText mFullName,mEmail,mPassword,mPhoneNumber;
    Button mRegisterBtn;
    TextView mLoginBtn;
    FirebaseAuth fAuth;


public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFullName = findViewById(R.id.fullName);
        mEmail    = findViewById(R.id.Email);
                mPassword = findViewById(R.id.Password);
                        mPhoneNumber = findViewById(R.id.PhoneNumber);

                        fAuth = FirebaseAuth.getInstance();

                        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                String email = mEmail.getText().toString().trim();
                                String password = mPassword.getText().toString().trim();

                                if(TextUtils.isEmpty(email)) {
                                    mEmail.setError("Email is required.");
                                    return;
                                }
                                if(TextUtils.isEmpty(password)){
                                    mPassword.setError("Password is required");
                                    return;
                                }
                                if(password.length()<6){
                                    mPassword.setError("Password must be >=6 characters");
                                    return;
                                }

                                // register the user in firebase

                                fAuth.createUserWithEmailAndPassword(.addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (task.isSuccessful()){
                                            Toast.makeText(Register.this, "User Created.", Toast.LENGTH_SHORT).show();
                                            startActivity(new Intent(getApplicationContext(),MainActivity.class));

                                        }
                                        else
                                        {
                                            Toast.makeText(Register.this, "Error! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }))
                            }
                            }

                        }

    }
}