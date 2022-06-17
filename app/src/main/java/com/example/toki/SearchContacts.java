package com.example.toki;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import Models.Contact;
import Models.ContactDao;
import Models.User;
import Models.UserDao;

public class SearchContacts extends AppCompatActivity {

    private AppDB db;
    private ContactDao contactDao;
    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_contacts);

        db = Room.databaseBuilder(getApplicationContext(), AppDB.class, "TokiDB")
                .allowMainThreadQueries()
                .build();

        contactDao = db.contactDao();
        userDao = db.userDao();

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
                contactDao.insert(new Contact(username, server, nickname));
            }
        });
    }
}