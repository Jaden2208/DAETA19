package com.example.daeta19;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class HireFragment extends Fragment {

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ArrayList<Hire> data = new ArrayList<>();
        String store = "매장명 위치";
        String todo ="일하는 내용";
        String date_day ="날짜";
        String time = "일하는 시간";
        String pay = "시간당 급여";


        data.add(new Hire("스타벅스 이문점","음료제조, 매장관리","10.30 화",
                "11:00AM ~ 03:00PM","8350"));
        data.add(new Hire("스타벅스 회기점","음료제조, 매장관리","10.30 화",
                "11:00AM ~ 03:00PM","8350"));
        data.add(new Hire("스타벅스 신설점","음료제조, 매장관리","10.30 화",
                "11:00AM ~ 03:00PM","8350"));
        data.add(new Hire("스타벅스 모현점","음료제조, 매장관리","10.30 화",
                "11:00AM ~ 03:00PM","8350"));
        data.add(new Hire("스타벅스 이문점","음료제조, 매장관리","10.30 화",
                "11:00AM ~ 03:00PM","8350"));
        data.add(new Hire("스타벅스 모현점","음료제조, 매장관리","10.30 화",
                "11:00AM ~ 03:00PM","8350"));
        data.add(new Hire("스타벅스 모현점","음료제조, 매장관리","10.30 화",
                "11:00AM ~ 03:00PM","8350"));

        HireAdapter adapter = new HireAdapter(data);
        View view = inflater.inflate(R.layout.fragment_hire, container, false);
        gridView = (GridView)view.findViewById(R.id.hire_grid_view);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), PostHireActivity.class);
                startActivity(intent);
            }
        });

        return view;

    }
    private GridView gridView;
}
