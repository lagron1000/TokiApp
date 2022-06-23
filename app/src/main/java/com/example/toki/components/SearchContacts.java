package com.example.toki.components;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.toki.AppDB;
import com.example.toki.R;
import com.example.toki.dbSingleton;

import Models.Contact;
import Models.ContactDao;
import Models.User;
import Models.UserDao;

public class SearchContacts extends AppCompatActivity {

    private AppDB db = dbSingleton.getDb();
    private ContactDao contactDao = dbSingleton.getContactDao();
    private UserDao userDao = dbSingleton.getUserDao();
    private String signId = dbSingleton.getSignedIn().getId();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_contacts);

        Button saveBtn = findViewById(R.id.btn_search);
        saveBtn.setOnClickListener(view -> {
            EditText etVal = findViewById(R.id.et_contact_search);
            EditText etNick = findViewById(R.id.et_nickname);
            EditText etServer = findViewById(R.id.et_server_search);

            String username = etVal.getText().toString();
            String nickname = etNick.getText().toString();
            String server = etServer.getText().toString();

            User u = userDao.get(username);
            if (u != null) {
                Contact c = new Contact(username, nickname, server, signId);
                dbSingleton.addContact(c);
                finish();
            }
            else {
                saveBtn.setError("Try again");
            }
        });
    }
}