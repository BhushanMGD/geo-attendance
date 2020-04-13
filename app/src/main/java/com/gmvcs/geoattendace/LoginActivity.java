package com.gmvcs.geoattendace;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class LoginActivity extends AppCompatActivity {
    EditText mobileNumber;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //intialise views
        mobileNumber = findViewById(R.id.mobileNumber);
        loginButton = findViewById(R.id.loginButton);

        //set on  click listener for login
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //user has clicked login button
                //now read and validate mobile number
                String mob = mobileNumber.getText().toString();
                boolean isValidated = validateMobile(mob);

                if (isValidated)
                {
                    //pass the phone number to OTP activity
                    //show OTP screen
                    Intent intent=new Intent(LoginActivity.this,OTPActivity.class);
                    intent.putExtra("MOBILE_NUMBER",mob);
                    startActivity(intent);
                } else {
                    //mobile number is wrong, show error to user
                    mobileNumber.setError("Please enter correct number");
                }

            }
        });
    }

    boolean validateMobile(String phoneNo) {
        //validate phone numbers of format "1234567890"
        if (phoneNo.matches("\\d{10}")) return true;
            //validating phone number with -, . or spaces
        else if (phoneNo.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) return true;
            //validating phone number with extension length from 3 to 5
        else if (phoneNo.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}")) return true;
            //validating phone number where area code is in braces ()
        else if (phoneNo.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) return true;
            //return false if nothing matches the input
        else return false;
    }
}
