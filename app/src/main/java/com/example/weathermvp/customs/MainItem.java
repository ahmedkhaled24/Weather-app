package com.example.weathermvp.customs;

public class MainItem {
    String string;
    int temp;
    String icon;

    public MainItem(String string, int temp,String icon) {
        this.string = string;
        this.temp=temp;
        this.icon = icon;
    }

    public String getString() {
        return string;
    }

    public int getTemp() {
        return temp;
    }

    public String getIcon() {
        return icon;
    }
}
