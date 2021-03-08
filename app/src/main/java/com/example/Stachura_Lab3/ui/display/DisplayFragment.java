package com.example.Stachura_Lab3.ui.display;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import com.example.Stachura_Lab3.R;
import com.example.Stachura_Lab3.model.Country;

import java.util.ArrayList;

public class DisplayFragment extends Fragment {


    private View view;
    public static DisplayFragment newInstance() {
        return new DisplayFragment();
    }



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.display_fragment, container, false);
        view = v;
        Button back_button = v.findViewById(R.id.backButton);
        Bundle b = this.getArguments();
        ArrayList<Country> countries = (ArrayList<Country>) b.getSerializable("lstCountries");
        TextView tv = v.findViewById(R.id.country_info_extra);
        String name_selected = b.getString("nameCountry");
        String to_display = getDisplayString(name_selected, countries);
        tv.setText(to_display);


        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_displayFragment_to_navigation_countries);
            }
        });
        return v;
    }

    private String getDisplayString(String name_selected, ArrayList<Country> countries) {
        for (Country c : countries){

            if (c.name.equals(name_selected)){
                return "More on " + name_selected + ":\nPopulation: " + c.population + "\nSubregion: " + c.subregion;
            }
        }
        return "Error, no Country Selected";
    }





}