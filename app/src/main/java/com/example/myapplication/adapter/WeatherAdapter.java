package com.example.myapplication.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.myapplication.R;
import com.example.myapplication.bean.WeatherBean;

import java.util.List;

public class WeatherAdapter  extends BaseQuickAdapter<WeatherBean.PositionBean, BaseViewHolder> {

    public WeatherAdapter(int layoutResId, @Nullable List<WeatherBean.PositionBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, WeatherBean.PositionBean item) {
           helper.setText(R.id.textView,item.getPositionname()+"");
    }
}
