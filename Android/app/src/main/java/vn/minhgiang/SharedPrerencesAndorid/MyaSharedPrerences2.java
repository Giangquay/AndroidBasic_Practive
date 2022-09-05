package vn.minhgiang.SharedPrerencesAndorid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import vn.minhgiang.SharedPrerencesAndorid.Model.User;
import vn.minhgiang.SharedPrerencesAndorid.SharePreferencesObject.DataLocalManga;
import vn.minhgiang.list.R;
public class MyaSharedPrerences2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mya_shared_prerences2);
//        TextView textView0 = findViewById(R.id.text_Share_1);
//        TextView textView1 = findViewById(R.id.text_Share_2);
//        TextView textView2 = findViewById(R.id.text_Share_3);
//        Set<String> dulieu=DataLocalManager.getnameInstalled();
//        List<String> list = new ArrayList<String>(dulieu);
//        textView0.setText(list.get(1));
//        textView1.setText(list.get(0));
//        textView2.setText(list.get(2));

        TextView textViewUser = findViewById(R.id.sharedvalueUser);
        User user= DataLocalManga.getUser();
        if (user!=null)
        {
            textViewUser.setText(user.toString());
        }

    }
}