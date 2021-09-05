package com.example.weathermvp.data;

import com.example.weathermvp.pojo.firstModel.FirstExample;
import com.example.weathermvp.pojo.secondModel.SecondExample;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BuildRRetrofit {

    API api;
    static BuildRRetrofit instance;

    String url = "https://api.openweathermap.org/data/2.5/forecast?q=ismailia&appid=af95d58d38666db5298039e7d26245a1";
    String BASE_URL = "https://api.openweathermap.org/";
    String apikey = "af95d58d38666db5298039e7d26245a1";

    public BuildRRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(API.class);
    }

    public static BuildRRetrofit getInstance() {
        if (null == instance){
            instance = new BuildRRetrofit();
        }
        return instance;
    }


    public Call<FirstExample> getDataCity(String city){
        return api.getDataCity(city,apikey);
    }

    public Call<SecondExample> getDataDetails(Double lat, Double lon){
        return api.getDataDetails(lat,lon,apikey);
    }

}
