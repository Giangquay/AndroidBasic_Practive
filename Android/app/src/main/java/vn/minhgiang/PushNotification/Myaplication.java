package vn.minhgiang.PushNotification;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

import vn.minhgiang.list.R;

public class Myaplication extends Application {
    public static final String CHANNEL_ID="Channel_ID_1";
    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannel();
    }
    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O) {
            int important = NotificationManager.IMPORTANCE_DEFAULT;
            String description = getString(R.string.channel_description);
            CharSequence name = getString(R.string.channel_name);
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, name, important);
            notificationChannel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
    }
}
