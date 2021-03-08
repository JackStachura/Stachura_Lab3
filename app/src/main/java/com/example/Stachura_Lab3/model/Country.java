package com.example.Stachura_Lab3.model;

import java.io.Serializable;

public class Country implements Serializable {
    public String name;
    public String capital;
    public String region;
    public String subregion;
    public String population;

    public Country(String n, String c, String r, String sr, String p){
        name = n;
        capital = c;
        region = r;
        subregion = sr;
        population = p;
    }


}
