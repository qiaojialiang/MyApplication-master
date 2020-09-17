package com.example.myapplication.activity.view;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.core.widget.ContentLoadingProgressBar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.activity.presenter.TanTanContract;
import com.example.myapplication.activity.presenter.TanTanPresenter;
import com.example.myapplication.adapter.TanTanAdapter;
import com.example.myapplication.base.BaseMvpActivity;
import com.example.myapplication.bean.VideoBean;
import com.example.myapplication.utils.GalleryIemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by QiaoJiaLiang
 * Created on 2020/9/8
 * 仿探探
 **/
public class TanTanDemoActivity extends BaseMvpActivity<TanTanPresenter> implements TanTanContract.TanTanView {
    @BindView(R.id.tantan_RecyclerView)
    RecyclerView mRecycleView;
    @BindView(R.id.tantan_progress_bar)
    ContentLoadingProgressBar mProgress;
    TanTanAdapter mAdapter;
    ArrayList<VideoBean> imageList = new ArrayList<>();

    public static void start(Context context) {
        Intent intent = new Intent(context, TanTanDemoActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected TanTanPresenter createPresenter() {
        return new TanTanPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_tantan;
    }

    @Override
    protected void initView() {
        mAdapter = new TanTanAdapter(R.layout.item_tantan, imageList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecycleView.setLayoutManager(layoutManager);
        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        pagerSnapHelper.attachToRecyclerView(mRecycleView);
        GalleryIemDecoration decoration = new GalleryIemDecoration(this);
        mRecycleView.addItemDecoration(decoration);
        mRecycleView.setAdapter(mAdapter);
    }

    @Override
    protected void getData() {
        mProgress.setVisibility(View.VISIBLE);
        mPresenter.getImage("11783", 1);
    }

    @Override
    public void onSuccess(List<VideoBean> list) {
        mAdapter.setNewData(list);
        mProgress.setVisibility(View.GONE);
    }

    @Override
    public void onProgress(long totalSize, long downSize) {

    }
}
