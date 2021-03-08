package com.example.Stachura_Lab3.ui.countries;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CountriesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CountriesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is countriesfragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}