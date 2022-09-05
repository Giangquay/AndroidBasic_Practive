package vn.minhgiang.BroadCastReceiver.BroadCastRecive;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;

import vn.minhgiang.list.R;

public class BroadCastReiver extends AppCompatActivity {

    private ExampleBroadCastReciver exampleBroadCastReciver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast_reiver);
        exampleBroadCastReciver = new ExampleBroadCastReciver();
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(exampleBroadCastReciver,intentFilter);
        IntentFilter intentFilter1 = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
        registerReceiver(exampleBroadCastReciver,intentFilter1);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(exampleBroadCastReciver);
    }
}