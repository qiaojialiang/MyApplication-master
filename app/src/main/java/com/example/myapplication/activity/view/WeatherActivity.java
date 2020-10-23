package com.example.myapplication.activity.view;

import android.content.Context;
import android.content.Intent;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.AppConstants;
import com.example.myapplication.R;
import com.example.myapplication.activity.presenter.WeatherContract;
import com.example.myapplication.activity.presenter.WeatherPresenter;
import com.example.myapplication.adapter.WeatherAdapter;
import com.example.myapplication.base.BaseMvpActivity;
import com.example.myapplication.bean.WeatherBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class WeatherActivity extends BaseMvpActivity<WeatherPresenter>  implements WeatherContract.WeatherView {


    @BindView(R.id.recyclerView_weather)
    RecyclerView mRecycleView;
    private WeatherAdapter mAdapter;
    private List<WeatherBean.PositionBean> positionBeans=new ArrayList<>();


    public static void start(Context context) {
        Intent intent =new Intent(context,WeatherActivity.class);
        context.startActivity(intent);
    }


    @Override
    protected WeatherPresenter createPresenter() {
        return new WeatherPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_weather;
    }

    @Override
    protected void initView() {
        mAdapter=new WeatherAdapter(R.layout.item_layout,positionBeans);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));
        mRecycleView.setAdapter(mAdapter);
    }

    @Override
    protected void getData() {
           mPresenter.getWeather(AppConstants.appKey,"成都");
    }

    @Override
    public void onSuccess(WeatherBean weatherBean) {
        positionBeans.addAll(weatherBean.getPosition());
        mAdapter.setNewData(positionBeans);
    }

    @Override
    public void onProgress(long totalSize, long downSize) {

    }
}
