package com.example.daeta19;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HireFragment extends Fragment {

    DatabaseReference mDatabase;
    FirebaseDatabase db;

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



        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        db = FirebaseDatabase.getInstance();
        mDatabase = db.getReference("users");
        //원하는 타겟의 정보 가져오기.
        mDatabase.child(uid).child("settings").child("ViewType").addListenerForSingleValueEvent(new ValueEventListener() {
            int viewtype ;
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                viewtype = Integer.parseInt(dataSnapshot.getValue().toString());
                gridView.setNumColumns(viewtype);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                gridView.setNumColumns(1);

            }
        });


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
