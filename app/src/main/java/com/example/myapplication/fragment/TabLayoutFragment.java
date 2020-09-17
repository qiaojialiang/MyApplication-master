package com.example.myapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.adapter.DemoAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by QiaoJiaLiang
 * Created on 2020/9/3
 **/
public class TabLayoutFragment extends Fragment {
    private View view;
    private RecyclerView mRecyclerView;
    private DemoAdapter mAdapter;
    private List<String> dataList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_tablayout, container, false);
        }
        initView();
        return view;
    }

    private void initView() {
        mRecyclerView = view.findViewById(R.id.fragment_recycle);
        for (int i = 0; i < 16; i++) {
            dataList.add("数据" + i);
        }
        mAdapter = new DemoAdapter(R.layout.item_price, dataList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);
    }
}
