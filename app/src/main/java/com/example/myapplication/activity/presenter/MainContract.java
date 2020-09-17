package com.example.myapplication.activity.presenter;


import com.example.myapplication.base.BaseView;
import com.example.myapplication.bean.PriceBean;

import java.util.List;

/**
 * Created by QiaoJiaLiang
 * Created on 2020/8/17
 **/
public class MainContract {

    public interface MainView extends BaseView {
        void onPriceSuccess(List<PriceBean> s);

        void onGetCodeSuccess(String code);
    }

    interface Presenter {
        void getMainDemo();

        void getCode(String uid);

    }
}
