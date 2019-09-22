package com.example.sarataskmng;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class SignIn extends AppCompatActivity {

    private ImageView img;
    private EditText tvEmail2 ;
    private EditText etPass;
    private Button btnIn;
    private Button btnUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        img=(ImageView)findViewById(R.id.img);
        tvEmail2=(EditText)findViewById(R.id.tvEmail2);
        etPass=(EditText)findViewById(R.id.etPass);
        btnIn=(Button)findViewById(R.id.btnIn);
        btnUp=(Button)findViewById(R.id.btnUp);

        btnIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datahandler();
            }
        });

    }



    private void datahandler(){
        String email=tvEmail2.getText().toString();
        String passw=etPass.getText().toString();
    }




}
