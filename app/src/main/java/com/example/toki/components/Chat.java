package com.example.toki.components;

import android.content.BroadcastReceiver;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.toki.AppDB;
import com.example.toki.R;
import com.example.toki.components.Contacts;

import Models.Contact;

public class Chat extends AppCompatActivity {
    private Contact receiverContact;
    private AppDB dataBase;
    private BroadcastReceiver broadcastReceiver;
    public static final String NOTIFY_CHAT_ACTION = "notify_chat";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        ConstraintLayout constraintLayout = findViewById(R.id.chat_layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();
    }

    private void loadContact() {
//        receiverContact = (Contact) getIntent().getSerializableExtra()
    }
}
