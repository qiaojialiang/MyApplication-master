package com.example.myapplication;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.greendao.gen.DaoMaster;
import com.example.greendao.gen.DaoSession;
import com.example.greendao.gen.UserDao;

/**
 * Created by QiaoJiaLiang
 * Created on 2020/8/17
 **/
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this,"user,db");
        SQLiteDatabase sqLiteDatabase = devOpenHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(sqLiteDatabase);
        DaoSession daoSession = daoMaster.newSession();
        UserDao userDao = daoSession.getUserDao();
    }
}
