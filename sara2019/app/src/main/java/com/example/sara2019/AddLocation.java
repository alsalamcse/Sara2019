package com.example.sara2019;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sara2019.data.MyOrder;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddLocation extends AppCompatActivity {

    private EditText etLoc;
    private EditText etAddDes;
    private Button btnSave;
    private SeekBar skbPio;
    private TextView tvPior;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_location);

        etLoc=(EditText)findViewById(R.id.etLoc);
        etAddDes=(EditText)findViewById(R.id.etAddDes);
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
        String destination=etAddDes.getText().toString();
        int seekbar=skbPio.getProgress();

        if (location.length()==0){
            etLoc.setError("enter location");
            isok=false;
        }
        if(destination.length()==0){
            etLoc.setError("enter location");
            isok=false;
        }

        if(isok)
        {
            MyOrder o=new MyOrder();
            o.setLocation(location);
            o.setAdress(destination);
            createMyOrder(o);





        }

    }

    private void createMyOrder(MyOrder o)
    {
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        //.2
        DatabaseReference reference = database.getReference();
        FirebaseAuth auth=FirebaseAuth.getInstance();//to get the user uid (or other details like email)
        String uid = auth.getCurrentUser().getUid();
        o.setAdress(uid);

        String key = reference.child("order").push().getKey();
        o.setKey(key);

        reference.child("order").child(uid).child(key).setValue(o).addOnCompleteListener(AddLocation.this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(AddLocation.this, "add successful", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else {
                    Toast.makeText(AddLocation.this, "add failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }
            }
        });
    }

    }



