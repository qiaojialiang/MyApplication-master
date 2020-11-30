package com.example.myapplication.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.myapplication.R;
import com.example.myapplication.bean.WeatherListBean;

import java.util.List;

public class WeatherAdapterNew  extends BaseQuickAdapter<WeatherListBean, BaseViewHolder> {
    public WeatherAdapterNew(int layoutResId, @Nullable List<WeatherListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, WeatherListBean item) {
        helper.setText(R.id.textView,item.getDetail()+"");
    }
}
