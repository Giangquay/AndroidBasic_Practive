package vn.minhgiang.SharedPrerencesAndorid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

import vn.minhgiang.list.R;

public class MySharedPreences extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_shared_preences);
        Set<String> list = new HashSet<>();
        list.add("User1");
        list.add("User2");
        list.add("User3");
      DataLocalManager.setNameInstalled(list);
      findViewById(R.id.btn_next_screen).setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent = new Intent(MySharedPreences.this,MyaSharedPrerences2.class);
              startActivity(intent);
          }
      });
    }
}