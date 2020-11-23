package com.example.myapplication.activity.presenter;


import com.example.myapplication.base.BasePresenter;


/**
 * Created by QiaoJiaLiang
 * Created on 2020/9/8
 **/
public class TanTanPresenter extends BasePresenter<TanTanContract.TanTanView> implements TanTanContract.Presenter {

    public TanTanPresenter(TanTanContract.TanTanView baseView) {
        super(baseView);
    }

    @Override
    public void getImage(String uid, int p) {
//        addDisposable(apiServer.getVideo(uid, p), new BaseObserver<List<VideoBean>>(baseView) {
//
//
//            @Override
//            public void onSuccess(List<VideoBean> o) {
//                baseView.onSuccess(o);
//            }
//
//            @Override
//            public void onError(String code, String msg) {
//                baseView.showMsg(msg);
//            }
//        });
    }
}
