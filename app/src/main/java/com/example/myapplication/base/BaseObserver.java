package com.example.myapplication.base;


import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.text.ParseException;

import io.reactivex.observers.DisposableObserver;
import retrofit2.HttpException;


public abstract class BaseObserver<T> extends DisposableObserver<T> {
    protected BaseView view;

    private boolean isShowDialog;

    public BaseObserver(BaseView view) {
        this.view = view;
    }

    public BaseObserver(BaseView view, boolean isShowDialog) {
        this.view = view;
        this.isShowDialog = isShowDialog;
    }

    @Override
    protected void onStart() {
        if (view != null && isShowDialog) {
            view.showLoading();
        }
    }

    @Override
    public void onNext(T t) {
//        BaseModel<T> data = (BaseModel<T>) t;
//        BaseModel.InfoBean<T> info = (BaseModel.InfoBean<T>) data.getData();
//        if (data.getRet() == 200 && info.getCode() == 200 || info.getCode() == 0) {
//            onSuccess(info.getInfo());
//        } else {
//        }
        BaseModelNew<T> data= (BaseModelNew<T>) t;
        if (data.getStatus()==0){
            onSuccess(data.getResult());
        }else {

        }
    }


    @Override
    public void onError(Throwable e) {
        if (view != null && isShowDialog) {
            view.hideLoading();
        }
        BaseException be = null;
        if (e != null) {
            e.printStackTrace();
            if (e instanceof BaseException) {
                if (((BaseException) e).getErrorCode().equals("-1")) {
                    be = new BaseException(((BaseException) e).getErrorMsg(), e, BaseException.SERVER);
                } else if (((BaseException) e).getErrorCode().equals("0000")) {
                    be = new BaseException(((BaseException) e).getErrorMsg(), e, BaseException.TOKEN);
                } else {
                    be = (BaseException) e;
                }
                onError(be.getErrorCode(), be.getErrorMsg());

            } else {
                if (e instanceof HttpException) {
                    //   HTTP错误
                    be = new BaseException(BaseException.BAD_NETWORK_MSG, e, BaseException.BAD_NETWORK);
                } else if (e instanceof ConnectException
                        || e instanceof UnknownHostException) {
                    //   连接错误
                    be = new BaseException(BaseException.CONNECT_ERROR_MSG, e, BaseException.CONNECT_ERROR);
                } else if (e instanceof InterruptedIOException) {
                    //  连接超时
                    be = new BaseException(BaseException.CONNECT_TIMEOUT_MSG, e, BaseException.CONNECT_TIMEOUT);
                } else if (e instanceof JsonParseException
                        || e instanceof JSONException
                        || e instanceof ParseException) {
                    //  解析错误
                    be = new BaseException(BaseException.PARSE_ERROR_MSG, e, BaseException.PARSE_ERROR);
                } else {
                    be = new BaseException(BaseException.OTHER_MSG, e, BaseException.OTHER);
                }
            }
        } else {
            be = new BaseException(BaseException.OTHER_MSG, e, BaseException.OTHER);
        }
        onError(be.getErrorCode(), be.getErrorMsg());

    }

    @Override
    public void onComplete() {
        if (view != null && isShowDialog) {
            view.hideLoading();
        }

    }


    public abstract void onSuccess(T o);

    public abstract void onError(String code, String msg);


}
