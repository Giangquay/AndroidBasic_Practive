package com.example.animationandroid.flexbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.animationandroid.R;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayout;

public class flexbox extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flexbox);
        FlexboxLayout flexboxLayout = findViewById(R.id.flexbox_layout);
        flexboxLayout.setFlexDirection(FlexDirection.ROW);
        View view = flexboxLayout.getChildAt(0);
        FlexboxLayout.LayoutParams lp = (FlexboxLayout.LayoutParams) view.getLayoutParams();
        lp.setOrder(-1);
        lp.setFlexGrow(2);
        view.setLayoutParams(lp);
    }
}