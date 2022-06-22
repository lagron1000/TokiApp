package com.example.toki.components;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.toki.R;
import com.example.toki.ViewModels.ContactViewModel;
import com.example.toki.adapters.ContactsAdapter;
import com.example.toki.databinding.ActivityContactsBinding;
import com.example.toki.dbSingleton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import Models.Contact;
import Models.ContactDao;
import Models.Message;
import Models.MessageDao;

public class Contacts extends AppCompatActivity implements ContactsAdapter.onContactListener {
    private ActivityContactsBinding binding;
    private ContactViewModel viewModel;
    private ContactsAdapter adapter;
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
        adapter = new ContactsAdapter(this, this);
        viewModel = new ViewModelProvider(this).get(ContactViewModel.class);
        RecyclerView lvContacts = findViewById(R.id.contacts_recycler_view);
        lvContacts.setAdapter(adapter);
        lvContacts.setLayoutManager(new LinearLayoutManager(this));
        viewModel.reload();

        //preferenceManager = new PreferenceManager(getApplicationContext());
        //pm = new PreferenceManager(getApplicationContext());


        viewModel.getLiveData().observe(this, contacts -> {
            this.contacts = contacts;
            adapter.setContacts(contacts);
        });


        //access contacts list using contactDao.index(dbSingleton.getSignedIn().getId());

        FloatingActionButton add = findViewById(R.id.btn_add);
        add.setOnClickListener(view -> {
            Intent i = new Intent(this, SearchContacts.class);
            startActivity(i);
        });

//        binding.progressBarContacts.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onStart() {
        super.onStart();

//        List<Contact> contacts = contactDao.index(dbSingleton.getSignedIn().getId());
//        while(contacts.isEmpty());
//        if(!contacts.isEmpty()){
//            dbSingleton.setChattingWithId(contacts.get(0).getId());
//            Intent i = new Intent(this, Chat.class);
//            startActivity(i);
//        }
//
//        private void Load(Boolean isLoading) {
//          if (isLoading) {
//              binding.progressBarContacts.setVisibility(View.VISIBLE);
//          }
//          else {
//             binding.progressBarContacts.setVisibility(View.INVISIBLE);
//          }
//        }
    }

    @Override
    protected void onResume() {
        super.onResume();
//        binding.progressBarContacts.setVisibility(View.INVISIBLE);
        //recreate the contact list
        viewModel.getLiveData().observe(this, contacts -> {
            this.contacts = contacts;
            adapter.setContacts(contacts);
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void onContactClick(int position) {
        if(position > RecyclerView.NO_POSITION) {
            dbSingleton.setChattingWithId(contacts.get(position).getId()); //the clicked contact
            Intent i = new Intent(this, Chat.class);
            startActivity(i);
        }
    }
}