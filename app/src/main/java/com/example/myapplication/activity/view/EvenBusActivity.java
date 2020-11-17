package com.example.myapplication.activity.view;

import android.content.Context;
import android.content.Intent;


import com.example.myapplication.R;
import com.example.myapplication.base.BaseNewActivity;


public class EvenBusActivity extends BaseNewActivity {

    public static void start(Context context) {
        Intent intent = new Intent(context, EvenBusActivity.class);
        context.startActivity(intent);
    }


    @Override
    protected int initLayout() {
        return R.layout.activity_even_bus;
    }

    @Override
    protected void initView() {

    }
}
