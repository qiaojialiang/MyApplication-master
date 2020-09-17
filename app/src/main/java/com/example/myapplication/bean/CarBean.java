package com.example.myapplication.bean;

public class CarBean {


    /**
     * id : 1
     * name : 奥迪
     * initial : A
     * parentid : 0
     * logo : http://pic1.jisuapi.cn/car/static/images/logo/300/1.png
     * depth : 1
     */

    private int id;
    private String name;
    private String initial;
    private int parentid;
    private String logo;
    private int depth;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public int getParentid() {
        return parentid;
    }

    public void setParentid(int parentid) {
        this.parentid = parentid;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
}
