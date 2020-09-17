package com.example.myapplication.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by cxf on 2017/10/25.
 */

public class VideoBean implements Parcelable {
    private String id;
    private String uid;
    private String title;//视频内使用的内容
    private String content;//圈子内使用的内容
    private String thumb;
    private String thumb_s;
    private String href;
    private String likes;
    private String views;
    private String comments;
    private String steps;
    private String shares;
    private String addtime;
    private String lat;
    private String lng;
    private String city;
    private String isdel;
    private String datetime;
    private String collect;
    private int islike;
    private int isattent;
    private int isCollect;
    private String distance;
    private int isstep;
    private int status;
    private int music_id;
    private List<String> imgs;
    private int is_ad;
    private String ad_url;
    private String videoType;
    private String hrefs;//完整视频地址
    private String complete;//是否开启完整视频

    public String getComplete() {
        return complete;
    }

    public void setComplete(String complete) {
        this.complete = complete;
    }

    public String getHrefs() {
        return hrefs;
    }

    public void setHrefs(String hrefs) {
        this.hrefs = hrefs;
    }

    public String getVideoType() {
        return videoType;
    }

    public void setVideoType(String videoType) {
        this.videoType = videoType;
    }

    public String getAd_url() {
        return ad_url;
    }

    public void setAd_url(String ad_url) {
        this.ad_url = ad_url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getIsCollect() {
        return isCollect;
    }

    public void setIsCollect(int isCollect) {
        this.isCollect = isCollect;
    }

    public List<String> getImgs() {
        return imgs;
    }

    public void setImgs(List<String> imgs) {
        this.imgs = imgs;
    }


    public String getCollect() {
        return collect;
    }

    public void setCollect(String collect) {
        this.collect = collect;
    }

    //视频金币的价格
    private String price;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    public int getIsstep() {
        return isstep;
    }

    public void setIsstep(int isstep) {
        this.isstep = isstep;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getThumb_s() {
        return thumb_s;
    }

    public void setThumb_s(String thumb_s) {
        this.thumb_s = thumb_s;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public String getShares() {
        return shares;
    }

    public void setShares(String shares) {
        this.shares = shares;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getIsdel() {
        return isdel;
    }

    public void setIsdel(String isdel) {
        this.isdel = isdel;
    }


    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public int getIslike() {
        return islike;
    }

    public void setIslike(int islike) {
        this.islike = islike;
    }

    public int getIsattent() {
        return isattent;
    }

    public void setIsattent(int isattent) {
        this.isattent = isattent;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getMusic_id() {
        return music_id;
    }

    public void setMusic_id(int music_id) {
        this.music_id = music_id;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.uid);
        dest.writeString(this.title);
        dest.writeString(this.content);
        dest.writeString(this.thumb);
        dest.writeString(this.thumb_s);
        dest.writeString(this.href);
        dest.writeString(this.likes);
        dest.writeString(this.views);
        dest.writeString(this.comments);
        dest.writeString(this.steps);
        dest.writeString(this.shares);
        dest.writeString(this.addtime);
        dest.writeString(this.lat);
        dest.writeString(this.lng);
        dest.writeString(this.city);
        dest.writeString(this.isdel);
        dest.writeString(this.datetime);
        dest.writeString(this.collect);
        dest.writeInt(this.islike);
        dest.writeInt(this.isattent);
        dest.writeInt(this.isCollect);
        dest.writeString(this.distance);
        dest.writeInt(this.isstep);
        dest.writeInt(this.status);
        dest.writeInt(this.music_id);
        dest.writeStringList(this.imgs);
        dest.writeString(this.price);
        dest.writeInt(this.is_ad);
        dest.writeString(this.ad_url);
    }

    public VideoBean() {
    }

    protected VideoBean(Parcel in) {
        this.id = in.readString();
        this.uid = in.readString();
        this.title = in.readString();
        this.content = in.readString();
        this.thumb = in.readString();
        this.thumb_s = in.readString();
        this.href = in.readString();
        this.likes = in.readString();
        this.views = in.readString();
        this.comments = in.readString();
        this.steps = in.readString();
        this.shares = in.readString();
        this.addtime = in.readString();
        this.lat = in.readString();
        this.lng = in.readString();
        this.city = in.readString();
        this.isdel = in.readString();
        this.datetime = in.readString();
        this.collect = in.readString();
        this.islike = in.readInt();
        this.isattent = in.readInt();
        this.isCollect = in.readInt();
        this.distance = in.readString();
        this.isstep = in.readInt();
        this.status = in.readInt();
        this.music_id = in.readInt();
        this.imgs = in.createStringArrayList();
        this.price = in.readString();
        this.is_ad = in.readInt();
        this.ad_url = in.readString();
    }

    public static final Creator<VideoBean> CREATOR = new Creator<VideoBean>() {
        @Override
        public VideoBean createFromParcel(Parcel source) {
            return new VideoBean(source);
        }

        @Override
        public VideoBean[] newArray(int size) {
            return new VideoBean[size];
        }
    };

    public int getIs_ad() {
        return is_ad;
    }

    public void setIs_ad(int is_ad) {
        this.is_ad = is_ad;
    }

}
