package com.example.myapplication.activity.view;

import android.util.Log;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.myapplication.AppConstants;
import com.example.myapplication.R;
import com.example.myapplication.adapter.WeatherAdapterNew;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.bean.HistoryBean;
import com.example.myapplication.bean.WeatherListBean;
import com.example.myapplication.utils.HttpUtils;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class PostJsonDemoActivity extends BaseActivity {
    private List<HistoryBean> historyBeans = new ArrayList<>();
    private List<WeatherListBean> weatherListBeans = new ArrayList<>();
    private WeatherAdapterNew weatherAdapterNew;
    private RecyclerView mRecycle;
    private HttpUtils httpUtils;
    @Override
    protected int setLayoutResourceID() {
        return R.layout.activity_post_json_demo;
    }

    @Override
    protected void initData() {
        //getWeather();
        httpUtils=new HttpUtils();
        mRecycle = findViewById(R.id.recyclerView);
        weatherAdapterNew = new WeatherAdapterNew(R.layout.item_layout, weatherListBeans);
        mRecycle.setLayoutManager(new LinearLayoutManager(this));
        mRecycle.setAdapter(weatherAdapterNew);
        getUtils();
    }

    private void getWeather() {
        OkHttpClient client = new OkHttpClient();//创建OkHttpClient对象。
        FormBody.Builder formBody = new FormBody.Builder();//创建表单请求体
        formBody.add("appkey", AppConstants.appKey);
        formBody.add("city", "成都");
        Request request = new Request.Builder()//创建Request对象。
                .url("https://api.jisuapi.com/weather/query?")
                .post(formBody.build())//传递请求体
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, Response response) throws IOException {
                JSONObject jsonObject = JSON.parseObject(response.body().string());
                String result = jsonObject.getString("result");
                JSONObject jsonObject1 = JSON.parseObject(result);
                JSONArray array = jsonObject1.getJSONArray("index");
                Log.e("请求", array.size() + "");
            }

            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("请求", e.getMessage() + "");
            }
        });
    }

    private void getHistory() {
        OkHttpClient client = new OkHttpClient();//创建OkHttpClient对象。
        FormBody.Builder formBody = new FormBody.Builder();//创建表单请求体
        formBody.add("deviceid", "8CF710F4DAB4");
        formBody.add("starttime", "");
        formBody.add("endtime", "");
        Request request = new Request.Builder()//创建Request对象。
                .url("http://dev.zcnst.com:8424/appinfo/caseapi/getCaseList.do?")
                .post(formBody.build())//传递请求体
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                assert response.body() != null;
                JSONObject jsonObject1 = JSON.parseObject(response.body().string());
                JSONArray array = jsonObject1.getJSONArray("case");
                for (int i = 0; i < array.size(); i++) {
                    HistoryBean historyBean = JSONObject.parseObject(array.getString(i), HistoryBean.class);
                    historyBeans.add(historyBean);
                }
                for (int i = 0; i < historyBeans.size(); i++) {
                    Log.e("historyMessage", historyBeans.get(i).getIndex() + "");
                }
            }

            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("请求", e.getMessage() + "");
            }
        });
    }

    private void getUtils() {
        FormBody.Builder formBody = new FormBody.Builder();
        formBody.add("appkey", AppConstants.appKey);
        formBody.add("city", "成都");
        httpUtils.getPost(AppConstants.BASE_WEATHER_URL, 0, formBody);
        httpUtils.setMyHttpCallBack(new HttpUtils.HttpCallBack() {
            @Override
            public void onSuccess(String response, int flag) {
                if (flag == 0) {
                    JSONObject jsonObject = JSONObject.parseObject(response);
                    String result = jsonObject.getString("result");
                    JSONObject jsonObject1 = JSONObject.parseObject(result);
                    JSONArray jsonArray = jsonObject1.getJSONArray("index");
                    for (int i = 0; i < jsonArray.size(); i++) {
                        WeatherListBean weatherListBean = JSONObject.parseObject(jsonArray.getString(i), WeatherListBean.class);
                        weatherListBeans.add(weatherListBean);
                    }
                    weatherAdapterNew.notifyDataSetChanged();
                }
            }

            @Override
            public void onError(IOException e) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        httpUtils.removeHandler();
    }
}
