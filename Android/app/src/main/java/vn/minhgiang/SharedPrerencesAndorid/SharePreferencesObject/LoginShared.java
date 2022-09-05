package vn.minhgiang.SharedPrerencesAndorid.SharePreferencesObject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import vn.minhgiang.SharedPrerencesAndorid.Model.User;
import vn.minhgiang.SharedPrerencesAndorid.MyaSharedPrerences2;
import vn.minhgiang.list.R;
public class LoginShared extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_shared);
        User user = new User(1,"Giang","Hanoi");
        DataLocalManga.setUser(user);
        findViewById(R.id.btnSend_SharedPreferences).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginShared.this, MyaSharedPrerences2.class);
                startActivity(intent);
            }
        });
    }
}