package com.example.myapplication.kt.view;

import com.example.myapplication.AppConstants;
import com.example.myapplication.R;
import com.example.myapplication.base.BaseMvpActivity;
import com.example.myapplication.bean.WeatherBean;
import com.example.myapplication.kt.presenter.TianQiContract;
import com.example.myapplication.kt.presenter.TianQiPresenter;

public class TianqiActivity extends BaseMvpActivity<TianQiPresenter> implements TianQiContract.TianQiView {

    @Override
    protected TianQiPresenter createPresenter() {
        return new TianQiPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_tianqi;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void getData() {
       mPresenter.getWeatherList(AppConstants.appKey,"成都");
    }

    @Override
    public void showTianQiList(WeatherBean weatherBean) {

    }

    @Override
    public void onProgress(long totalSize, long downSize) {

    }
}
