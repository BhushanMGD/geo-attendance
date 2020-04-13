package com.gmvcs.geoattendace;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class OTPActivity extends AppCompatActivity
{
    TextView mobileNumberText;
    String mobileNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_acitivity);
        //get mob number from intent
        mobileNumber=getIntent().getStringExtra("MOBILE_NUMBER");
        //set mobile number with message to show to the user
        mobileNumberText=findViewById(R.id.mobileNumberText);
        mobileNumberText.setText("Please enter the OTP sent on "+mobileNumber);


    }
}
