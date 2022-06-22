package com.example.toki.components;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceGroup;
import android.preference.PreferenceManager;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.toki.R;
import com.example.toki.ViewModels.ContactViewModel;
import com.example.toki.databinding.ActivityContactsBinding;
import com.example.toki.dbSingleton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import Models.Contact;
import Models.ContactDao;
import Models.Message;
import Models.MessageDao;

public class Contacts extends AppCompatActivity {
    private ActivityContactsBinding binding;
    private ContactViewModel viewModel;
    //POST ACTIVITY
    //ONCLICK MEATHOD
    //ADD CONTACTS
    //SETTINGS
    //protected PreferenceManager preferenceManager;
    private ContactDao contactDao = dbSingleton.getContactDao();
    private MessageDao msgDao = dbSingleton.getMsgDao();

    List<Contact> contacts;
    List<Message> msgs;
    //private PreferenceManager preferenceManager;

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
//        binding = ActivityContactsBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
        setContentView(R.layout.activity_contacts);
        viewModel = new ViewModelProvider(this).get(viewModel.getClass());
//        RecyclerView
        //preferenceManager = new PreferenceManager(getApplicationContext());
        //pm = new PreferenceManager(getApplicationContext());


        dbSingleton.updateContactList();

        //access contacts list using contactDao.index(dbSingleton.getSignedIn().getId());

        FloatingActionButton add = findViewById(R.id.btn_add);
        add.setOnClickListener(view -> {
            Intent i = new Intent(this, SearchContacts.class);
            startActivity(i);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        List<Contact> contacts = contactDao.index(dbSingleton.getSignedIn().getId());
//        while(contacts.isEmpty());
        if(!contacts.isEmpty()){
            dbSingleton.setChattingWithId(contacts.get(0).getId());
            Intent i = new Intent(this, Chat.class);
            startActivity(i);
        }

    private void Load(Boolean isLoading) {
        if (isLoading) {
            binding.progressBarContacts.setVisibility(View.VISIBLE);
        }
        else {
            binding.progressBarContacts.setVisibility(View.INVISIBLE);
        }
    }

    }
}