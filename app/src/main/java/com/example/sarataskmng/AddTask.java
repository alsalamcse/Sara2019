package com.example.sarataskmng;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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

        btnSave2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    private void dataHandler()
    {
        boolean isok=true;// if all fields filled well
        String title1=title.getText().toString();
        String subject1=subject.getText().toString();
        int seekbar=skbPio.getProgress();

        if (subject1.length()==0){
            subject.setError("enter tittle");
            isok=false;
        }
        if(title1.length()==0){
            title.setError("enter tittle");
            isok=false;
        }


    }
}
