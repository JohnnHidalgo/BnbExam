package com.example.johnnhidalgo.network;

import com.example.johnnhidalgo.model.Element;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ElementApi {
    @POST()
    Call<List<Element>> getElement();

}


