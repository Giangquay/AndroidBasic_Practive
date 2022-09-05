package vn.minhgiang.PushNotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Date;

import vn.minhgiang.list.R;

public class NotificationPush extends AppCompatActivity {

    private static final int NOTIFICATION_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_push);
        Button btn = findViewById(R.id.pushNotification);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNofification();
            }
        });
    }

    private void sendNofification() {
        Notification notification = new NotificationCompat.Builder(this,Myaplication.CHANNEL_ID)
                .setContentTitle("Tittle Push Notification")
                .setContentText("Message push Notification").
                 setSmallIcon(R.drawable.ic_launcher_foreground)
                .setColor(getResources().getColor(R.color.teal_200))
                .build();
        NotificationManagerCompat notificationManagerCompat =  NotificationManagerCompat.from(NotificationPush.this);
           notificationManagerCompat.notify(getNofificationID(),notification);
//        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//
//        if (notificationManager!= null)
//        {
//            notificationManager.notify(getNofificationID(),notification);
//        }
    }

    private int getNofificationID() {
        return (int) new Date().getTime();
    }
}