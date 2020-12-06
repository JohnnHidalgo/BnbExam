package com.example.johnnhidalgo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.johnnhidalgo.adapter.ElementRecyclerViewadapter;
import com.example.johnnhidalgo.model.Element;
import com.example.johnnhidalgo.viewmodel.ElementViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    MainActivity context;
    ElementViewModel elementViewModel;
    RecyclerView recyclerView;
    ElementRecyclerViewadapter elementRecyclerViewadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        context = this;

        recyclerView = findViewById(R.id.rvElement);
        elementViewModel = ViewModelProviders.of(context).get(ElementViewModel.class);
        elementViewModel.getElementMutableLiveData().observe(context,elementListUpdateObserer);

    }


    Observer<ArrayList<Element>> elementListUpdateObserer = new Observer<ArrayList<Element>>() {

        @Override
        public void onChanged(ArrayList<Element> elements) {
            elementRecyclerViewadapter = new ElementRecyclerViewadapter(context,elements);
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(elementRecyclerViewadapter);
        }
    };
}