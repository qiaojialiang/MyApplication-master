package com.example.myapplication.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by QiaoJiaLiang
 * Created on 2020/8/20
 **/
public class PriceAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public PriceAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
    }

}
