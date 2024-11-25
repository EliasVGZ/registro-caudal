package com.example.registro_caudal_android.interfaces;

import com.example.registro_caudal_android.model.WaterUsage;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface WaterUsageApi {

    @POST("api/water/record")
    Call<String> recordWaterUsage(@Body WaterUsage waterUsage);

    @GET("api/water/daily-volume")
    Call<WaterUsage> getTodayWaterVolume();


}
