package com.example.sarataskmng;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

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
            isok=false;
        }
        if(fname.length()==0)
        {
            tvFname.setError("enter name");
            isok=false;
        }
        if(isok)
        {
            createAcount(email,passwl,fname,lname,phone);
            //createAcount(email,passl);


        }
    }

    private void createAcount(String email, String passwl, String fname, String lname,String phone){
        FirebaseAuth auth=FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(email,passwl).
                addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            finish();
                        }
                        else{
                            tvEmail.setError("sign up failed");
                        }
                    }
                });
    }

}
