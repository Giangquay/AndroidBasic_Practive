package com.example.Getreciver2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

import com.example.getreciverbroadcast.R;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GetJson extends AppCompatActivity {
    private static final String Action="vn.Giang.ACTION";
    private static final String KeyAction="vn.Giang.NguyenMinhGiang";
    TextView textJson;
    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (Action.equals(intent.getAction())) {
                String userjson = intent.getStringExtra(KeyAction);
                //danh sach doi tuong
                List<User> list = getListUser(userjson);
                String listObjec="";
                for (int i=0;i<list.size();i++)
                {
                    User user = list.get(i);
                    listObjec=listObjec+"Name: "+user.getName()+" Email: "+user.getEmail()+"\n";
                }
                //1 doi tuong
//                Gson gson = new Gson();
//                User user = gson.fromJson(userjson,User.class);
//                textJson.setText("Name: " + user.getName() + "\\t Email: " + user.getEmail());
                textJson.setText(listObjec);
            }
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_json);
        textJson=findViewById(R.id.textviewJson);
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
    private List<User> getListUser(String userjson) {
        List<User> ls = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(userjson);
            JSONObject jsonObject;
            User user;
            Gson gson = new Gson();
            for (int i=0;i<jsonArray.length();i++)
            {
                jsonObject=jsonArray.getJSONObject(i);
                user=gson.fromJson(jsonObject.toString(),User.class);
                ls.add(user);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return ls;
    }
}