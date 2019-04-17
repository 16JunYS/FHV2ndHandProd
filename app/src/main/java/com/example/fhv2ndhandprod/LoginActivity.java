package com.example.fhv2ndhandprod;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private EditText edit_Email;
    private EditText edit_PW;
    private String userName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            //get events according to the changes in the state of the user
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    //user logged in
                    Toast.makeText(LoginActivity.this, "Welcome! " + userName, Toast.LENGTH_SHORT).show();
                }
                else {
                    //user logged out
                    Toast.makeText(LoginActivity.this, "Signed out", Toast.LENGTH_SHORT).show();
                }
            }
        };
    }

    @Override
    protected void onStart() {
        //check if user is already logged in
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) { //user is signed in
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }

    public void click_login(View view) {
        edit_Email = (EditText) findViewById(R.id.edit_Email);
        edit_PW = (EditText) findViewById(R.id.edit_PW);
        final String Email = edit_Email.getText().toString();
        final String PW = edit_PW.getText().toString();

        mAuth.signInWithEmailAndPassword(Email, PW).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                //checkTaskException(task);
                if (!task.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, "Sign in Failed", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(LoginActivity.this, "Welcome!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void click_register(View view) {
        //goes to Registration Form
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }
}
