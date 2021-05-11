package com.example.android.basicweather;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {

    private ArrayList<String> mWeatherList;
    private ArrayList<String> mWeatherDetailsList;
    private Toast mToast;
    Context mContext;


    public WeatherAdapter(MainActivity mainActivity){
        mWeatherList = new ArrayList<String>();
        mWeatherDetailsList = new ArrayList<String>();
        mToast = null;
        mContext = mainActivity;
    }

    public void addWeather(String weather){
        mWeatherList.add(weather);
        notifyDataSetChanged();
    }

    public void addWeatherDetails(String detail){
        mWeatherDetailsList.add(detail);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mWeatherList.size();
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.weather_list_item, viewGroup, false);
        return new WeatherViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder weatherViewHolder, int i) {
        String weather = mWeatherList.get(mWeatherList.size() - i - 1);
        weatherViewHolder.bind(weather);
    }

    public int adapterPositionToArrayIndex(int i){
        return mWeatherList.size() - i -1;
    }

    class WeatherViewHolder extends RecyclerView.ViewHolder {
        private TextView mWeatherTV;

        public WeatherViewHolder(View itemView){
            super(itemView);
            mWeatherTV = itemView.findViewById(R.id.tv_weather_text);
            mWeatherTV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Resources res =  mContext.getResources();
                    String[] detail = res.getStringArray(R.array.weatherdetails);
                    int position = adapterPositionToArrayIndex(getAdapterPosition());
                    String toastText = detail[position];
                    mToast= Toast.makeText(mContext, toastText, Toast.LENGTH_LONG);
                    mToast.show();
                }
            });
        }

        public void bind(String weather){
            mWeatherTV.setText(weather);
        }

    }
}
