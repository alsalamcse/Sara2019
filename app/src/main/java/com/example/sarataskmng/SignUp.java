package com.example.sarataskmng;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {

    private EditText tvFname;
    private EditText tvLaName;
    private EditText tvPhone;
    private EditText tvEmail;
    private EditText tvPass;
    private EditText tvRePass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        tvFname=(EditText)findViewById(R.id.tvFName);
        tvLaName=(EditText)findViewById(R.id.tvLaName);
        tvPhone=(EditText)findViewById(R.id.tvPhone);
        tvEmail=(EditText)findViewById(R.id.tvEmail);
        tvPass=(EditText)findViewById(R.id.tvPass);
        tvRePass=(EditText)findViewById(R.id.tvRePass);

    }
}
