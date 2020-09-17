package com.example.myapplication.activity.view;

import android.content.Context;
import android.content.Intent;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.R;
import com.example.myapplication.adapter.MyPagetAdapter1;
import com.example.myapplication.base.BaseNewActivity;
import com.example.myapplication.fragment.AnimationFragment;
import com.example.myapplication.fragment.TabLayoutFragment;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import static com.google.android.material.tabs.TabLayout.MODE_SCROLLABLE;

/**
 * Created by QiaoJiaLiang
 * Created on 2020/9/3
 * TabLayout吸顶效果实现
 **/
public class TabLayoutActivity extends BaseNewActivity {
    ViewPager mViewPager;
    TabLayout mTabLayout;
    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> list_Title = new ArrayList<>();
    Toolbar mToolbar;
    AppBarLayout appBarLayout;
    private int mDistanceY;//appbar 滚动距


    @Override
    protected int initLayout() {
        return R.layout.activity_tablayout;
    }

    @Override
    protected void initView() {
        mViewPager = findViewById(R.id.viewPager);
        mTabLayout = findViewById(R.id.tabLayout);
        mToolbar = findViewById(R.id.toolbar);
        appBarLayout = findViewById(R.id.appBarLayout);
        appBarLayout.addOnOffsetChangedListener(new MyOffChanged());
        //for (int i = 0; i < 5; i++) {
        //    fragmentList.add(new TabLayoutFragment());
        //    list_Title.add("选项卡" + i + "");
        //}
        list_Title.add("吸顶实现");
        list_Title.add("动画实现");
        fragmentList.add(new TabLayoutFragment());
        fragmentList.add(new AnimationFragment());
        mTabLayout.setTabMode(MODE_SCROLLABLE);//设置可滑动
        mViewPager.setAdapter(new MyPagetAdapter1(getSupportFragmentManager(), TabLayoutActivity.this, fragmentList, list_Title));
        mTabLayout.setupWithViewPager(mViewPager);
    }


    public static void start(Context context) {
        Intent intent = new Intent(context, TabLayoutActivity.class);
        context.startActivity(intent);
    }

    private class MyOffChanged implements AppBarLayout.OnOffsetChangedListener {
        @Override
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            int headHeight = mTabLayout.getTop() - mToolbar.getHeight();
            mDistanceY = Math.abs(i);
            //Log.e("mDistanceY", mDistanceY + "----" + headHeight + "");
            if (mDistanceY <= headHeight) {
                if (mDistanceY == 50) {

                } else {

                }

            } else if (mDistanceY > headHeight - 50) {//头布局划出屏幕

            }
        }
    }
}
