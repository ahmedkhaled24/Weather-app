package com.example.weathermvp.data;

import android.content.Context;
import android.widget.Toast;

import com.example.weathermvp.data.BuildRRetrofit;
import com.example.weathermvp.data.InterfaceData;
import com.example.weathermvp.data.InterfaceDetails;
import com.example.weathermvp.pojo.firstModel.FirstExample;
import com.example.weathermvp.pojo.secondModel.SecondExample;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Presenter {

    InterfaceData interfaceData;
    InterfaceDetails interfaceDetails;

    public Presenter(InterfaceData interfaceData) {
        this.interfaceData = interfaceData;
    }

    public Presenter(InterfaceDetails interfaceDetails) {
        this.interfaceDetails = interfaceDetails;
    }



    public void getCityPresenter(String city, Context context){
        BuildRRetrofit.getInstance().getDataCity(city).enqueue(new Callback<FirstExample>() {
            @Override
            public void onResponse(Call<FirstExample> call, Response<FirstExample> response) {
                    interfaceData.onGetCityTempInterface(response.body().getName()+", "+response.body().getSys().getCountry()
                            ,response.body().getMain().getTemp(),response.body().getWeather().get(0).getIcon());
                    interfaceData.onGetLonLatInterface(response.body().getCoord().getLon(),response.body().getCoord().getLat());

            }

            @Override
            public void onFailure(Call<FirstExample> call, Throwable t) {
                Toast.makeText(context,"Internet connection error",Toast.LENGTH_LONG).show();
            }
        });
    }



    public void onGetDetailsPresenter(Double lat,Double lon,Context context,int i){
        BuildRRetrofit.getInstance().getDataDetails(lat, lon).enqueue(new Callback<SecondExample>() {
            @Override
            public void onResponse(Call<SecondExample> call, Response<SecondExample> response) {
                    interfaceDetails.onGetDetailsInterface(i,response.body().getDaily().get(i).getDt(),
                            response.body().getDaily().get(i).getWeather().get(0).getIcon(),
                            response.body().getDaily().get(i).getTemp().getMax(),
                            response.body().getDaily().get(i).getTemp().getMin(),
                            response.body().getDaily().get(i).getWeather().get(0).getMain(),
                            response.body().getDaily().get(i).getWeather().get(0).getDescription(),
                            response.body().getTimezone());

            }

            @Override
            public void onFailure(Call<SecondExample> call, Throwable t) {
            }
        });
    }


}
