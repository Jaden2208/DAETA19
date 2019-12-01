package com.example.daeta19;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {


    private Object GridView;
    private ListView search_list1;
    private ListView search_list2;
    private ListView search_list3;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        search_list1 = (ListView) getView().findViewById(R.id.search_list1);
        List<String> data1 = new ArrayList<>();

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(getContext(), R.layout.searchlistview_item, data1);
        search_list1.setAdapter(adapter1);

        data1.add("홍드로이드 유정");
        data1.add("안드로이드 유정");
        adapter1.notifyDataSetChanged();

        search_list2 = (ListView) getView().findViewById(R.id.search_list2);
        List<String> data2 = new ArrayList<>();

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(getContext(), R.layout.searchlistview_item, data2);
        search_list2.setAdapter(adapter2);

        data2.add("홍드로이드 유정");
        data2.add("안드로이드 유정");
        adapter2.notifyDataSetChanged();

        search_list3 = (ListView) getView().findViewById(R.id.search_list3);
        List<String> data3 = new ArrayList<>();

        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(getContext(), R.layout.searchlistview_item, data3);
        search_list3.setAdapter(adapter3);

        data3.add("홍드로이드 유정");
        data3.add("안드로이드 유정");
        adapter3.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }


}
