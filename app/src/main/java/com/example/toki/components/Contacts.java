package com.example.toki.components;
import java.util.ArrayList;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.toki.R;
import com.example.toki.dbSingleton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.*;
import Models.Contact;
import Models.ContactDao;

public class Contacts extends AppCompatActivity {
    private ContactDao contactDao = dbSingleton.getContactDao();
//     List<Contact> contacts = new ArrayList<Contact>();

//     Contacts () {
//         Contact Lior = new Contact("1","Lior", "1", "2");
//         Contact Nofar = new Contact("2","Nofar", "1", "3");
//         Contact Maya = new Contact("3","Maya","1","1");
//         contacts.add(Lior);
//         contacts.add(Nofar);
//         contacts.add(Maya);
//     }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        dbSingleton.updateContactList();
        //access contacts list using contactDao.index(dbSingleton.getSignedIn().getId());
<<<<<<< HEAD
        List<Contact> list = contactDao.index(dbSingleton.getSignedIn().getId());
        if (!list.isEmpty()) {

        }
=======
        contacts = contactDao.index(dbSingleton.getSignedIn().getId());
>>>>>>> 3d156854229eb26ba6e2062558ed4759608b5a06

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