package com.example.myapplication.kt.presenter

import android.util.Log
import com.example.myapplication.base.BaseObserver
import com.example.myapplication.base.BasePresenter
import com.example.myapplication.bean.WeatherBean
import com.example.myapplication.kt.presenter.TianQiContract.TianQiView

class TianQiPresenter(baseView: TianQiView?) : BasePresenter<TianQiView?>(baseView), TianQiContract.TianQiPresenter {
    override fun getWeatherList(key: String?, city: String?) {
        addDisposable(apiServer.getWeatherGet(key, city), object : BaseObserver<WeatherBean?>(baseView) {
            override fun onError(code: String, msg: String) {
                Log.e("请求",msg+"")
                baseView!!.showMsg(msg)
            }
            override fun onSuccess(o: WeatherBean?) {
                Log.e("请求","success")
                baseView!!.showTianQiList(o)
            }
        })
    }
}