package com.mcardinals.tracetogetherph;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

public class get_phone_number extends AppCompatActivity {
    Button btnSubmit;
    EditText txtPhoneNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_phone_number);

        btnSubmit = (Button) findViewById(R.id.btnSubmitPhoneNum); //variable for the Submit phone number button
        txtPhoneNum = (EditText) findViewById(R.id.txtPhoneNum); //variable for the phone number

        //The event listener for submit button
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Send the phone number to the server, etc. (To be implemented)

                //implement validation for phone number. (to be implemented)
                //If num<11, display an error.

                //Go to next screen and setup the enter OTP UI
                Intent goToOTP = new Intent(get_phone_number.this, verify_otp.class);
                startActivity(goToOTP);



            }
        });
    }
}
