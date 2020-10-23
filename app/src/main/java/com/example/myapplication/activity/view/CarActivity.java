package com.example.myapplication.activity.view;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.myapplication.AppConstants;
import com.example.myapplication.R;
import com.example.myapplication.activity.presenter.CarContract;
import com.example.myapplication.activity.presenter.CarPresenter;
import com.example.myapplication.base.BaseMvpActivity;
import com.example.myapplication.bean.CarBean;

import java.util.List;

public class CarActivity extends BaseMvpActivity<CarPresenter> implements CarContract.CarView {

    public static void start(Context context) {
        Intent intent = new Intent(context, CarActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void showCarList(List<CarBean> list) {
        for (int i = 0; i <list.size() ; i++) {
            Log.e("carNameList",list.get(i).getName()+"");
        }

    }

    @Override
    protected CarPresenter createPresenter() {
        return new CarPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_car;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void getData() {
        mPresenter.getCarList(AppConstants.appKey);
    }

    @Override
    public void onProgress(long totalSize, long downSize) {

    }
}
