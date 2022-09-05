package com.example.getreciverbroadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String Action ="vn.Giang.coder";
    private static final String ActionKey ="vn.Giang.NguyenMinhGiang";
    private TextView gettextAPPdifferent;
    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
                gettextAPPdifferent.setText(intent.getStringExtra(ActionKey));
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gettextAPPdifferent=findViewById(R.id.getActionApp);
    }

    @Override
    protected void onStart() {
        IntentFilter intentFilter = new IntentFilter(Action);
        registerReceiver(broadcastReceiver,intentFilter);
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcastReceiver);
    }
}