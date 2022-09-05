package vn.minhgiang.BroadCastReceiver.BroadCastReciver3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import vn.minhgiang.list.R;

public class BroadCastReciver3 extends AppCompatActivity {
    private static final String Acion="vn.giang1.nguyenminhgiang";
    private static final String My_TEXT="vn.giang.nguyenminhGiang";
    private Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast_reciver3);
        btn1=findViewById(R.id.btnsend3);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPutReceiver();
            }
        });
    }

    private void onPutReceiver() {
//        Intent intent = new Intent(this,BroadCastReciver3Example.class);
        Intent intent = new Intent();
        /////////truyen du lieu qua nhieu object
//        Intent intent1 = new Intent(Acion);

        // c2 Dung Set class
//        intent.setClass(this,BroadCastReciver3Example.class);
        //c3 dung ComponentName
        //Package ben project khac va lop class cua project do

        /*
        /////////truyen du lieu qua nhieu object
        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> resolveInfos=packageManager.queryBroadcastReceivers(intent,0);
        for (ResolveInfo info:resolveInfos )
        {
            ComponentName componentName= new ComponentName(info.activityInfo.packageName,info.activityInfo.name);
            intent1.setComponent(componentName);
            sendBroadcast(intent1);
        }

         */
        ComponentName componentName =
                new ComponentName("com.example.getreciverbroadcast",
                "com.example.getreciverbroadcast.MyBroadcastReciver3");
        intent.setComponent(componentName);
        intent.putExtra(My_TEXT,"This is a new broadcastReceiver Explicit");
        sendBroadcast(intent);
    }
}