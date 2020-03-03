package com.example.sara2019;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.sara2019.data.ClientAdapter;
import com.example.sara2019.data.MyOrder;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
//5 new activty
//5.1 add ListView to the XMl

public class MyOrdersActivity extends AppCompatActivity {

    //5.2
    private ListView listView;
    private ClientAdapter myOrdersAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_orders);

        //5.3
        listView=findViewById(R.id.listView);
        myOrdersAdapter=new ClientAdapter(getBaseContext(),R.layout.trackeritem);
        listView.setAdapter(myOrdersAdapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        readTaskFromFirebase();
    }

    // download data from firebasa
    public void readTaskFromFirebase(){
        FirebaseDatabase database=FirebaseDatabase.getInstance();// to connect to database
        FirebaseAuth auth=FirebaseAuth.getInstance();// to get current user UID
        String uid = auth.getUid();
        DatabaseReference reference = database.getReference();

        //5.6 add listner to update us about any change
        //change group name
        reference.child("orders").child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                //5.7
                myOrdersAdapter.clear();
                for (DataSnapshot d: dataSnapshot.getChildren())
                {
                    //5.8
                    MyOrder t =d.getValue(MyOrder.class);
                    Log.d("MyOrder",t.toString());
                    myOrdersAdapter.add(t);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
