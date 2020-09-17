package com.example.myapplication.activity.view;

import android.content.Context;
import android.content.Intent;

import com.example.myapplication.R;
import com.example.myapplication.activity.presenter.GetPostDemoContract;
import com.example.myapplication.activity.presenter.GetPostDemoPresenter;
import com.example.myapplication.base.BaseMvpActivity;
import com.example.myapplication.bean.PriceBean;

import java.util.List;


/**
 * Created by QiaoJiaLiang
 * Created on 2020/8/21
 **/
public class GetPostDemoActivity extends BaseMvpActivity<GetPostDemoPresenter> implements GetPostDemoContract.GetPostDemoView {

    public static void start(Context context) {
        Intent intent = new Intent(context, GetPostDemoActivity.class);
        context.startActivity(intent);
    }


    @Override
    public void onPostDemo(List<PriceBean> s) {

    }

    @Override
    protected GetPostDemoPresenter createPresenter() {
        return new GetPostDemoPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void getData() {
        mPresenter.getPostDemo("1");
    }


    @Override
    public void onProgress(long totalSize, long downSize) {

    }


}
