package com.example.sarataskmng;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class Setting extends AppCompatActivity {


    private Switch stSound;
    private SeekBar skbFrontSize;
    private Button btnSave;
    private EditText tvFrontSize;
    private EditText tvSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        stSound=(Switch)findViewById(R.id.stSound);
        skbFrontSize=(SeekBar)findViewById(R.id.skbFrontSize);
        btnSave=(Button)findViewById(R.id.btnSave);
        tvFrontSize=(EditText) findViewById(R.id.tvFrontSize);
        tvSound=(EditText) findViewById(R.id.tvSound);

    }
}
