package com.example.myapplication.kt.presenter;

import com.example.myapplication.base.BaseObserver;
import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.bean.WeatherBean;

public class TianQiPresenter extends BasePresenter<TianQiContract.TianQiView> implements TianQiContract.TianQiPresenter {

    public TianQiPresenter(TianQiContract.TianQiView baseView) {
        super(baseView);
    }

    @Override
    public void getWeatherList(String key, String city) {
          addDisposable(apiServer.getWeatherGet(key, city), new BaseObserver<WeatherBean>(baseView) {

              @Override
              public void onSuccess(WeatherBean o) {
                    baseView.showTianQiList(o);
              }

              @Override
              public void onError(String code, String msg) {

              }
          });
    }
}
