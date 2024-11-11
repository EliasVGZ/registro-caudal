package com.example.registro_caudal_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.registro_caudal_android.repository.WaterUsageRepository;

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
        waterUsageRepository.getTodayWaterVolume(new Callback<Double>() {
            @Override
            public void onResponse(Call<Double> call, Response<Double> response) {
                if (response.isSuccessful() && response.body() != null) {
                    double todayVolume = response.body();
                    String message = "Hoy hasta ahora has gastado " + todayVolume + " litros de agua.";
                    waterVolumeTextView.setText(message);
                } else {
                    waterVolumeTextView.setText("No se pudo obtener el consumo de agua.");
                }
            }

            @Override
            public void onFailure(Call<Double> call, Throwable t) {
                waterVolumeTextView.setText("Error al conectar con el servidor.");
            }
        });
    }
}