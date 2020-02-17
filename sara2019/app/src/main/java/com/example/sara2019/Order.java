package com.example.sara2019;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class Order extends AppCompatActivity {

    private EditText etLocat;
    private EditText etDest;
    private EditText etPhoneNum;
    private EditText etOrderNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        etLocat=(EditText)findViewById(R.id.etLocat);
        etDest=(EditText)findViewById(R.id.etDest);
        etPhoneNum=(EditText)findViewById(R.id.etPhoneNum);
        etOrderNum=(EditText)findViewById(R.id.etOrderNum);
    }
}
