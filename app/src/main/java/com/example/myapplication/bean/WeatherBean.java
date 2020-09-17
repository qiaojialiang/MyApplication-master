package com.example.myapplication.bean;

import java.util.List;

public class WeatherBean {


    /**
     * cityid : 382
     * city : 杭州
     * so2 : 5
     * so224 : 0
     * no2 : 38
     * no224 : 0
     * co : 0.750
     * co24 : 0.000
     * o3 : 54
     * o38 : 0
     * o324 : 0
     * pm10 : 22
     * pm1024 : 0
     * pm2_5 : 15
     * pm2_524 : 0
     * iso2 : 2
     * ino2 : 19
     * ico : 8
     * io3 : 18
     * io38 : 0
     * ipm10 : 22
     * ipm2_5 : 21
     * aqi : 22
     * primarypollutant : PM10
     * quality : 优
     * timepoint : 2020-09-15 14:00:00
     * aqiinfo : {"level":"一级","color":"#00e400","affect":"空气质量令人满意，基本无空气污染","measure":"各类人群可正常活动"}
     * position : [{"positionname":"千岛湖（对照）","so2":0,"so224":null,"no2":0,"no224":null,"co":"0.500","co24":null,"o3":77,"o38":null,"o324":null,"pm10":15,"pm1024":null,"pm2_5":11,"pm2_524":null,"iso2":29,"ino2":0,"ico":5,"io3":25,"io38":null,"ipm10":15,"ipm2_5":16,"aqi":0,"primarypollutant":"SO2","quality":"","timepoint":"2020-09-15 14:00:00","color":"#FFFF00","lat":null,"lng":null},{"positionname":"和睦小学","so2":4,"so224":null,"no2":30,"no224":null,"co":"0.700","co24":null,"o3":59,"o38":null,"o324":null,"pm10":14,"pm1024":null,"pm2_5":12,"pm2_524":null,"iso2":2,"ino2":15,"ico":7,"io3":19,"io38":null,"ipm10":14,"ipm2_5":18,"aqi":19,"primarypollutant":"O3","quality":"优","timepoint":"2020-09-15 14:00:00","color":"#00e400","lat":"30.3119","lng":"120.12"},{"positionname":"朝晖五区","so2":3,"so224":null,"no2":59,"no224":null,"co":"0.800","co24":null,"o3":36,"o38":null,"o324":null,"pm10":23,"pm1024":null,"pm2_5":17,"pm2_524":null,"iso2":1,"ino2":30,"ico":8,"io3":12,"io38":null,"ipm10":23,"ipm2_5":25,"aqi":30,"primarypollutant":"NO2","quality":"优","timepoint":"2020-09-15 14:00:00","color":"#00e400","lat":"30.2897","lng":"120.157"},{"positionname":"浙江农大","so2":5,"so224":null,"no2":40,"no224":null,"co":"0.800","co24":null,"o3":55,"o38":null,"o324":null,"pm10":19,"pm1024":null,"pm2_5":16,"pm2_524":null,"iso2":2,"ino2":20,"ico":8,"io3":18,"io38":null,"ipm10":19,"ipm2_5":23,"aqi":23,"primarypollutant":"PM2.5","quality":"优","timepoint":"2020-09-15 14:00:00","color":"#00e400","lat":"30.2692","lng":"120.19"},{"positionname":"卧龙桥","so2":5,"so224":null,"no2":16,"no224":null,"co":"0.800","co24":null,"o3":68,"o38":null,"o324":null,"pm10":17,"pm1024":null,"pm2_5":13,"pm2_524":null,"iso2":2,"ino2":8,"ico":8,"io3":22,"io38":null,"ipm10":17,"ipm2_5":19,"aqi":22,"primarypollutant":"O3","quality":"优","timepoint":"2020-09-15 14:00:00","color":"#00e400","lat":"30.2456","lng":"120.127"},{"positionname":"下沙","so2":2,"so224":null,"no2":54,"no224":null,"co":"0.800","co24":null,"o3":36,"o38":null,"o324":null,"pm10":28,"pm1024":null,"pm2_5":18,"pm2_524":null,"iso2":1,"ino2":27,"ico":8,"io3":12,"io38":null,"ipm10":28,"ipm2_5":26,"aqi":28,"primarypollutant":"PM10","quality":"优","timepoint":"2020-09-15 14:00:00","color":"#00e400","lat":"30.3058","lng":"120.348"},{"positionname":"云栖","so2":3,"so224":null,"no2":34,"no224":null,"co":"0.800","co24":null,"o3":47,"o38":null,"o324":null,"pm10":26,"pm1024":null,"pm2_5":16,"pm2_524":null,"iso2":1,"ino2":17,"ico":8,"io3":15,"io38":null,"ipm10":26,"ipm2_5":23,"aqi":26,"primarypollutant":"PM10","quality":"优","timepoint":"2020-09-15 14:00:00","color":"#00e400","lat":"30.1808","lng":"120.088"},{"positionname":"城厢镇","so2":6,"so224":null,"no2":36,"no224":null,"co":"0.800","co24":null,"o3":62,"o38":null,"o324":null,"pm10":22,"pm1024":null,"pm2_5":15,"pm2_524":null,"iso2":2,"ino2":18,"ico":8,"io3":20,"io38":null,"ipm10":22,"ipm2_5":22,"aqi":22,"primarypollutant":"PM10","quality":"优","timepoint":"2020-09-15 14:00:00","color":"#00e400","lat":"30.1819","lng":"120.27"},{"positionname":"临平镇","so2":4,"so224":null,"no2":54,"no224":null,"co":"0.700","co24":null,"o3":34,"o38":null,"o324":null,"pm10":25,"pm1024":null,"pm2_5":12,"pm2_524":null,"iso2":2,"ino2":27,"ico":7,"io3":11,"io38":null,"ipm10":25,"ipm2_5":18,"aqi":27,"primarypollutant":"NO2","quality":"优","timepoint":"2020-09-15 14:00:00","color":"#00e400","lat":"30.4183","lng":"120.301"},{"positionname":"西溪","so2":8,"so224":null,"no2":26,"no224":null,"co":"0.500","co24":null,"o3":60,"o38":null,"o324":null,"pm10":15,"pm1024":null,"pm2_5":8,"pm2_524":null,"iso2":3,"ino2":13,"ico":5,"io3":19,"io38":null,"ipm10":15,"ipm2_5":12,"aqi":19,"primarypollutant":"O3","quality":"优","timepoint":"2020-09-15 14:00:00","color":"#00e400","lat":"30.2747","lng":"120.063"},{"positionname":"滨江","so2":5,"so224":null,"no2":23,"no224":null,"co":"0.800","co24":null,"o3":75,"o38":null,"o324":null,"pm10":24,"pm1024":null,"pm2_5":16,"pm2_524":null,"iso2":2,"ino2":12,"ico":8,"io3":24,"io38":null,"ipm10":24,"ipm2_5":23,"aqi":24,"primarypollutant":"O3","quality":"优","timepoint":"2020-09-15 14:00:00","color":"#00e400","lat":"30.21","lng":"120.211"}]
     */

