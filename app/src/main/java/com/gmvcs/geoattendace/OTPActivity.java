package com.gmvcs.geoattendace;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class OTPActivity extends AppCompatActivity
{
    TextView mobileNumberText;
    Button verifyBtn;
    EditText otp;

    String mobileNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_acitivity);
        //init views
        otp=findViewById(R.id.otpEditText);
        verifyBtn =(Button) findViewById(R.id.verifyBtn);
        mobileNumberText = findViewById(R.id.mobileNumberText);

        //get mob number from intent
        mobileNumber = getIntent().getStringExtra("MOBILE_NUMBER");
        //set mobile number with message to show to the user
        mobileNumberText.setText("Please enter the OTP sent on " + mobileNumber);

        verifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String otpNumber=otp.getText().toString();

               // Toast.makeText(OTPActivity.this,otpNumber,Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(OTPActivity.this);
                builder.setTitle("Alert!!");
                builder.setMessage("otp is wrong")
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // FIRE ZE MISSILES!
                            }
                        })
                        .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User cancelled the dialog
                            }
                        });
                // Create the AlertDialog object and return it
                 builder.show();
            }
        });


    }
}
