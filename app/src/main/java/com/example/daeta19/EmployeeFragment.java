package com.example.daeta19;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class EmployeeFragment extends Fragment {

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ArrayList<Profile> data = new ArrayList<>();
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
        data.add(new Profile(star,"("+k+")","성별 : "+m,"career","location","time"));
        data.add(new Profile(star,"("+k+")","성별 : "+w,"career","location","time"));
        data.add(new Profile(star2,"("+k2+")","성별 : "+m,"career","location","time"));
        data.add(new Profile(star,"("+k+")","성별 : "+w,"career","location","time"));
        data.add(new Profile(star2,"("+k2+")","성별 : "+m,"career","location","time"));

        ProfileAdapter adapter = new ProfileAdapter(data);
        View view = inflater.inflate(R.layout.fragment_employee, container,false);

        gridView = (GridView) view.findViewById(R.id.grid_view);
        gridView.setAdapter(adapter);
        return view;
    }
private GridView gridView;
}
