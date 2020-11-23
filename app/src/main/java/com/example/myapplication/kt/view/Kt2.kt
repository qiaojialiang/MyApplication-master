package com.example.myapplication.kt.view

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Message
import android.util.Log
import com.example.myapplication.R
import com.example.myapplication.activity.presenter.CarContract
import com.example.myapplication.activity.presenter.CarPresenter
import com.example.myapplication.base.BaseMvpActivity
import com.example.myapplication.bean.CarBean
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets


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
        initAssets()
    }

    @SuppressLint("HandlerLeak")
    var handler: android.os.Handler = object : android.os.Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            when (msg.what) {
                100 -> {

                }
            }
        }
    }

    override fun getData() {
//        OkGo.get("https://www.baidu.com/")
//                .tag(this)
//                .cacheKey("cacheKey")
//                .cacheMode(CacheMode.DEFAULT)
//                .execute(object : StringCallback() {
//                    override fun onSuccess(s: String?, call: Call?, response: Response?) {
//                        //  mTextView2.setText(s)
//                        Log.e("数据1", s + "")
//                        val message = Message()
//                        message.what = 100
//                        handler.sendMessage(message)
//                    }
//                })
    }

    private fun initAssets() {
        try {
            val inputStream = assets.open("json.txt")
            val jsonData = getString(inputStream)
            Log.e("数据1", jsonData + "");
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun getString(inputStream: InputStream?): String? {
        val inputStreamReader = InputStreamReader(inputStream, StandardCharsets.UTF_8)
        val reader = BufferedReader(inputStreamReader)
        val sb = StringBuilder()
        var line: String?
        try {
            while (reader.readLine().also { line = it } != null) {
                sb.append(line)
                sb.append("\n")
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return sb.toString()
    }

    override fun onProgress(totalSize: Long, downSize: Long) {

    }

    override fun showCarList(list: MutableList<CarBean>?) {

    }

}