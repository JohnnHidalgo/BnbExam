package com.example.johnnhidalgo.viewmodel;
import android.util.Log;

import com.example.johnnhidalgo.model.Element;
import com.example.johnnhidalgo.network.RetroInstance;
import com.example.johnnhidalgo.network.ElementApi;
import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ElementViewModel extends ViewModel {

    MutableLiveData<ArrayList<Element>> elementLiveData;
    ArrayList<Element> elementArrayList;
    private boolean mIsViewingRecipes;
    private boolean mIsPerformingQuery;



    public ElementViewModel (){
        elementLiveData = new MutableLiveData<>();
        init();
    }


    public MutableLiveData<ArrayList<Element>> getElementMutableLiveData(){
        return elementLiveData;
    }

    public void init (){
        getElementsList();
        //makeApiCall();
        elementLiveData.setValue(elementArrayList);
    }

    public void makeApiCall(){
        ElementApi elementApi = RetroInstance.getRetroClient().create(ElementApi.class);
        Call<List<Element>> call = elementApi.getElement();
        call.enqueue(new Callback<List<Element>>() {
            @Override
            public void onResponse(Call<List<Element>> call, Response<List<Element>> response) {

                Log.e("DEBUD","response.body().toString()");
                Log.e("DEBUD",response.body().toString());

                elementArrayList = new ArrayList<>();
                elementArrayList.addAll(response.body());
                //elementLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Element>> call, Throwable t) {
                elementLiveData.postValue(null);
            }
        });

    }

    public boolean isViewingElement(){
        return mIsViewingRecipes;
    }

    public void getElementsList(){
        Element element = new Element();
        element.setTitle("Caja de ahorro");
        element.setDescription("Encuentra una caja de ahorro a tu medida para que   puedas ser parte de la mejor banca del país");
        element.setLongDescription("null");
        elementArrayList = new ArrayList<>();
        elementArrayList.add(element);
        elementArrayList.add(element);
        elementArrayList.add(element);
        elementArrayList.add(element);
        elementArrayList.add(element);
//        elementArrayList.add(element);


    }

}
