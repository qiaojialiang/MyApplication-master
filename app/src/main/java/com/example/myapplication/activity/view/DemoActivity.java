package com.example.myapplication.activity.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.R;
import com.example.myapplication.fragment.TabLayoutFragment;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import static com.google.android.material.tabs.TabLayout.MODE_SCROLLABLE;

/**
 * Created by QiaoJiaLiang
 * Created on 2020/9/3
 **/
public class DemoActivity extends AppCompatActivity {
    TabLayout mTabLayout;
    ViewPager mViewPager;
    AppBarLayout appBarLayout;
    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> list_Title = new ArrayList<>();
    Toolbar mTool;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        mTabLayout = findViewById(R.id.tabLayout);
        mViewPager = findViewById(R.id.viewPager);
        appBarLayout = findViewById(R.id.appBarLayout);
        mTool = findViewById(R.id.activity_user_data_tool_ll);
        for (int i = 1; i < 7; i++) {
            fragmentList.add(new TabLayoutFragment());
            list_Title.add("选项卡" + i + "");
        }
        mTabLayout.setTabMode(MODE_SCROLLABLE);//设置可滑动
        // mViewPager.setAdapter(new MyPagetAdapter1(getSupportFragmentManager(), DemoActivity.this, fragmentList, list_Title));
        // mTabLayout.setupWithViewPager(mViewPager);
    }


}