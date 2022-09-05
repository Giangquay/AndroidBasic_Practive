package vn.minhgiang.BroadCastReceiver.BoradCastRecive1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import vn.minhgiang.list.R;

public class CustomReciver extends AppCompatActivity {
    private static final String Action="vn.Giang.coder";
    private static final String KeyAction="vn.Giang.NguyenMinhGiang";
    Button btnsend;
    TextView getview;

    private BroadcastReceiver broadcastReceiver= new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String getviewsend=intent.getStringExtra(KeyAction);
            getview.setText(getviewsend);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_reciver);
        btnsend=findViewById(R.id.btnsend);
        getview=findViewById(R.id.getReciver);
        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendReciver();
            }
        });
    }

    private void sendReciver() {
        Intent intent = new Intent(Action);
        intent.putExtra(KeyAction,"Du lieu Custom_reciver");
        sendBroadcast(intent);
    }

    @Override
    protected void onStart() {
        IntentFilter intentFilter = new IntentFilter(Action);
        registerReceiver(broadcastReceiver,intentFilter);
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(broadcastReceiver);
    }
}