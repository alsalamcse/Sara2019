package com.example.sarataskmng;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import data.MyTask;

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

        if(isok)
        {
            MyTask t=new MyTask();
            t.setTitle(title1);
            createMyTask(t);
        }

    }

    private void createMyTask(MyTask t)
    {
        //.1
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        //.2
        DatabaseReference reference = database.getReference();
        String key = reference.child("tasks").push().getKey();
        reference.child("tasks").child(key).setValue(t).addOnCompleteListener(AddTask.this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(AddTask.this, "add successful", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else {
                    Toast.makeText(AddTask.this, "add failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }
            }
        });
        }
}
