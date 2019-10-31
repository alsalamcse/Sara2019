package com.example.sara2019;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class AddLocation extends AppCompatActivity {

    private EditText etLoc;
    private EditText etAddress;
    private Button btnSave;
    private SeekBar skbPio;
    private TextView tvPior;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_location);

        etLoc=(EditText)findViewById(R.id.etLoc);
        etAddress=(EditText)findViewById(R.id.etAddress);
        btnSave=(Button)findViewById(R.id.btnSave);
        skbPio=(SeekBar)findViewById(R.id.SeekBar);
        tvPior=(TextView)findViewById(R.id.tvPior);

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
        String location=etLoc.getText().toString();
        String address=etAddress.getText().toString();
        int seekbar=skbPio.getProgress();

        if (location.length()==0){
            etLoc.setError("enter location");
            isok=false;
        }
        if(address.length()==0){
            etLoc.setError("enter location");
            isok=false;
        }

        if(isok)
        {




        }

    }


}
