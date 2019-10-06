package com.example.sara2019;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Thread th=new Thread() {
            public void run() {
                try {
                    sleep(3 * 1000);
                    Intent i=new Intent(getApplication(),SignIn.class);
                    startActivity(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ;
            }
        };
        th.start();


    }


}
