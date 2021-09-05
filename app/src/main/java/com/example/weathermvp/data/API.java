package com.example.weathermvp.data;

import com.example.weathermvp.pojo.firstModel.FirstExample;
import com.example.weathermvp.pojo.secondModel.SecondExample;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {

    @GET("data/2.5/weather")
    Call<FirstExample> getDataCity(@Query("q") String cityname , @Query("appid") String apikey);

    @GET("data/2.5/onecall")
    Call<SecondExample> getDataDetails(@Query("lat") Double lat, @Query("lon") Double lon, @Query("appid") String apikey);
}
