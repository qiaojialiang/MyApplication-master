package com.example.myapplication.activity.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.AppConstants;
import com.example.myapplication.R;
import com.example.myapplication.utils.HttpUtils;

import java.io.IOException;

import okhttp3.FormBody;

public class NewsFragment extends Fragment {
    private View view;
    private HttpUtils httpUtils;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_news, null);
        return view;
    }

    @Override
    public void onStart() {
        intiView();
        getUtils();
        super.onStart();
    }

    private void intiView() {
        httpUtils = new HttpUtils();
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void getUtils() {
        FormBody.Builder formBody = new FormBody.Builder();
        formBody.add("appkey", AppConstants.appKey);
        formBody.add("channel", "头条");
        formBody.add("num", "10");
        formBody.add("start", "0");
        httpUtils.getPost(AppConstants.BASE_NEWS_URL, 0, formBody);
        httpUtils.setMyHttpCallBack(new HttpUtils.HttpCallBack() {
            @Override
            public void onSuccess(String response, int flag) {
                if (flag == 0) {

                }
            }

            @Override
            public void onError(IOException e) {

            }
        });
    }



}
