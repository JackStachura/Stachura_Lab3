package com.example.Stachura_Lab3.ui.countries;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.Stachura_Lab3.R;
import com.example.Stachura_Lab3.controller.ItemRecycleView;
import com.example.Stachura_Lab3.model.Country;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CountriesFragment extends Fragment {

    private CountriesViewModel countriesViewModel;
    private RecyclerView recyclerView;
    public static ArrayList<Country> countryList;
    private ItemRecycleView itemRecycleView;
    private RequestQueue queue;
    private final String URL = "https://restcountries.eu/rest/v1/all";

    @Override
    public void onCreate(@Nullable Bundle myBundle) {
        super.onCreate(myBundle);
        countryList = new ArrayList<>();
        countriesViewModel = new ViewModelProvider(this).get(CountriesViewModel.class);
        queue = Volley.newRequestQueue(getContext());
        loadCountryData();
        //now countries are in country list

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_countries, container, false);

        recyclerView = root.findViewById(R.id.my_recycler_view);
        itemRecycleView = new ItemRecycleView(R.layout.cardview_layout, countryList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(itemRecycleView);
        return root;
    }

    private void loadCountryData(){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array = new JSONArray(response);
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject js = array.getJSONObject(i);
                        String name = js.getString("name");
                        String capital = js.getString("capital");
                        String region = js.getString("region");
                        String subregion = js.getString("subregion");
                        String population = js.getString("population");
                        Country country = new Country(name, capital, region, subregion, population);
                        countryList.add(country);
                        recyclerView.setAdapter(itemRecycleView);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        queue.add(stringRequest);
    }
}