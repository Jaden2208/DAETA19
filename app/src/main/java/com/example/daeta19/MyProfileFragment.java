package com.example.daeta19;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyProfileFragment extends Fragment {


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.send_btn:
                Intent intent = new Intent(getActivity(), WritingProfileActivity.class);
                startActivity(intent);
                break;
        }}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_profile, container, false);


    }

}

