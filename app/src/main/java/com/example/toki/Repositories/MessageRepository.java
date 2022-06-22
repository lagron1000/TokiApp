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
import Models.Message;
import Models.MessageDao;

public class MessageRepository {
    private MessageDao dao = dbSingleton.getMsgDao();
    private AppDB db = dbSingleton.getDb();
    MessagesData data = new MessagesData();
    List<Message> messages;

    public LiveData<List<Message>> getAll() {
        return data;
    }

    public void add(final Contact contact) {
        dbSingleton.addContact(contact);
    }

    public void reload() {
        dbSingleton.updateContactList();
    }


    class MessagesData extends MutableLiveData<List<Message>> {
        public MessagesData() {
            super();
            List<Message> list = dao.getAllMessagesFromAllChats();
            setValue(list);
        }

        @Override
        protected void onActive() {
            super.onActive();
            data.postValue(dao.getAllMessagesFromAllChats());
            new Thread(()-> {
                dbSingleton.updateMessages(dbSingleton.getChattingWithId());
            }).start();
        }



    }
}

