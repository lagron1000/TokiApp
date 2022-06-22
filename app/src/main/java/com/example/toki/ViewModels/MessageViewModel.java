package com.example.toki.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.toki.Repositories.ContactRepository;
import com.example.toki.Repositories.MessageRepository;

import java.util.List;

import Models.Contact;
import Models.Message;

public class MessageViewModel extends ViewModel {
    private MessageRepository mRep = new MessageRepository();
    private LiveData<List<Message>> liveData;

    public MessageViewModel() {
        liveData = mRep.getAll();
    }

    public LiveData<List<Message>> getLiveData() {
        if (liveData == null) {
            this.liveData = new MutableLiveData<>();
        }
        return liveData;
    }

    public Message getSpecific(String id) {
        return liveData.getValue().get(liveData.getValue().indexOf(id));
    }

    public void add(Contact contact) {
        mRep.add(contact);
    }

    public void reload() {
        mRep.reload();
    }

}
