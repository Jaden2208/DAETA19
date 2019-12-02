package com.example.daeta19;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class MainPagerAdapter extends FragmentStatePagerAdapter {
    int numOfTabs;

    public MainPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.numOfTabs = behavior;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                HomeFragment tab1 = new HomeFragment(); // 인재정보
                return tab1;
            case 1:
                SearchFragment tab2 = new SearchFragment(); // 구인공고
                return tab2;
            case 2:
                MyProfileFragment tab3 = new MyProfileFragment(); // 내정보
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
