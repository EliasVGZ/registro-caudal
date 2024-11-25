package com.example.registro_caudal_android.repository;

import android.util.Log;

import com.example.registro_caudal_android.interfaces.WaterUsageApi;
import com.example.registro_caudal_android.model.WaterUsage;
import com.example.registro_caudal_android.retrofit.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WaterUsageRepository {

    private WaterUsageApi waterUsageApi;

    public WaterUsageRepository() {
        waterUsageApi = RetrofitClient.getRetrofitInstance().create(WaterUsageApi.class);
    }

    public void getTodayWaterVolume(Callback<WaterUsage> callback) {
        Call<WaterUsage> call = waterUsageApi.getTodayWaterVolume();
        call.enqueue(callback);
    }


}
