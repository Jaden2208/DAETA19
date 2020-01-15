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

public class EmployeeFragment extends Fragment {

    DatabaseReference mDatabase;
    FirebaseDatabase db;
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

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        db = FirebaseDatabase.getInstance();
        mDatabase = db.getReference("users");

        mDatabase.child(uid).child("settings").child("ViewType").addListenerForSingleValueEvent(new ValueEventListener() {
            int viewtype ;
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if((dataSnapshot.getValue()) !=null){
                    viewtype = Integer.parseInt(dataSnapshot.getValue().toString());
                    gridView.setNumColumns(viewtype);
                }
                else{
                    gridView.setNumColumns(1);
                }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                }
            });


        //원하는 타겟의 정보 가져오기.

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
