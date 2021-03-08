package com.example.Stachura_Lab3.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Welcome to the Countries App!\n\n Select the countries tab to learn more about the world.");
    }

    public LiveData<String> getText() {
        return mText;
    }
}