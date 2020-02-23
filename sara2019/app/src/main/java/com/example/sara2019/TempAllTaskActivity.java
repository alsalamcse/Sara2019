package com.example.sara2019;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class TempAllTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_all_task);
        Intent intent=new Intent(getApplication(),AddLocation.class);
        startActivity(intent);
    }
}
