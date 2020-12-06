package com.example.johnnhidalgo.request;

import com.example.johnnhidalgo.model.Element;
import com.example.johnnhidalgo.request.responces.ElementResponce;
import com.example.johnnhidalgo.util.Constants;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Response;

public class ElementApiClient {

    private static final String TAG = "ElementApiClient";

    private static ElementApiClient instance;
    private MutableLiveData<List<Element>> mElement;

    public static ElementApiClient getInstance(){
        if(instance==null){
            instance = new ElementApiClient();
        }
        return instance;
    }

    private ElementApiClient(){
        mElement = new MutableLiveData<>();
    }

    public LiveData<List<Element>> getElements(){
        return mElement;
    }



    private class RetrieveElementRunnable implements Runnable{
        private String query;
        private int pageNumber;
        boolean cancelRequest;

        public RetrieveElementRunnable(String query, int pageNumber, boolean cancelRequest) {
            this.query = query;
            this.pageNumber = pageNumber;
            this.cancelRequest = cancelRequest;
        }


        @Override
        public void run(){
            try{
                Response response = getRecipes(query,pageNumber).execute();
                if (cancelRequest){
                    return;
                }
                if(response.code() == 200){
                    List<Element> list = new ArrayList<>(((ElementResponce)response.body()).getElement());
                    if(pageNumber == 1){
                        mElement.postValue(list);
                    }
                    else {
                        List<Element> currentElements = mElement.getValue();
                        currentElements.addAll(list);
                        mElement.postValue(currentElements);
                    }
                }
                else {
                    String error = response.errorBody().string();
                    mElement.postValue(null);
                }
            }catch (IOException e){
                e.printStackTrace();
                mElement.postValue(null);
            }
        }



        private Call<ElementResponce> getElements(String query, int pageNumber){
            return Service.getBnbApi().getElement(
                    Constants.API_KEY,
                    query,
                    String.valueOf(pageNumber)
            );
        }

        private void cancelRequest (){
            cancelRequest = true;
        }





    }

}
