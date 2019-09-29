package com.example.sarataskmng;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {

    private EditText tvFname;
    private EditText tvLaName;
    private EditText tvPhone;
    private EditText tvEmail;
    private EditText tvPass;
    private EditText tvRePass;
    private Button btnSave;

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
        btnSave=(Button)findViewById(R.id.btnSave);

       btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHandler();
            }
        });


    }

    private void dataHandler()
    {
        boolean isok=true;// if all fields filled well
        String email=tvEmail.getText().toString();
        String passwl=tvPass.getText().toString();
        String passw2=tvRePass.getText().toString();
        String fname=tvFname.getText().toString();
        String lname=tvLaName.getText().toString();
        String phone=tvPhone.getText().toString();
        if(email.length()<4||
                email.indexOf('@')<0||
                email.indexOf('.')<0)
        {
            tvEmail.setError("Wrong Email");
            isok=false;
        }
        if(passwl.length()<8 || passwl.equals(passw2)==false)
        {
            tvRePass.setError("Have to be at least 8 char and the same password");
            tvPass.setError("Have to be at least 8 char and the same password");
        }
    }


}
