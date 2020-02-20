package com.example.sara2019;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class DeliveryWorker extends AppCompatActivity {

    private Button btnAccept;
    private Button btnReject;
    private Button btnWait;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_worker);

        btnAccept=(Button)findViewById(R.id.btnAccept);
        btnReject=(Button)findViewById(R.id.btnReject);
        btnWait=(Button)findViewById(R.id.btnWait);

    }
}
