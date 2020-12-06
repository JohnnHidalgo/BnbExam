package com.example.johnnhidalgo.network;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroInstance {

    public static String BASE_URL = "http://test.bnb.com.bo/mobiletestws/api/Values/";
    private static Retrofit retrofit;
    public static Retrofit getRetroClient() {

        if(retrofit == null ) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }


        Log.e("--------------",retrofit.baseUrl().toString());
        return retrofit;
    }
}
