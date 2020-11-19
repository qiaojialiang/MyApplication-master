package com.example.myapplication.kt.presenter

import com.example.myapplication.base.BasePresenter


/**
 * Created by QiaoJiaLiang
 * Created on 2020/9/1
 **/
//class GetPostDemoPresenter(baseView: GetPostDemoContract.GetPostDemoView) : BasePresenter<GetPostDemoContract.GetPostDemoView>(baseView),
//        GetPostDemoContract.Presenter {
//
//     fun getPostDemo(num: String) {
//        val body = NumBody()
//        body.num = num
// addDisposable(apiServer.getPostNum(body), object : BaseObserver<List<PriceBean>>(baseView) {
//
//            override fun onSuccess(o: List<PriceBean>) {
//                baseView.onPostDemo(o)
//            }
//
//            override fun onError(code: String, msg: String) {
//                baseView.showMsg(msg)
//            }
//        })
//    }
//}
class NewPresenter(baseView: NewsContract.NewsDemoView) : BasePresenter<NewsContract.NewsDemoView>(baseView),
        NewsContract.NewsPresenter {

    override fun getNewsData() {

    }

}
