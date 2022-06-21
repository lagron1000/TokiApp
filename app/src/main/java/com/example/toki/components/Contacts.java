package com.example.toki.components;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.toki.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Contacts extends AppCompatActivity {



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
}