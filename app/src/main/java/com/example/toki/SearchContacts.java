package com.example.toki;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import Models.ContactDao;

public class SearchContacts extends AppCompatActivity {

    private AppDB db;
    private ContactDao contactDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_contacts);

        db = Room.databaseBuilder(getApplicationContext(), AppDB.class, "TokiDB")
                .allowMainThreadQueries()
                .build();

        contactDao = db.contactDao();

        Button saveBtn = findViewById(R.id.btn_search);
        saveBtn.setOnClickListener(view -> {
            EditText username = findViewById(R.id.et_contact_search);

        });
    }
}