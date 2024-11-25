package com.example.registro_caudal_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.registro_caudal_android.model.WaterUsage;
import com.example.registro_caudal_android.repository.WaterUsageRepository;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private WaterUsageRepository waterUsageRepository;
    private TextView waterVolumeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        waterUsageRepository = new WaterUsageRepository();
        waterVolumeTextView = findViewById(R.id.waterVolumeTextView);

        //Llamada para obtener el volumen diario de agua
        getTodayWaterVolume();


    }

    private void getTodayWaterVolume() {
        waterUsageRepository.getTodayWaterVolume(new Callback<WaterUsage>() {
            @Override
            public void onResponse(Call<WaterUsage> call, Response<WaterUsage> response) {
                if (response.isSuccessful() && response.body() != null) {
                    WaterUsage waterUsage = response.body();

                    Gson gson = new Gson();
                    String json = gson.toJson(waterUsage);
                    Log.d("WaterUsage", "Response body as JSON: " + json);

                    String message = "Hoy hasta "+waterUsage.getFecha() + " has gastado "+waterUsage.getTotalVolumen()+" litros de agua.";
                    Log.d("WaterUsage", message);

                    waterVolumeTextView.setText(message);
                } else {
                    waterVolumeTextView.setText("No se pudo obtener el consumo de agua.");
                }
            }

            @Override
            public void onFailure(Call<WaterUsage> call, Throwable t) {
                waterVolumeTextView.setText("Error al conectar con el servidor.");
            }
        });
    }
}