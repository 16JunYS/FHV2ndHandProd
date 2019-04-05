package com.example.fhv2ndhandprod;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class RegisterActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private String fName;
    private String lName;
    private String Email;
    private String dbChild;
    private String PW;
    private DatabaseReference mDatabase;
    private User user;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();
    }

    public void Register(View view) {
        if(isEmptyEditText()); //check if there's any blanks
        else {
            if(isValidEmail(Email)) { //check if Email is valid
                mAuth.createUserWithEmailAndPassword(Email, PW).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            //TEMP))DEBUG
                            Toast.makeText(RegisterActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            //TEMP))DEBUG
                            Toast.makeText(RegisterActivity.this, "가입되었습니다", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(RegisterActivity.this, e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
            else {
                Toast.makeText(this, "잘못된 형식의 이메일입니다.", Toast.LENGTH_SHORT).show();
            }
            user = new User(fName, lName, Email, PW);
            Toast.makeText(this, "User created: "+dbChild, Toast.LENGTH_SHORT).show();
            mDatabase = FirebaseDatabase.getInstance().getReference();
            mDatabase.child("user").child(dbChild).setValue(user);

            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
            startActivity(intent);
            //finish();
        }
    }
    private boolean isEmptyEditText() {
        EditText edit_fName = findViewById(R.id.edit_fName);
        EditText edit_lName = findViewById(R.id.edit_lName);
        EditText edit_Email = findViewById(R.id.edit_regEmail);
        EditText edit_PW = findViewById(R.id.edit_regPW);

        lName = edit_lName.getText().toString();
        fName = edit_fName.getText().toString();
        Email = edit_Email.getText().toString();
        PW = edit_PW.getText().toString();
        if(fName.matches("") || lName.matches("") || Email.matches("") || PW.matches("") ) {
            Toast.makeText(this, "Please Fill Out the Blanks!", Toast.LENGTH_SHORT).show();
            return true;
        }
        int index;
        index = Email.indexOf("@");
        dbChild = Email.substring(0, index);
        return false;
    }
    private boolean isValidEmail(String Email) { //check for valid email
        return Patterns.EMAIL_ADDRESS.matcher(Email).matches();
    }
}
