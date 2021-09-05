package com.example.weathermvp.customs;

public class CustomDetails {

    int id;
    Long date;
    String icon;
    int tempMax;
    int tempMin;
    String main;
    String desc;
    String timeZone;

    public CustomDetails(int id,Long date, String icon, int tempMax, int tempMin, String main, String desc,String timeZone) {
        this.date = date;
        this.icon = icon;
        this.tempMax = tempMax;
        this.tempMin = tempMin;
        this.main = main;
        this.desc = desc;
    }

    public Long getDate() {
        return date;
    }

    public String getIcon() {
        return icon;
    }

    public int getTempMax() {
        return tempMax;
    }

    public int getTempMin() {
        return tempMin;
    }

    public String getMain() {
        return main;
    }

    public String getDesc() {
        return desc;
    }

    public int getId() {
        return id;
    }

    public String getTimeZone() {
        return timeZone;
    }
}
