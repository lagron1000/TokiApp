package com.example.toki;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.toki.api.UsersAPI;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import Models.ContactDao;

public class MainActivity extends AppCompatActivity {

    private AppDB db;
    private ContactDao contactDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = Room.databaseBuilder(getApplicationContext(), AppDB.class, "TokiDB")
                .allowMainThreadQueries()
                .build();

        contactDao = db.contactDao();

        UsersAPI cApi = new UsersAPI();
        cApi.getUsers();


    }
}