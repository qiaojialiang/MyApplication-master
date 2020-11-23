package com.example.myapplication.kt.presenter

import com.example.myapplication.base.BaseView
import com.example.myapplication.bean.WeatherBean

class TianQiContract {
    interface TianQiView : BaseView {
        fun showTianQiList(weatherBean: WeatherBean?)
    }

    internal interface TianQiPresenter {
        fun getWeatherList(key: String?, city: String?)
    }
}