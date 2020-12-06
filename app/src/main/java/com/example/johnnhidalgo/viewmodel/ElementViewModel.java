package com.example.johnnhidalgo.viewmodel;
import com.example.johnnhidalgo.model.Element;
import java.util.ArrayList;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ElementViewModel extends ViewModel {

    MutableLiveData<ArrayList<Element>> elementLiveData;
    ArrayList<Element> elementArrayList;

    public ElementViewModel (){
        elementLiveData = new MutableLiveData<>();
        init();
    }

    public MutableLiveData<ArrayList<Element>> getElementMutableLiveData(){
        return elementLiveData;
    }

    public void init (){
        getElementsList();
        elementLiveData.setValue(elementArrayList);
    }

    public void getElementsList(){
        Element element = new Element();
        element.setTitle("Caja de ahorro");
        element.setDescription("ncuentra una caja de ahorro a tu medida para que   puedas ser parte de la mejor banca del país");
        element.setLongDescription("null");
        elementArrayList = new ArrayList<>();
        userArrayList.add(element);
        userArrayList.add(element);
        userArrayList.add(element);
        userArrayList.add(element);
        userArrayList.add(element);
        userArrayList.add(element);
    }

}
