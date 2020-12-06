package com.example.johnnhidalgo.request;

import com.example.johnnhidalgo.util.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Service {

    private static Retrofit.Builder retrofitBuilder =
            new Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();

    private static BnbApi bnbApi = retrofit.create(BnbApi.class);

    public static BnbApi getRecipeApi(){
        return bnbApi;
    }

}
