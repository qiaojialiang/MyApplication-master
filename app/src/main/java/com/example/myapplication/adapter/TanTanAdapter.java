package com.example.myapplication.adapter;

import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.myapplication.R;
import com.example.myapplication.bean.VideoBean;

import java.util.List;

/**
 * Created by QiaoJiaLiang
 * Created on 2020/9/8
 **/
public class TanTanAdapter extends BaseQuickAdapter<VideoBean, BaseViewHolder> {
    public TanTanAdapter(int layoutResId, @Nullable List<VideoBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, VideoBean item) {
        Glide.with(mContext).load(item.getThumb()).into((ImageView) helper.getView(R.id.item_tantan_image));
    }
}
