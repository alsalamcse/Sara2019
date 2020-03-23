package com.example.sara2019.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.sara2019.R;
//1                        //2 extends...
public class ClientAdapter extends ArrayAdapter<MyOrder>
{

    //3 fix error
    public ClientAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    //4 override getview
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //4.1 build item XML view
        View view= LayoutInflater.from(getContext()).inflate(R.layout.trackeritem,parent,false);

        //4.2 findviewbyid
        TextView clientName=view.findViewById(R.id.tvitname);
        TextView clientPhone=view.findViewById(R.id.tvitPhone);
     //   Button clientBtn=view.findViewById(R.id.btnitmUpd);

        //4.3 get data object
         final MyOrder myOrder=getItem(position);

         //4.4 set object data on the view
       // clientName.setText(myOrder.getName());
        clientPhone.setText(myOrder.getPhone());

        //4.5 add event listner
    //    clientName.setOnClickListener(new View.OnClickListener() {
     //       @Override
        //
        //       public void onClick(View v) {
    //           Toast.makeText(getContext(), "update"+myOrder.getUpdate(), Toast.LENGTH_SHORT).show();
     //       }
    //    });

        //4.6
        return view;

    }
}
