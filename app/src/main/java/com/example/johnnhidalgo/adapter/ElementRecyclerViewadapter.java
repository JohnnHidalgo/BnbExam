package com.example.johnnhidalgo.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.johnnhidalgo.R;
import com.example.johnnhidalgo.model.Element;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ElementRecyclerViewadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    Activity context;
    ArrayList<Element> elementArrayList;

    public ElementRecyclerViewadapter(Activity context, ArrayList<Element> elementArrayList) {
        this.context = context;
        this.elementArrayList = elementArrayList;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.element,parent,false);
        return new RecyclerViewViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Element element = elementArrayList.get(position);
        RecyclerViewViewHolder viewHolder = (RecyclerViewViewHolder) holder;
        viewHolder.tvTitle.setText(element.getTitle());
        viewHolder.tvDescription.setText(element.getDescription());
    }

    @Override
    public int getItemCount() {

        if(this.elementArrayList != null) {
            return this.elementArrayList.size();
        }
        return 0;
    }


    class RecyclerViewViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvDescription;

        public RecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
        }
    }

}


