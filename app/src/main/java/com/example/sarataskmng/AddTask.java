package com.example.sarataskmng;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

public class AddTask extends AppCompatActivity {

    private EditText title;
    private EditText subject;
    private Button btnSave2;
    private SeekBar skbPio;
    private EditText tvPio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        title=(EditText)findViewById(R.id.title);
        subject=(EditText)findViewById(R.id.subject);
        btnSave2=(Button) findViewById(R.id.btnSave2);
        skbPio=(SeekBar)findViewById(R.id.skbPio);
        tvPio=(EditText)findViewById(R.id.tvPio);

    }
}
