package com.example.johnnhidalgo.request.responces;

import com.example.johnnhidalgo.model.Element;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ElementResponce {

    @SerializedName("element")
    @Expose
    private List<Element> element;


    public List<Element> getElement(){
        return element;
    }

    @Override
    public String toString() {
        return "ElementResponce{" +
                "element=" + element +
                '}';
    }
}
