package com.example.myapplication.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * Created by QiaoJiaLiang
 * Created on 2020/9/2
 */
@Suppress("DEPRECATION")
class MyPagerAdapter(fm: FragmentManager,
                     private val context: Context,
                     private val fragmentList: List<Fragment>,
                     private val list_Title: List<String>) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int {
        return list_Title.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return list_Title[position]
    }
}
