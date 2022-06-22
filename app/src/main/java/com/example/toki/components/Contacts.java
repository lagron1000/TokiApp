package com.example.toki.components;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.toki.R;
import com.example.toki.dbSingleton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import Models.Contact;
import Models.ContactDao;

public class Contacts extends AppCompatActivity {
    private ContactDao contactDao = dbSingleton.getContactDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        dbSingleton.updateContactList();
        //access contacts list using contactDao.index(dbSingleton.getSignedIn().getId());
        List<Contact> list = contactDao.index(dbSingleton.getSignedIn().getId());

        FloatingActionButton add = findViewById(R.id.btn_add);
        add.setOnClickListener(view -> {
            Intent i = new Intent(this, SearchContacts.class);
            startActivity(i);
        });
    }
}