    private int cityid;
    private String city;
    private int so2;
    private int so224;
    private int no2;
    private int no224;
    private String co;
    private String co24;
    private int o3;
    private int o38;
    private int o324;
    private int pm10;
    private int pm1024;
    private int pm2_5;
    private int pm2_524;
    private int iso2;
    private int ino2;
    private int ico;
    private int io3;
    private int io38;
    private int ipm10;
    private int ipm2_5;
    private int aqi;
    private String primarypollutant;
    private String quality;
    private String timepoint;
    private AqiinfoBean aqiinfo;
    private List<PositionBean> position;

    public int getCityid() {
        return cityid;
    }

    public void setCityid(int cityid) {
        this.cityid = cityid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getSo2() {
        return so2;
    }

    public void setSo2(int so2) {
        this.so2 = so2;
    }

    public int getSo224() {
        return so224;
    }

    public void setSo224(int so224) {
        this.so224 = so224;
    }

    public int getNo2() {
        return no2;
    }

    public void setNo2(int no2) {
        this.no2 = no2;
    }

    public int getNo224() {
        return no224;
    }

    public void setNo224(int no224) {
        this.no224 = no224;
    }

    public String getCo() {
        return co;
    }

    public void setCo(String co) {
        this.co = co;
    }

    public String getCo24() {
        return co24;
    }

    public void setCo24(String co24) {
        this.co24 = co24;
    }

    public int getO3() {
        return o3;
    }

    public void setO3(int o3) {
        this.o3 = o3;
    }

    public int getO38() {
        return o38;
    }

    public void setO38(int o38) {
        this.o38 = o38;
    }

    public int getO324() {
        return o324;
    }

    public void setO324(int o324) {
        this.o324 = o324;
    }

    public int getPm10() {
        return pm10;
    }

    public void setPm10(int pm10) {
        this.pm10 = pm10;
    }

    public int getPm1024() {
        return pm1024;
    }

    public void setPm1024(int pm1024) {
        this.pm1024 = pm1024;
    }

    public int getPm2_5() {
        return pm2_5;
    }

    public void setPm2_5(int pm2_5) {
        this.pm2_5 = pm2_5;
    }

    public int getPm2_524() {
        return pm2_524;
    }

    public void setPm2_524(int pm2_524) {
        this.pm2_524 = pm2_524;
    }

    public int getIso2() {
        return iso2;
    }

    public void setIso2(int iso2) {
        this.iso2 = iso2;
    }

    public int getIno2() {
        return ino2;
    }

    public void setIno2(int ino2) {
        this.ino2 = ino2;
    }

    public int getIco() {
        return ico;
    }

    public void setIco(int ico) {
        this.ico = ico;
    }

    public int getIo3() {
        return io3;
    }

    public void setIo3(int io3) {
        this.io3 = io3;
    }

    public int getIo38() {
        return io38;
    }

    public void setIo38(int io38) {
        this.io38 = io38;
    }

    public int getIpm10() {
        return ipm10;
    }

    public void setIpm10(int ipm10) {
        this.ipm10 = ipm10;
    }

    public int getIpm2_5() {
        return ipm2_5;
    }

    public void setIpm2_5(int ipm2_5) {
        this.ipm2_5 = ipm2_5;
    }

    public int getAqi() {
        return aqi;
    }

    public void setAqi(int aqi) {
        this.aqi = aqi;
    }

    public String getPrimarypollutant() {
        return primarypollutant;
    }

    public void setPrimarypollutant(String primarypollutant) {
        this.primarypollutant = primarypollutant;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getTimepoint() {
        return timepoint;
    }

    public void setTimepoint(String timepoint) {
        this.timepoint = timepoint;
    }

    public AqiinfoBean getAqiinfo() {
        return aqiinfo;
    }

    public void setAqiinfo(AqiinfoBean aqiinfo) {
        this.aqiinfo = aqiinfo;
    }

    public List<PositionBean> getPosition() {
        return position;
    }

    public void setPosition(List<PositionBean> position) {
        this.position = position;
    }

    public static class AqiinfoBean {
        /**
         * level : 一级
         * color : #00e400
         * affect : 空气质量令人满意，基本无空气污染
         * measure : 各类人群可正常活动
         */

        private String level;
        private String color;
        private String affect;
        private String measure;

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getAffect() {
            return affect;
        }

        public void setAffect(String affect) {
            this.affect = affect;
        }

        public String getMeasure() {
            return measure;
        }

        public void setMeasure(String measure) {
            this.measure = measure;
        }
    }

    public static class PositionBean {
        /**
         * positionname : 千岛湖（对照）
         * so2 : 0
         * so224 : null
         * no2 : 0
         * no224 : null
         * co : 0.500
         * co24 : null
         * o3 : 77
         * o38 : null
         * o324 : null
         * pm10 : 15
         * pm1024 : null
         * pm2_5 : 11
         * pm2_524 : null
         * iso2 : 29
         * ino2 : 0
         * ico : 5
         * io3 : 25
         * io38 : null
         * ipm10 : 15
         * ipm2_5 : 16
         * aqi : 0
         * primarypollutant : SO2
         * quality :
         * timepoint : 2020-09-15 14:00:00
         * color : #FFFF00
         * lat : null
         * lng : null
         */

        private String positionname;
        private int so2;
        private Object so224;
        private int no2;
        private Object no224;
        private String co;
        private Object co24;
        private int o3;
        private Object o38;
        private Object o324;
        private int pm10;
        private Object pm1024;
        private int pm2_5;
        private Object pm2_524;
        private int iso2;
        private int ino2;
        private int ico;
        private int io3;
        private Object io38;
        private int ipm10;
        private int ipm2_5;
        private int aqi;
        private String primarypollutant;
        private String quality;
        private String timepoint;
        private String color;
        private Object lat;
        private Object lng;

        public String getPositionname() {
            return positionname;
        }

        public void setPositionname(String positionname) {
            this.positionname = positionname;
        }

        public int getSo2() {
            return so2;
        }

        public void setSo2(int so2) {
            this.so2 = so2;
        }

        public Object getSo224() {
            return so224;
        }

        public void setSo224(Object so224) {
            this.so224 = so224;
        }

        public int getNo2() {
            return no2;
        }

        public void setNo2(int no2) {
            this.no2 = no2;
        }

        public Object getNo224() {
            return no224;
        }

        public void setNo224(Object no224) {
            this.no224 = no224;
        }

        public String getCo() {
            return co;
        }

        public void setCo(String co) {
            this.co = co;
        }

        public Object getCo24() {
            return co24;
        }

        public void setCo24(Object co24) {
            this.co24 = co24;
        }

        public int getO3() {
            return o3;
        }

        public void setO3(int o3) {
            this.o3 = o3;
        }

        public Object getO38() {
            return o38;
        }

        public void setO38(Object o38) {
            this.o38 = o38;
        }

        public Object getO324() {
            return o324;
        }

        public void setO324(Object o324) {
            this.o324 = o324;
        }

        public int getPm10() {
            return pm10;
        }

        public void setPm10(int pm10) {
            this.pm10 = pm10;
        }

        public Object getPm1024() {
            return pm1024;
        }

        public void setPm1024(Object pm1024) {
            this.pm1024 = pm1024;
        }

        public int getPm2_5() {
            return pm2_5;
        }

        public void setPm2_5(int pm2_5) {
            this.pm2_5 = pm2_5;
        }

        public Object getPm2_524() {
            return pm2_524;
        }

        public void setPm2_524(Object pm2_524) {
            this.pm2_524 = pm2_524;
        }

        public int getIso2() {
            return iso2;
        }

        public void setIso2(int iso2) {
            this.iso2 = iso2;
        }

        public int getIno2() {
            return ino2;
        }

        public void setIno2(int ino2) {
            this.ino2 = ino2;
        }

        public int getIco() {
            return ico;
        }

        public void setIco(int ico) {
            this.ico = ico;
        }

        public int getIo3() {
            return io3;
        }

        public void setIo3(int io3) {
            this.io3 = io3;
        }

        public Object getIo38() {
            return io38;
        }

        public void setIo38(Object io38) {
            this.io38 = io38;
        }

        public int getIpm10() {
            return ipm10;
        }

        public void setIpm10(int ipm10) {
            this.ipm10 = ipm10;
        }

        public int getIpm2_5() {
            return ipm2_5;
        }

        public void setIpm2_5(int ipm2_5) {
            this.ipm2_5 = ipm2_5;
        }

        public int getAqi() {
            return aqi;
        }

        public void setAqi(int aqi) {
            this.aqi = aqi;
        }

        public String getPrimarypollutant() {
            return primarypollutant;
        }

        public void setPrimarypollutant(String primarypollutant) {
            this.primarypollutant = primarypollutant;
        }

        public String getQuality() {
            return quality;
        }

        public void setQuality(String quality) {
            this.quality = quality;
        }

        public String getTimepoint() {
            return timepoint;
        }

        public void setTimepoint(String timepoint) {
            this.timepoint = timepoint;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public Object getLat() {
            return lat;
        }

        public void setLat(Object lat) {
            this.lat = lat;
        }

        public Object getLng() {
            return lng;
        }

        public void setLng(Object lng) {
            this.lng = lng;
        }
    }
}
