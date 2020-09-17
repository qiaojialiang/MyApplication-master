package com.example.myapplication.api;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by QiaoJiaLiang
 * Created on 2020/8/17
 **/
public class TokenInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request mNewRequest = chain.request()
                .newBuilder()
                .build();
        // 如果用户已登录 传递uid token
//        if (UserManager.isLogin())
//            mNewRequest = mNewRequest.newBuilder()
//                    .addHeader(AppConstants.TOKEN, UserManager.getToken())
//                    .build();
        return chain.proceed(mNewRequest);

      //  return null;
    }
}
