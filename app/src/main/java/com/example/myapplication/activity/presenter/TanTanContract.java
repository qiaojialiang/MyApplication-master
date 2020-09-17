package com.example.myapplication.activity.presenter;

import com.example.myapplication.base.BaseView;
import com.example.myapplication.bean.VideoBean;

import java.util.List;

/**
 * Created by QiaoJiaLiang
 * Created on 2020/9/8
 **/
public class TanTanContract {


    public interface TanTanView extends BaseView {
        void onSuccess(List<VideoBean> list);
    }


    interface Presenter {
        void getImage(String uid, int p);
    }
}
