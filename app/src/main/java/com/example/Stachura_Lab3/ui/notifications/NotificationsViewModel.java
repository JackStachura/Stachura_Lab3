package com.example.Stachura_Lab3.ui.notifications;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NotificationsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public NotificationsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is the notifications section. \n\nNew notifications will appear here!");
    }

    public LiveData<String> getText() {
        return mText;
    }
}