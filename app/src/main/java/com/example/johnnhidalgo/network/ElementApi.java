package com.example.johnnhidalgo.network;

import com.example.johnnhidalgo.model.Element;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ElementApi {
    @POST("/data")
    Call<List<Element>> getElement(
    );
}


