package com.example.toki.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.toki.Repositories.ContactRepository;

import java.util.List;

import Models.Contact;

public class ContactViewModel extends ViewModel {
    private ContactRepository contactRepository = new ContactRepository();
    private LiveData<List<Contact>> liveData;

    public ContactViewModel() {
        liveData = contactRepository.getAll();
    }

    public LiveData<List<Contact>> getLiveData() {
        if (liveData == null) {
            this.liveData = new MutableLiveData<>();
        }
        return liveData;
    }

    public Contact getSpecific(String id) {
        return liveData.getValue().get(liveData.getValue().indexOf(id));
    }

    public void add(Contact contact) {
        contactRepository.add(contact);
    }

    public void reload() {
        contactRepository.reload();
    }

    //private Contact
}
