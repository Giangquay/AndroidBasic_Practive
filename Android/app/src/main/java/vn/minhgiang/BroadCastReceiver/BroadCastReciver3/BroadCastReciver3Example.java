package vn.minhgiang.BroadCastReceiver.BroadCastReciver3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BroadCastReciver3Example extends BroadcastReceiver {
    private static final String My_TEXT="vn.giang.nguyenminhGiang";
    @Override
    public void onReceive(Context context, Intent intent) {
        String transport = intent.getStringExtra(My_TEXT);
        Toast.makeText(context,transport,Toast.LENGTH_LONG).show();
    }
}
