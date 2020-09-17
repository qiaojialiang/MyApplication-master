package com.example.myapplication.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.myapplication.R;
import com.example.myapplication.bean.PriceBean;

import java.util.List;

/**
 * Created by QiaoJiaLiang
 * Created on 2020/8/20
 **/
public class PriceAdapter extends BaseQuickAdapter<PriceBean, BaseViewHolder> {
    public PriceAdapter(int layoutResId, @Nullable List<PriceBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, PriceBean item) {
        helper.setText(R.id.item_price, "分类" + item.getPrice() + "");
        helper.addOnClickListener(R.id.item_price);
    }

}
