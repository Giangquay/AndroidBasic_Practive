package vn.minhgiang.list;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.text2);
        Bundle bundle =getIntent().getExtras();
        Item item = (Item) bundle.get("dulieu");
        textView.setText(item.getmName());

    }
}