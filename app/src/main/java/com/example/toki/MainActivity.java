package com.example.toki;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.toki.components.SignIn;

import Models.ContactDao;
import Models.UserDao;

public class MainActivity extends AppCompatActivity {

    private AppDB db = dbSingleton.getDb();
    private ContactDao contactDao = dbSingleton.getContactDao();
    private UserDao userDao = dbSingleton.getUserDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            dbSingleton.refreshUsers();

        Intent i = new Intent(this, SignIn.class);
        startActivity(i);

    }
}