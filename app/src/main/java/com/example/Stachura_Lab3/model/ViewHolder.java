package com.example.Stachura_Lab3.model;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Stachura_Lab3.R;
import com.example.Stachura_Lab3.ui.countries.CountriesFragment;
import com.example.Stachura_Lab3.ui.display.DisplayFragment;

import java.io.Serializable;
import java.util.ArrayList;

public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView name;
    public TextView capital;
    public TextView region;
    public ArrayList<Country> countryList;
    public ViewHolder(View itemView){
        super(itemView);
        itemView.setOnClickListener(this);
        name = itemView.findViewById(R.id.text_name);
        capital = itemView.findViewById(R.id.text_capital);
        region = itemView.findViewById(R.id.text_region);
        countryList = CountriesFragment.countryList;

    }

    @Override
    public void onClick(View v) {
        Log.i("TAG", "Clicked" + this.name.getText());
        Bundle bundle = new Bundle();
        bundle.putSerializable("lstCountries", (Serializable) countryList);
        bundle.putString("nameCountry", this.name.getText().toString());
        Fragment displayFragment = new DisplayFragment();
        displayFragment.setArguments(bundle);
        Navigation.findNavController(v).navigate(R.id.action_navigation_countries_to_displayFragment, bundle);






    }
}
