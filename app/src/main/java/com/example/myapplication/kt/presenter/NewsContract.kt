package com.example.myapplication.kt.presenter

import com.example.myapplication.base.BaseView


/**
 * Created by QiaoJiaLiang
 * Created on 2020/9/1
 **/
class NewsContract {

    interface NewsDemoView : BaseView {
        fun onSetNews()
    }

    internal interface NewsPresenter {
        fun getNewsData()
    }
}