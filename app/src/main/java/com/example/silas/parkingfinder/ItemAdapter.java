package com.example.silas.parkingfinder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by silas on 21.12.17.
 */

public class ItemAdapter extends ArrayAdapter {
    public ItemAdapter(@NonNull Context context, List items) {
        super(context, 0, items);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Item item = (Item) getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(this.getContext())
                    .inflate(R.layout.item_view, parent, false);
        }

        TextView name = convertView.findViewById((R.id.Pname));
        TextView status = convertView.findViewById(R.id.Pstatus);
        TextView space = convertView.findViewById(R.id.Pspace);

        name.setText(item.getName());
        name.setTextColor(Color.WHITE);
        status.setText(item.getStatus());
        if (item.getStatus().equals("open")){
            status.setTextColor(Color.GREEN);
        }else status.setTextColor(Color.RED);
        space.setText(Integer.toString(item.getFreeSpaces()));
        if (item.getFreeSpaces() <= 0){
            space.setTextColor(Color.RED);
        } else if (item.getFreeSpaces() <=10) {
            space.setTextColor(ResourcesCompat.getColor(getContext().getResources(), R.color.darkorange,null));
        } else if (item.getFreeSpaces() >=11){
            space.setTextColor(Color.GREEN);
        }
        return convertView;


    }



}
