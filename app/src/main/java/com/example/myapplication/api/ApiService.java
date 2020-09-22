package com.example.myapplication.api;

import com.example.myapplication.base.BaseModelNew;
import com.example.myapplication.bean.CarBean;
import com.example.myapplication.bean.WeatherBean;
import com.example.myapplication.body.WeatherBody;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by QiaoJiaLiang
 * Created on 2020/8/17
 **/
public interface ApiService {

//    @GET("?service=User.getNum")
//    Observable<BaseModel<List<PriceBean>>> getNum();
//
//
//    @GET("?service=Home.getCode")
//    Observable<BaseModel<CodeBean>> getCode(@Query("uid") String uid);
//
//    @Headers({"Content-Type: application/json"})
//    @POST("?service=User.getNum")
//    Observable<BaseModel<List<PriceBean>>> getPostNum
//            (@Body NumBody body);
//
//    @GET("?service=Video.getRecommendVideos")
//    Observable<BaseModel<List<VideoBean>>> getVideo(@Query("uid") String uid, @Query("p") int p);
//
    @Headers({"Content-Type: application/json"})
    @POST("aqi/query?")
    Observable<BaseModelNew<List<WeatherBean>>> getWeather(@Body WeatherBody body);
    @GET("aqi/query?")
    Observable<BaseModelNew<WeatherBean>> getWeatherGet(@Query("appkey") String appkey,@Query("city") String city);
    @GET("car/brand")
    Observable<BaseModelNew<List<CarBean>>> getCarList(@Query("appkey") String appkey);
}
