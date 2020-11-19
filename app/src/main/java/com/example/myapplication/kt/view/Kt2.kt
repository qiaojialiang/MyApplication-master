package com.example.myapplication.kt.view

import android.content.Context
import android.content.Intent
import android.util.Log
import com.example.myapplication.R
import com.example.myapplication.activity.presenter.CarContract
import com.example.myapplication.activity.presenter.CarPresenter
import com.example.myapplication.base.BaseMvpActivity
import com.example.myapplication.bean.CarBean
import com.lzy.okgo.OkGo
import com.lzy.okgo.cache.CacheMode
import com.lzy.okgo.callback.StringCallback
import okhttp3.Call
import okhttp3.Response


class Kt2 : BaseMvpActivity<CarPresenter>(), CarContract.CarView {

    companion object {
        fun start(context: Context) {
            var intent = Intent(context, Kt2::class.java)
            context.startActivity(intent)
        }
    }

    override fun createPresenter(): CarPresenter {
        return CarPresenter(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_kt2
    }

    override fun initView() {

    }

    override fun getData() {
        OkGo.get("https://www.baidu.com/")
                .tag(this)
                .cacheKey("cacheKey")
                .cacheMode(CacheMode.DEFAULT)
                .execute(object : StringCallback() {
                    override fun onSuccess(s: String?, call: Call?, response: Response?) {
                        //  mTextView2.setText(s)
                        Log.e("数据1", s + "")
                    }
                })
    }

    override fun onProgress(totalSize: Long, downSize: Long) {

    }

    override fun showCarList(list: MutableList<CarBean>?) {

    }

}