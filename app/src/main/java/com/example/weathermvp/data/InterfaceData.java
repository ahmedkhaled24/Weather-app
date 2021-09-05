package com.example.weathermvp.data;

public interface InterfaceData {

    void onGetCityTempInterface(String city,Double temp,String icon);
    void onGetLonLatInterface(Double lon,Double lat);
}
