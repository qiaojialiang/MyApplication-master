package com.example.myapplication.kt.view

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import androidx.viewpager.widget.ViewPager
import butterknife.BindView
import com.androidkun.xtablayout.XTabLayout
import com.example.myapplication.R
import com.example.myapplication.adapter.MyPagerAdapter

/**
 * Created by QiaoJiaLiang
 * Created on 2020/9/2
 **/
@SuppressLint("NonConstantResourceId")
class JspActivity : BaseKtActivity() {
    @BindView(R.id.xTablayout)
    lateinit var mTabLayout: XTabLayout
    @BindView(R.id.view_pager)
    lateinit var mViewPager: ViewPager
    internal var myPagerAdapter: MyPagerAdapter? = null


    override val setLayoutResourceID: Int
        get() {
            return R.layout.kt_demo
        }

    override fun initView(view: View) {
        mTabLayout.setxTabDisplayNum(3)
        mTabLayout.addTab(mTabLayout.newTab().setText("数据1"))
        mTabLayout.addTab(mTabLayout.newTab().setText("数据2"))
        mTabLayout.addTab(mTabLayout.newTab().setText("数据3"))
        mTabLayout.setupWithViewPager(mViewPager)
        /*
        public void addOnTabSelectedListener(XTabLayout.OnTabSelectedListener onTabSelectedListener) {
        mOnTabSelectedListenerList.add(onTabSelectedListener);}
        * */
        mTabLayout.addOnTabSelectedListener(object : XTabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: XTabLayout.Tab) {
            }

            override fun onTabUnselected(tab: XTabLayout.Tab) {

            }

            override fun onTabReselected(tab: XTabLayout.Tab) {

            }
        })
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, JspActivity::class.java)
            context.startActivity(intent)
        }
    }
}


