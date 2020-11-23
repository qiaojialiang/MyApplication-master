package com.example.myapplication.kt.view

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.AppConstants
import com.example.myapplication.R
import com.example.myapplication.R.id
import com.example.myapplication.R.id.activity_btn
import com.example.myapplication.base.BaseMvpActivity
import com.example.myapplication.bean.WeatherBean
import com.example.myapplication.kt.presenter.TianQiContract.TianQiView
import com.example.myapplication.kt.presenter.TianQiPresenter

@SuppressLint("NonConstantResourceId")
class TianqiActivity : BaseMvpActivity<TianQiPresenter?>(), TianQiView {
    var mTianQiEditText: EditText? = null
    var mButton: Button? = null
    var mRecyclerView: RecyclerView? = null

    override fun createPresenter(): TianQiPresenter {
        return TianQiPresenter(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_tianqi
    }


    @SuppressLint("ShowToast")
    override fun initView() {
        // mButton!!.setOnClickListener {) }
         mRecyclerView!!.layoutManager = LinearLayoutManager(this)
        mTianQiEditText = findViewById(id.activity_tianqi_edit_text)
        mButton = findViewById(activity_btn)
        mRecyclerView = findViewById(id.activity_tianqi_recycle)
        mButton!!.setOnClickListener {
            if (!TextUtils.isEmpty(mTianQiEditText!!.text.toString())) {
                mPresenter!!.getWeatherList(AppConstants.appKey, mTianQiEditText!!.text.toString())
            } else {
                //TODO toast
            }
        }

    }

    override fun getData() {

    }

    override fun showTianQiList(weatherBean: WeatherBean?) {
    }

    override fun onProgress(totalSize: Long, downSize: Long) {}

    companion object {
        @JvmStatic
        fun start(context: Context) {
            val intent = Intent(context, TianqiActivity::class.java)
            context.startActivity(intent)
        }
    }
}