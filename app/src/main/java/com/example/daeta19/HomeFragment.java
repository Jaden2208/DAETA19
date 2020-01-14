package com.example.daeta19;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class HomeFragment extends Fragment {

    private Button btn_changeHome;
    private Button detail;
    private Boolean isHirePage = true;
    private HireFragment hireFragment;
    private EmployeeFragment employeeFragment;
    private TextView salary_grade_order;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        salary_grade_order = (TextView) getView().findViewById(R.id.salary_grade_order);
        // 첫 화면 초기화
        hireFragment = new HireFragment();
        employeeFragment = new EmployeeFragment();
        getChildFragmentManager().beginTransaction()
                .replace(R.id.homeViewPager, hireFragment).commit();

        btn_changeHome = (Button) getView().findViewById(R.id.btn_changeHome);
        // 버튼 클릭시 화면 전환

        btn_changeHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isHirePage){
                    getChildFragmentManager().beginTransaction()
                            .replace(R.id.homeViewPager, employeeFragment).commit();
                    isHirePage = false;
                    btn_changeHome.setText("구인공고");
                    salary_grade_order.setText("급여순");
                }
                else{

                    getChildFragmentManager().beginTransaction()
                            .replace(R.id.homeViewPager, hireFragment).commit();
                    isHirePage = true;
                    btn_changeHome.setText("인재정보");
                    salary_grade_order.setText("평점순");
                }
            }
        });

        detail = (Button) getView().findViewById(R.id.detail);
        

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

}
