package com.example.myapplication.base.gson;

import android.text.TextUtils;
import android.util.Log;

import com.example.myapplication.base.BaseException;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;


public class BaseResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final TypeAdapter<T> adapter;

    BaseResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        String jsonString = value.string();
        Log.e("数据1",jsonString+"");
        try {
//            JSONObject object = new JSONObject(jsonString);
//            String ret = object.getString("ret");
//            if (!ret.equals("200")) {
//                String msg = object.getString("msg");
//                if (TextUtils.isEmpty(msg)) {
//                    msg = object.getString("errorMsg");
//                }
//                //异常处理
//                throw new BaseException(msg, ret);
//            }
//            return adapter.fromJson(jsonString);
            JSONObject object = new JSONObject(jsonString);
            int status = object.getInt("status");
            if (status!=0){
                String msg = object.getString("msg");
                if (TextUtils.isEmpty(msg)) {
                    msg = object.getString("errorMsg");
                }
                //异常处理
                throw new BaseException(msg, String.valueOf(status));
            }
            return adapter.fromJson(jsonString);


        } catch (JSONException e) {
            e.printStackTrace();
            //数据解析异常
            throw new BaseException(BaseException.PARSE_ERROR_MSG, BaseException.PARSE_ERROR);
        } finally {
            value.close();
        }
    }
}
