package com.example.daeta19;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class EmployeeFragment extends Fragment {
    private ArrayList<Profile> data = null;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        data = new ArrayList<>();
        int k = 5;
        int k2 = 2;
        String star ="";
        String star2 = "";
        String m = "남";
        String w = "여";
        for(int i=0;i<k;i++){
            star +="★ ";
        }
        for(int i=0;i<5-k;i++){
            star +="☆ ";
        }

        for(int i=0;i<k2;i++){
            star2 +="★ ";
        }
        for(int i=0;i<5-k2;i++){
            star2 +="☆ ";
        }
        data.add(new Profile(star,"("+k+")","성별 : "+m,"career","location","time", "DK",24,10));
        data.add(new Profile(star,"("+k+")","성별 : "+m,"career","location","time", "DK",24,0));
        data.add(new Profile(star2,"("+k2+")","성별 : "+m,"career","location","time", "DK",24,0));
        data.add(new Profile(star,"("+k+")","성별 : "+m,"career","location","time", "DK",24,0));
        data.add(new Profile(star2,"("+k2+")","성별 : "+m,"career","location","time", "DK",24,0));

        ProfileAdapter adapter = new ProfileAdapter(data);
        View view = inflater.inflate(R.layout.fragment_employee, container,false);

        gridView = (GridView) view.findViewById(R.id.grid_view);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), ProfileActivity.class);

                intent.putExtra("star", (String) data.get(position).getStar());
                intent.putExtra("score", (String) data.get(position).getScore());
                intent.putExtra("sex", (String) data.get(position).getSex());
                intent.putExtra("career", (String) data.get(position).getCareer());
                intent.putExtra("location", (String) data.get(position).getLocation());
                intent.putExtra("time", (String) data.get(position).getTime());
                intent.putExtra("name", (String) data.get(position).getName());
                intent.putExtra("age", (int) data.get(position).getAge());
                intent.putExtra("count", (int) data.get(position).getCount());
                startActivity(intent);
            }
        });
        return view;
    }
private GridView gridView;
}
