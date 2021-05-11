package com.example.android.basicweather;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


public class MainActivity extends AppCompatActivity {

    private RecyclerView mWeatherListRV;
    private WeatherAdapter mWeatherAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWeatherListRV = findViewById(R.id.rv_weather_list);
        mWeatherAdapter = new WeatherAdapter(this);

        mWeatherListRV.setLayoutManager(new LinearLayoutManager(this));
        mWeatherListRV.setHasFixedSize(true);

        mWeatherListRV.setAdapter(mWeatherAdapter);

        Resources res =  getResources();
        String[] weather = res.getStringArray(R.array.weather);
        String [] weatherdetails = res.getStringArray(R.array.weatherdetails);
        for(String s : weather){
            mWeatherAdapter.addWeather(s);
        }
        for(String p : weatherdetails){
            mWeatherAdapter.addWeatherDetails(p);
        }

    }


}
