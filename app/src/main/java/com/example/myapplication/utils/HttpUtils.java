package com.example.myapplication.utils;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpUtils {
    Message message = new Message();

    public void getPost(String BaseUrl, int flag, FormBody.Builder formBody) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(BaseUrl)
                .post(formBody.build())
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                message.obj = response.body().string();
                message.arg1 = flag;
                message.what = 100;
                handler.sendMessage(message);
            }

            @Override
            public void onFailure(Call call, IOException e) {
                message.what = 500;
                message.obj = e;
                handler.sendMessage(message);
            }
        });
    }

    @SuppressLint("HandlerLeak")
    private final Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 100:
                    httpCallBack.onSuccess(msg.obj.toString(), msg.arg1);
                    break;
                case 500:
                    httpCallBack.onError(new IOException(msg.obj.toString()));
                    break;
            }
        }
    };

    public interface HttpCallBack {
        void onSuccess(String data, int flag);

        void onError(IOException e);
    }

    public   void removeHandler() {
        handler.removeCallbacksAndMessages(null);
    }

    public HttpCallBack httpCallBack;

    public void setMyHttpCallBack(HttpCallBack httpCallBack) {
        this.httpCallBack = httpCallBack;
    }

}
