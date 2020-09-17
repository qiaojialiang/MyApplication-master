package com.example.myapplication.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by QiaoJiaLiang
 * Created on 2020/9/9
 **/

@Entity
public class User {


    private Long id;
    private String userName;
    private String passWord;
    private String sex;
    @Generated(hash = 743389597)
    public User(Long id, String userName, String passWord, String sex) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.sex = sex;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUserName() {
        return this.userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassWord() {
        return this.passWord;
    }
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    public String getSex() {
        return this.sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
}
