package com.example.myapplication.activity.presenter;

import com.example.myapplication.base.BaseView;
import com.example.myapplication.bean.CarBean;

import java.util.List;

public class CarContract {

    public interface CarView extends BaseView {
        void showCarList(List<CarBean> list);
    }

    interface Presenter {
        void getCarList(String appkey);
    }
}
