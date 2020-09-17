package com.example.myapplication.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.myapplication.R;

import java.util.List;

/**
 * Created by QiaoJiaLiang
 * Created on 2020/9/3
 **/
public class DemoAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public DemoAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.item_price, item);
    }
}
