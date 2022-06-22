package com.example.toki.Repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.toki.AppDB;
import com.example.toki.api.ContactsAPI;
import com.example.toki.components.Contacts;
import com.example.toki.dbSingleton;

import java.util.List;

import Models.Contact;
import Models.ContactDao;

public class ContactRepository {
    private ContactDao dao = dbSingleton.getContactDao();
    private ContactsAPI api = dbSingleton.getcApi();
    private AppDB db = dbSingleton.getDb();
    ContactsData data = new ContactsData();
//    List<Contact> contacts;
    class ContactsData extends MutableLiveData<List<Contact>> {
        public ContactsData() {
            super();
            List<Contact> list = dao.index(dbSingleton.getSignedIn().getId());
            setValue(list);
        }

        @Override
        protected void onActive() {
            super.onActive();
            data.postValue(dao.index(dbSingleton.getSignedIn().getId()));
            new Thread(()-> {
                dbSingleton.updateContactList();
            }).start();
        }

        public LiveData<List<Contact>> getAll() {
            return data;
        }

        public void add(final Contact contact) {
            dbSingleton.addContact(contact);
        }

        public void reload() {
            dbSingleton.updateContactList();
        }


    }
}

