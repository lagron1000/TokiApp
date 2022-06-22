package com.example.toki.ViewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.toki.Repositories.ContactRepository;

public class ContactViewModel extends ViewModel {
    private ContactRepository contactRepository;
    private MutableLiveData<String> liveData;

    public MutableLiveData<String> getLiveData() {
        if (liveData == null) {
            this.liveData = new MutableLiveData<>();
        }
        return liveData;
    }

    //private Contact
}
