package vn.minhgiang.BroadCastReceiver.BroadCastRecive;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class ExampleBroadCastReciver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();
        //c1
        if (BluetoothAdapter.ACTION_STATE_CHANGED.equals(action)) {
            final int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.ERROR);
            switch(state) {
                case BluetoothAdapter.STATE_OFF:
                    Toast.makeText(context,"Bluetooth da tat ",Toast.LENGTH_SHORT).show();
                    break;
                case BluetoothAdapter.STATE_TURNING_OFF:
                    Toast.makeText(context,"Bluetooth dang tat ",Toast.LENGTH_SHORT).show();
                    break;
                case BluetoothAdapter.STATE_ON:
                    Toast.makeText(context,"Bluetooth mo ",Toast.LENGTH_SHORT).show();
                    break;
                case BluetoothAdapter.STATE_TURNING_ON:
                    Toast.makeText(context,"Bluetooth dang mo ",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
        //c2
        if (action.equals(ConnectivityManager.CONNECTIVITY_ACTION))
        {
            boolean noConnectivity = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY,false);

            if (noConnectivity)
            {
                Toast.makeText(context,"Disconnect",Toast.LENGTH_LONG).show();
            }else
            {
                Toast.makeText(context,"Connected",Toast.LENGTH_LONG).show();
            }
        }
    }


    // thông báo cho người dùng khi nắng nghe hệ thông Mang
//    @Override
//    public void onReceive(Context context, Intent intent) {
//            if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction()))
//            {
//
//                if (isNetWorkAvaiable(context))
//                {
//                    Toast.makeText(context.getApplicationContext(),"Internet connected",Toast.LENGTH_LONG).show();
//
//                }else
//                {
//                    Toast.makeText(context.getApplicationContext(),"Internet Disconnected",Toast.LENGTH_LONG).show();
//                }
//            }
//
//    }

    private boolean isNetWorkAvaiable(@NonNull Context context) {
            ConnectivityManager connectivityManager =(ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivityManager==null)
            {
                return false;
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            {
                Network network = connectivityManager.getActiveNetwork();
                if (network==null)
                {
                    return false;
                }
                NetworkCapabilities capabilities = connectivityManager.getNetworkCapabilities(network);
                return (capabilities != null&&capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI));
            }else
            {
                NetworkInfo networkInfo =connectivityManager.getActiveNetworkInfo();
                return (networkInfo!=null && networkInfo.isConnected());
            }
    }
}
