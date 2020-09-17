package com.example.myapplication.activity.presenter;


import com.example.myapplication.base.BaseObserver;
import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.body.NumBody;
import com.example.myapplication.bean.PriceBean;

import java.util.List;

/**
 * Created by QiaoJiaLiang
 * Created on 2020/8/21
 **/
public class GetPostDemoPresenter extends BasePresenter<GetPostDemoContract.GetPostDemoView> implements GetPostDemoContract.Presenter {


    public GetPostDemoPresenter(GetPostDemoContract.GetPostDemoView baseView) {
        super(baseView);
    }

    @Override
    public void getPostDemo(String num) {
        NumBody body = new NumBody();
        body.setNum(num);
//        addDisposable(apiServer.getPostNum(body), new BaseObserver<List<PriceBean>>(baseView) {
//
//            @Override
//            public void onSuccess(List<PriceBean> o) {
//                baseView.onPostDemo(o);
//            }
//
//            @Override
//            public void onError(String code, String msg) {
//                baseView.showMsg(msg);
//            }
//        });
    }
}
