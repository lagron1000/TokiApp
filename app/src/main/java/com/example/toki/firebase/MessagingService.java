package com.example.toki.firebase;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.toki.R;
import com.example.toki.components.Chat;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Objects;

public class MessagingService extends FirebaseMessagingService {

    public static final String CHANNEL_ID1 = "1";
    public static final String CHANNEL_ID2 = "2";

    @Override
    public void onNewToken(@NonNull String s) {
        super.onNewToken(s);
    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        if (remoteMessage.getNotification() != null) {
            if (Objects.equals(remoteMessage.getNotification().getTitle(), "GotMessage")) {
                createNotificationChannel();
                NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID1)
                        .setSmallIcon(R.drawable.toki_logo)
                        .setContentTitle("New message")
                        .setContentTitle(remoteMessage.getNotification().getBody())
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);
                NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
                notificationManagerCompat.notify(1, builder.build());

                Intent broadcast = new Intent();
                broadcast.setAction(Chat.NOTIFY_CHAT_ACTION);
                broadcast.putExtra("content",remoteMessage.getNotification().getBody());
            }
        }
        super.onMessageReceived(remoteMessage);
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name1);
            String description = getString(R.string.channel_description1);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID1, name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);

            name = getString(R.string.channel_name2);
            description = getString(R.string.channel_description2);
            channel = new NotificationChannel(CHANNEL_ID2, name, importance);
            channel.setDescription(description);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
