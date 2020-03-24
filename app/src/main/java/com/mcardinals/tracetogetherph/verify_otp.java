package com.mcardinals.tracetogetherph;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class verify_otp extends AppCompatActivity {
    Button btnOTP;
    EditText txtOTP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_otp);

        btnOTP = (Button) findViewById(R.id.btnSubmitOTP); //variable for the submit OTP button
        txtOTP = (EditText) findViewById(R.id.txtOTP); //variable for the OTP text

        //Event listener for the submit OTP button
        btnOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Verify if the OTP is valid (to be implemented)

                //Go to next screen and setup the enter OTP UI
                Intent goToSignUpForm = new Intent(verify_otp.this, sign_up.class);
                startActivity(goToSignUpForm);



            }
        });


    }
}
