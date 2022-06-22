package com.example.toki.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.toki.Repositories.ContactRepository;

import Models.Message;

public class MessageViewModel extends ViewModel {
    private ContactRepository contactRepository;
    private MutableLiveData<Message> liveData;

//    public LiveData<Message> getLiveData() {
//        if (liveData == null) {
//            this.liveData = new MutableLiveData<>();
//        }
//        return liveData;
//    }
//    public MutableLiveData<>

}
