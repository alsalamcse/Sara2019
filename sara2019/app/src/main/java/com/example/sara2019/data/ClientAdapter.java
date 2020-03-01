package com.example.sara2019.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.sara2019.R;

public class ClientAdapter extends ArrayAdapter<MyOrder>
{


    public ClientAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View vitem= LayoutInflater.from(getContext()).inflate(R.layout.trackeritem,parent,false);

        TextView clientName=vitem.findViewById(R.id.tvItemClientName);
        TextView clientPhone=vitem.findViewById(R.id.tvClientPhone);

      final   MyOrder myOrder=getItem(position);

        clientName.setText(myOrder.getName());
        clientPhone.setText(myOrder.getPhone());


        return vitem;

    }
}
