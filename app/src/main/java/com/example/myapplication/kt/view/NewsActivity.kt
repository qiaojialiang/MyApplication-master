package com.example.myapplication.kt.view

import android.content.Context
import android.content.Intent
import android.widget.TextView
import com.example.myapplication.R
import com.example.myapplication.base.BaseMvpActivity
import com.example.myapplication.kt.presenter.NewPresenter
import com.example.myapplication.kt.presenter.NewsContract

/**
 * Created by QiaoJiaLiang
 * Created on 2020/9/1
 **/
class NewsActivity : BaseMvpActivity<NewPresenter>(), NewsContract.NewsDemoView {

    var text1: TextView? = null

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, NewsActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onProgress(totalSize: Long, downSize: Long) {
    }

    override fun createPresenter(): NewPresenter {
        return NewPresenter(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_news
    }

    override fun initView() {
//        text1 = findViewById(R.id.text1)
    }

    override fun getData() {
    }

    override fun onSetNews() {
    }
}
