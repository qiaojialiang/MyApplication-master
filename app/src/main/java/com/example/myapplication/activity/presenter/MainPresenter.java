package com.example.myapplication.activity.presenter;


import com.example.myapplication.base.BaseObserver;
import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.bean.CodeBean;
import com.example.myapplication.bean.PriceBean;

import java.util.List;

/**
 * Created by QiaoJiaLiang
 * Created on 2020/8/17
 **/
public class MainPresenter extends BasePresenter<MainContract.MainView> implements MainContract.Presenter {

    public MainPresenter(MainContract.MainView baseView) {
        super(baseView);
    }

    @Override
    public void getMainDemo() {
//        addDisposable(apiServer.getNum(), new BaseObserver<List<PriceBean>>(baseView) {
//            @Override
//            public void onSuccess(List<PriceBean> o) {
//                baseView.onPriceSuccess(o);
//
//            }
//
//            @Override
//            public void onError(String code, String msg) {
//                baseView.showMsg(msg);
//            }
//        });
    }

    @Override
    public void getCode(String uid) {
//        addDisposable(apiServer.getCode(uid), new BaseObserver<CodeBean>(baseView) {
//
//            @Override
//            public void onSuccess(CodeBean o) {
//                baseView.onGetCodeSuccess(o.getInvite());
//            }
//
//            @Override
//            public void onError(String code, String msg) {
//                baseView.showMsg(msg);
//            }
//        });
    }
}
