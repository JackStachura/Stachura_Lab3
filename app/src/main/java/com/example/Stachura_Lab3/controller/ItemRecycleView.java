package com.example.Stachura_Lab3.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Stachura_Lab3.model.Country;
import com.example.Stachura_Lab3.model.ViewHolder;

import java.util.ArrayList;

public class ItemRecycleView extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private int layout_id;
    private ArrayList<Country> countryList;

    public ItemRecycleView(int id, ArrayList<Country> countries) {
        this.layout_id = id;
        this.countryList = countries;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout_id, parent, false);
        ViewHolder myViewHolder = new ViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TextView name = ((ViewHolder) holder).name;
        TextView capital = ((ViewHolder) holder).capital;
        TextView region = ((ViewHolder) holder).region;
        name.setText(countryList.get(position).name);
        capital.setText("Capital: "+ countryList.get(position).capital);
        region.setText("Region: " + countryList.get(position).region);
    }




    @Override
    public int getItemCount() {
        return countryList.size();
    }


}
