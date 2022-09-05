package vn.minhgiang.BroadCastReceiver.BroadCastRecive2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.util.ArrayList;
import java.util.List;

import vn.minhgiang.ActivitysangFragment.User;
import vn.minhgiang.list.R;

public class BroadCastReciver2 extends AppCompatActivity {
    private static final String Action="vn.Giang.ACTION";
    private static final String KeyAction="vn.Giang.NguyenMinhGiang";
    private Button sendReciver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast_reciver2);
        sendReciver=  findViewById(R.id.btnreiver);

        sendReciver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicksendBroad();
            }
        });
    }

    private void clicksendBroad() {
        Intent intent = new Intent(Action);
        User user = new User("Giang","minhgiang2001");
        User user1 = new User("Quang","Quang2001");
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        Gson gson = new Gson();
        JsonArray jsonArray = gson.toJsonTree(list).getAsJsonArray();
        String jsonArrayUser = jsonArray.toString();

//        String jsonuser = gson.toJson(user);
//        intent.putExtra(KeyAction,jsonuser);
        intent.putExtra(KeyAction,jsonArrayUser);
        sendBroadcast(intent);
        Toast.makeText(this,"Send Success",Toast.LENGTH_LONG).show();
    }

}