package com.gmvcs.geoattendace;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class AddUserActivity extends AppCompatActivity {
    //views
    TextInputEditText firstNameEditText, lastName, email, mobileNumber, className, collegeId;
    Button signUp;
    RadioGroup genderRadioGroup;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_add);
        firebaseAuth = FirebaseAuth.getInstance();

        initializeViews();
    }

    private void initializeViews() {
        firstNameEditText = findViewById(R.id.firstNameEditText);
        lastName = findViewById(R.id.lastName);
        email = findViewById(R.id.email);
        mobileNumber = findViewById(R.id.mobileNumber);
        className = findViewById(R.id.className);
        collegeId = findViewById(R.id.collegeId);
        signUp = findViewById(R.id.signUp);
        genderRadioGroup = findViewById(R.id.genderRadioGroup);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyAndCreateUser();
            }
        });
    }

    private void verifyAndCreateUser() {
        //read screen input data
        String firstName = firstNameEditText.getText().toString();
        String lName = lastName.getText().toString();
        String emailId = email.getText().toString();
        String mobnumber = mobileNumber.getText().toString();
        String clasName = className.getText().toString();
        String clgid = collegeId.getText().toString();
        String gender;
        switch (genderRadioGroup.getCheckedRadioButtonId()) {
            case R.id.male:
                //do something
                gender = "MALE";
                break;
            case R.id.female:
                gender = "FEMALE";
                break;
            case R.id.other:
                gender = "OTHER";
                break;
        }
        //validate data

        //try to create user
        firebaseAuth.createUserWithEmailAndPassword(emailId, "123456")
                .addOnCompleteListener(AddUserActivity.this, new OnCompleteListener<AuthResult>() {
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (!task.isSuccessful()) {
                            Toast.makeText(AddUserActivity.this, "ERROR", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(AddUserActivity.this, "User created successfuly", Toast.LENGTH_SHORT).show();
                            //update user info
                        }
                    }
                });

    }
}
