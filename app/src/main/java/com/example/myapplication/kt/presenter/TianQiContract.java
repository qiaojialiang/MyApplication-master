package com.example.myapplication.kt.presenter;

import com.example.myapplication.base.BaseView;
import com.example.myapplication.bean.WeatherBean;

public class TianQiContract {

     public  interface  TianQiView extends BaseView{
           void showTianQiList(WeatherBean weatherBean);
     }

    interface TianQiPresenter {
        void getWeatherList(String key,String city);
    }
}
