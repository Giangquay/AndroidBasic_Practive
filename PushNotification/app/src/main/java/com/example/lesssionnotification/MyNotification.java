package com.example.lesssionnotification;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.media.AudioAttributes;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;

import androidx.core.app.NotificationCompat;

public class MyNotification extends Application {
    public static final String CHANNEL_ID = "CHANNEL_1";
    public static final String CHANNEL_ID2 = "CHANNEL_2";
    @Override
    public void onCreate() {
        super.onCreate();
        createChannedNotification();
    }

    private void createChannedNotification() {
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
        {
            //uri Push1
            Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.cool);
            //uri push2
            Uri soundUri= Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.i_phone_notification);
            AudioAttributes.Builder attr = new AudioAttributes.Builder().setUsage(AudioAttributes.USAGE_NOTIFICATION);
            AudioAttributes attributes = attr.build();
            CharSequence name = getString(R.string.app_name);
            String description="This is a channel 1";
            int important = NotificationManager.IMPORTANCE_MIN;
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID,name, important);
            notificationChannel.setDescription(description);
            notificationChannel.setSound(soundUri,attributes);

            //configChannel2
            CharSequence name1 = getString(R.string.channelName1);
            String description1 =getString(R.string.channelDescription);
            int important1 = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel notificationChannel1 = new NotificationChannel(CHANNEL_ID2, name1,important1);
            notificationChannel1.setDescription(description1);
            notificationChannel.setSound(uri,attributes);
            //
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            if (notificationManager!=null){
                notificationManager.createNotificationChannel(notificationChannel);
                notificationManager.createNotificationChannel(notificationChannel1);

            }
        }
    }
}
