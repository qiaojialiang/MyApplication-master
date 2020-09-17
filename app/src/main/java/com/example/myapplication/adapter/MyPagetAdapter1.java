package com.example.myapplication.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by QiaoJiaLiang
 * Created on 2020/9/3
 **/
public class MyPagetAdapter1 extends FragmentPagerAdapter {
    private Context context;
    private List<Fragment> fragmentList;
    private List<String> list_Tile;

    public MyPagetAdapter1(@NonNull FragmentManager fm, Context context, List<Fragment> fragmentList, List<String> list_Tile) {
        super(fm);
        this.context = context;
        this.fragmentList = fragmentList;
        this.list_Tile = list_Tile;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return list_Tile.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return list_Tile.get(position);
    }
}
