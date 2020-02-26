package com.example.sara2019;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignIn extends AppCompatActivity {


    private EditText tvEmail2 ;
    private EditText etPass;
    private Button btnIn;
    private Button btnUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        tvEmail2=(EditText)findViewById(R.id.tvEmail2);
        etPass=(EditText)findViewById(R.id.etPass);
        btnIn=(Button)findViewById(R.id.btnIn);
        btnUp=(Button)findViewById(R.id.btnUp);
        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplication(),SignUp.class);
                startActivity(i);

            }
        });

        btnIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datahandler();
            }
        });

    }



    private void datahandler()
    {
        String email=tvEmail2.getText().toString();
        String passw=etPass.getText().toString();
        boolean isok=true;
//        if(email.length()<4)
//        {
//            tvEmail2.setError("Email Lenght error");
//            isok=false;
//        }
//
//        if(email.indexOf("@")<0 || email.indexOf(".")<0)
//        {
//            tvEmail2.setError("email wrong format");
//            isok=false;
//
//        }
//        if(passw.length()<8){
//            etPass.setError("min lenght 8");
//            isok=false;
//        }
        if(isValidEmailAddress(email)==false)
        {
            tvEmail2.setError("Invalid Email");
            isok=false;
        }
        if(passw.length()<8)
        {
            etPass.setError("min length 8");
            isok=false;
        }
        if(isok)
        {
            signIn(email,passw);
        }

    }

    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }


    private void signIn(String email, String passw){
        FirebaseAuth auth=FirebaseAuth.getInstance();
        auth.signInWithEmailAndPassword(email,passw).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    // todo go to main screen (all task activity)
                    Intent i=new Intent(getApplication(),TempAllTaskActivity.class);
                    startActivity(i);
                }
                else
                {
                    tvEmail2.setError("email or password is wrong");
                }

            }
        });

    }




}
