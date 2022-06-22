package com.example.toki.components;
import java.util.ArrayList;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.toki.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.*;

import Models.Contact;

public class Contacts extends AppCompatActivity {

    List<Contact> contacts = new ArrayList<Contact>();

    Contacts () {
        Contact Lior = new Contact("1","Lior", "1", "2");
        Contact Nofar = new Contact("2","Nofar", "1", "3");
        Contact Maya = new Contact("3","Maya","1","1");
        contacts.add(Lior);
        contacts.add(Nofar);
        contacts.add(Maya);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);


        FloatingActionButton add = findViewById(R.id.btn_add);
        add.setOnClickListener(view -> {
            Intent i = new Intent(this, SearchContacts.class);
            startActivity(i);
        });
    }

    public List<Contact> getContacts() {
        return contacts;
    }
}