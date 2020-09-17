package com.example.myapplication.activity.view;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.activity.presenter.MainContract;
import com.example.myapplication.activity.presenter.MainPresenter;
import com.example.myapplication.adapter.PriceAdapter;
import com.example.myapplication.base.BaseMvpActivity;
import com.example.myapplication.bean.PriceBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseMvpActivity<MainPresenter> implements MainContract.MainView, View.OnClickListener {
    @BindView(R.id.main_recycle)
    RecyclerView mRecycle;
    private List<PriceBean> priceBeans = new ArrayList<>();
    private PriceAdapter mAdapter;

    @Override
    public void onPriceSuccess(List<PriceBean> s) {
        mAdapter.setNewData(s);
    }

    @Override
    public void onGetCodeSuccess(String code) {
        Log.e("getScodeSuccess", code + "");
    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @SuppressLint("InflateParams")
    @Override
    protected void initView() {
        mAdapter = new PriceAdapter(R.layout.item_price, priceBeans);
        View heardView = getLayoutInflater().inflate(R.layout.main_heard_view, null);
        View footView = getLayoutInflater().inflate(R.layout.main_foot_view, null);
        mAdapter.addHeaderView(heardView);
        mAdapter.addFooterView(footView);
        TextView main_heard_tablayout = heardView.findViewById(R.id.main_heard_tablayout);
        Button btn1 = footView.findViewById(R.id.btn1);
        Button btn2 = footView.findViewById(R.id.btn2);
        Button btn3 = footView.findViewById(R.id.btn3);
        Button btn4 = footView.findViewById(R.id.btn4);
        Button btn5 = footView.findViewById(R.id.btn5);
        Button btn6 = footView.findViewById(R.id.btn6);
        Button btn7 = footView.findViewById(R.id.btn7);
        btn7.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        mRecycle.setLayoutManager(new GridLayoutManager(this, 5));
        mRecycle.setAdapter(mAdapter);
    }

    @Override
    protected void getData() {
        mPresenter.getMainDemo();
        mPresenter.getCode("11783");
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    public void onProgress(long totalSize, long downSize) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                //tablayout
                TabLayoutDemoActivity.start(MainActivity.this);
                break;
            case R.id.btn2:
                //探探
                TanTanDemoActivity.start(MainActivity.this);
                break;
            case R.id.btn3:
                //AsyncTask
                AsyncTaskActivity.start(MainActivity.this);
                break;
            case R.id.btn4:
                //字母索引
                SideBarActivity.start(MainActivity.this);
                break;
            case R.id.btn5:
                //动画
                AnimatorActivity.start(MainActivity.this);
                break;
            case R.id.btn6:
                //天气
                WeatherActivity.start(MainActivity.this);
                break;
            case R.id.btn7:
                CarActivity.start(MainActivity.this);
                break;

        }
    }
}