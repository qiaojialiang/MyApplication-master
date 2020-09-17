package com.example.myapplication.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.myapplication.R;

import java.util.List;

/**
 * Created by QiaoJiaLiang
 * Created on 2020/9/8
 **/
public class SideBarAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public SideBarAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
       // helper.setText(R.id.item_name, item);
        helper.setText(R.id.item_py, item);

    }
}
