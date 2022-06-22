package com.example.toki.components;

import android.content.BroadcastReceiver;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.toki.R;
import com.example.toki.dbSingleton;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import Models.Contact;
import Models.ContactDao;
import Models.Message;
import Models.MessageDao;

public class Chat extends AppCompatActivity {
    private ContactDao contactDao = dbSingleton.getContactDao();
    private MessageDao msgDao = dbSingleton.getMsgDao();
    private Contact receiverContact;
    private BroadcastReceiver broadcastReceiver;
    public static final String NOTIFY_CHAT_ACTION = "notify_chat";

    private List<Message> msgs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        ConstraintLayout constraintLayout = findViewById(R.id.chat_layout);
        msgs = msgDao.getMessageFromChat(dbSingleton.getChattingWithId());
//        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
//        animationDrawable.setEnterFadeDuration(2500);
//        animationDrawable.setExitFadeDuration(5000);
//        animationDrawable.start();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String getCurrentTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("HH:mm");
        String currTime = dateTime.format(now);
        return currTime;
    }


    @Override
    protected void onStart() {
        super.onStart();
        for(Message msg : msgs) {
            System.out.println(msg);
        }
//        broadcastReceiver = new BroadcastReceiver() {
//            @Override
//            @RequiresApi(api = Build.VERSION_CODES.O)
//            public void onReceive(Context context, Intent intent) {
//                if (intent.getAction().equals(NOTIFY_CHAT_ACTION)) {
//                    String currTime = getCurrentTime();
//                    String content = intent.getExtras().getString("content", null);
//                    String[] information = content.split(": ");
//                    String sender = information[0];
//                    String text = information[1];
//                    Message message = new Message()
//                    messageDao.insert(message);
//                    if (Objects.equals(sender, receiverContact.getName()));
//
//                }
//            }
//        };
    }

    private void loadContact() {
//        receiverContact = (Contact) getIntent().getSerializableExtra()
    }
}
