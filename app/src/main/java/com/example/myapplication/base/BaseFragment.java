package com.example.myapplication.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;


/**
 * Created by QiaoJiaLiang
 * Created on 2020/9/7
 **/
public abstract class BaseFragment extends Fragment {

    public Context context;

    @Override
    public void onAttach(@NonNull Context ctx) {
        super.onAttach(ctx);
        context = ctx;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(initLayout(), container, false);
        initView(rootView);
        initData(context);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    protected abstract int initLayout();

    /*
     * 初始化控件
     * */
    protected abstract void initView(final View view);

    /*
     * 初始化，绑定数据
     * */
    protected abstract void initData(Context mContext);

}
