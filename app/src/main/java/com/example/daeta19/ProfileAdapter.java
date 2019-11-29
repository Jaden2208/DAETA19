package com.example.daeta19;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ProfileAdapter extends BaseAdapter {
    private List<Profile> item;
    public ProfileAdapter(List<Profile> item){
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.profilegridview_item, parent, false);
        TextView txt_star = convertView.findViewById(R.id.txt_stars);
        TextView txt_score = convertView.findViewById(R.id.txt_score);
        TextView txt_sex = convertView.findViewById(R.id.txt_sex);
        TextView txt_career = convertView.findViewById(R.id.txt_career);
        TextView txt_location = convertView.findViewById(R.id.txt_location);
        TextView txt_time = convertView.findViewById(R.id.txt_time);

        Profile n = item.get(position);
        txt_star.setText(n.getStar());
        txt_score.setText(n.getScore());
        txt_sex.setText(n.getSex());
        txt_career.setText(n.getCareer());
        txt_location.setText(n.getLocation());
        txt_time.setText(n.getTime());

        return convertView;

    }
}
