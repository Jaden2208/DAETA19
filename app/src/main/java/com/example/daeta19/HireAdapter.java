package com.example.daeta19;

import android.media.Image;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import java.util.List;

public class HireAdapter extends BaseAdapter {
    private List<Hire> item;
    public HireAdapter(List<Hire> item){
        this.item = item;
    }
    @Override
    public int getCount() {
        return item.size();
    }

    @Override
    public Object getItem(int position) { return item.get(position); }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.hiregridview_item, parent, false);

        TextView txt_store = convertView.findViewById(R.id.txt_store);
        TextView txt_todo = convertView.findViewById(R.id.txt_todo);
        TextView txt_date_day = convertView.findViewById(R.id.txt_date_day);
        TextView txt_time = convertView.findViewById(R.id.txt_time);
        TextView txt_pay = convertView.findViewById(R.id.txt_pay);
        //ImageView store_img = convertView.findViewById(R.id.store_img);

        Hire L = item.get(position);
       // store_img.setImageIcon(L.getStore_img());
        txt_store.setText(L.getStore());
        txt_todo.setText(L.getTodo());
        txt_date_day.setText(L.getDate_day());
        txt_time.setText(L.getTime());
        txt_pay.setText(L.getPay());

        return convertView;
    }
}
