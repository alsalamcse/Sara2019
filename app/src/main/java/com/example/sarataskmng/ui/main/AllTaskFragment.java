package com.example.sarataskmng.ui.main;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.sarataskmng.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import data.MyTask;
import data.TasksAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllTaskFragment extends Fragment {

    private TasksAdapter tasksAdapter;
    private ListView lvTasks;




    public AllTaskFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        tasksAdapter=new TasksAdapter(getContext(),R.layout.taskitem);
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all_task, container, false);
        lvTasks=view.findViewById(R.id.lstTasks);
        return view;
    }

    public void readTaskFromFirebase(){
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        FirebaseAuth auth=FirebaseAuth.getInstance();
        String uid = auth.getUid();
        DatabaseReference reference = database.getReference();
        reference.child("tasks").child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                for (DataSnapshot d: dataSnapshot.getChildren())
                {
                    MyTask t =d.getValue(MyTask.class);
                    Log.d("MyTask",t.toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
