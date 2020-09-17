package com.example.myapplication.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Objects;

/**
 * Created by QiaoJiaLiang
 * Created on 2020/9/8
 **/
public class GalleryIemDecoration extends RecyclerView.ItemDecoration {

    public GalleryIemDecoration(Context context) {
        WindowManager manager = ((Activity) context).getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view);
        int itemCount = Objects.requireNonNull(parent.getAdapter()).getItemCount(); //获得item的数量
        int leftMargin;
        //自定义默认item边距
        int mPageMargin = 15;
        if (position == 0) {
            leftMargin = dpToPx(mPageMargin);
        } else {
            leftMargin = dpToPx(mPageMargin);
        }
        int rightMargin;
        if (position == itemCount - 1) {
            rightMargin = dpToPx(mPageMargin);
        } else {
            rightMargin = dpToPx(mPageMargin);
        }
        RecyclerView.LayoutParams lp = (RecyclerView.LayoutParams) view.getLayoutParams();
        lp.setMargins(leftMargin, 20, rightMargin, 0);
        view.setLayoutParams(lp);
        super.getItemOffsets(outRect, view, parent, state);
    }

    private int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density + 0.5f); //dp转px
    }
}
