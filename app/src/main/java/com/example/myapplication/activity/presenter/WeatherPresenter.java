package com.example.myapplication.activity.presenter;

import android.util.Log;

import com.example.myapplication.base.BaseObserver;
import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.bean.WeatherBean;


public class WeatherPresenter extends BasePresenter<WeatherContract.WeatherView>implements  WeatherContract.WeatherPresenter{


    public WeatherPresenter(WeatherContract.WeatherView baseView) {
        super(baseView);
    }

    @Override
    public void getWeather(String key, String city) {
        addDisposable(apiServer.getWeatherGet(key, city), new BaseObserver<WeatherBean>(baseView) {

            @Override
            public void onSuccess(WeatherBean o) {
                Log.e("onSuccess","true");
                baseView.onSuccess(o);
            }

            @Override
            public void onError(String code, String msg) {
                Log.e("onSuccess","false");
                baseView.showMsg(msg);
            }
        });
    }
}
