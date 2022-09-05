package com.example.lesssionnotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private static final String PUSH_CONTENT_NOTIFICATION="Starting in Android 8.0 (API level 26), " +
            "notifications that use the NotificationCompat.MessagingStyle class display more content " +
            "in their collapsed form. You can also use the addHistoricMessage() " +
            "method to provide context to a conversation by" +
            " adding historic messages to messaging-related notifications.";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.PushNotification1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendNotification();
            }
        });
        Button button1 = findViewById(R.id.PushNotification2);
        button1.setOnClickListener(view -> {
            sendNotificationChannel2();
        });
    }

    private void sendNotificationChannel2() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.light_bulb);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.cool);
        Notification builder = new NotificationCompat.Builder(this,MyNotification.CHANNEL_ID2)
                .setContentText(PUSH_CONTENT_NOTIFICATION)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(PUSH_CONTENT_NOTIFICATION))
                .setColor(getResources().getColor(R.color.purple_200))
                .setSmallIcon(R.drawable.bell)
                .setLargeIcon(bitmap)
                .setSound(uri)
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setContentTitle("Title push Notification 2")
                .setCategory(NotificationCompat.CATEGORY_ALARM)
                .setAutoCancel(true).build();
        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        managerCompat.notify(getNotificationID(),builder);
    }

    private void sendNotification() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bitmappush1);
        Uri soundUri= Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.i_phone_notification);
        Notification builder = new NotificationCompat.Builder(this,MyNotification.CHANNEL_ID)
                .setLargeIcon(bitmap).setContentTitle("Title push Notification").setContentText("Mess Push Notification")
                .setColor(getResources().getColor(R.color.purple_200))
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setSound(soundUri)
                .setPriority(NotificationCompat.PRIORITY_MIN)
                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap).bigLargeIcon(null))
                .setCategory(NotificationCompat.CATEGORY_ALARM)
                .setAutoCancel(true).build();
        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        managerCompat.notify(getNotificationID(),builder);
    }
    private  int getNotificationID()
    {
        return (int) new Date().getTime();
    }
}