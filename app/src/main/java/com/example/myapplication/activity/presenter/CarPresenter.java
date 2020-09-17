package com.example.myapplication.activity.presenter;

import android.util.Log;

import com.example.myapplication.base.BaseObserver;
import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.bean.CarBean;

import java.util.List;

public class CarPresenter extends BasePresenter<CarContract.CarView> implements CarContract.Presenter {

    public CarPresenter(CarContract.CarView baseView) {
        super(baseView);
    }

    @Override
    public void getCarList(String appkey) {
        addDisposable(apiServer.getCarList(appkey), new BaseObserver<List<CarBean>>(baseView) {

            @Override
            public void onSuccess(List<CarBean> o) {
                Log.e("onSuccess","true");
                baseView.showCarList(o);
            }

            @Override
            public void onError(String code, String msg) {
                Log.e("onSuccess","false");
                baseView.showMsg(msg);
            }
        });
    }
}
