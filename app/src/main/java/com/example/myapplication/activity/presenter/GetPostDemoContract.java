package com.example.myapplication.activity.presenter;

import com.example.myapplication.base.BaseView;
import com.example.myapplication.bean.PriceBean;

import java.util.List;

/**
 * Created by QiaoJiaLiang
 * Created on 2020/8/21
 **/
public class GetPostDemoContract {

    public interface GetPostDemoView extends BaseView {
        void onPostDemo(List<PriceBean> s);
    }


    interface Presenter {
        void getPostDemo(String num);
    }
}
