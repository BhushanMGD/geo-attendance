package com.gmvcs.geoattendace;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    EditText mobileNumber;
    Button loginButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //intialise views
        mobileNumber=findViewById(R.id.mobileNumber);
        loginButton=findViewById(R.id.loginButton);

        //set on  click listener for login
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //user has clicked login button
                //now read and validate mobile number
                String mob=mobileNumber.getText().toString();

            }
        });

    }
}
