package com.example.myapplication.fragment;


import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by QiaoJiaLiang
 * Created on 2020/9/7
 **/
public class AnimationFragment extends BaseFragment {

    @BindView(R.id.transition_demo)
    ImageView transitionDemo;

    @Override
    protected int initLayout() {
        return R.layout.fragment_animation;
    }

    @Override
    protected void initView(View view) {
        ButterKnife.bind(this, view);
        TranslateAnimation animation = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.9f);
        animation.setDuration(3000);
        animation.setRepeatCount(-1);
        animation.setRepeatMode(Animation.RESTART);
        transitionDemo.startAnimation(animation);

    }

    @Override
    protected void initData(Context mContext) {
    }
}
