package com.example.johnnhidalgo.request;

import com.example.johnnhidalgo.request.responces.ElementResponce;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface BnbApi {

    @POST("/data")
    Call<ElementResponce> getElement(
            @Query("key") String key,
            @Query("Title") String Title,
            @Query("Description") String Description

    );


}
