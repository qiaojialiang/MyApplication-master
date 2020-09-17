package com.example.myapplication.activity.presenter;

import com.example.myapplication.base.BaseView;
import com.example.myapplication.bean.WeatherBean;

public class WeatherContract {

     public  interface  WeatherView extends BaseView{
          void onSuccess(WeatherBean weatherBean);
     }


     interface WeatherPresenter{
          void getWeather(String key,String city);
     }
}
