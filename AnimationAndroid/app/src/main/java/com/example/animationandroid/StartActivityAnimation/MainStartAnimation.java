package com.example.animationandroid.StartActivityAnimation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.animationandroid.MainActivity;
import com.example.animationandroid.R;

public class MainStartAnimation extends AppCompatActivity implements View.OnClickListener {
    private Button Default;
    private Button LefToRight;
    private Button RightToLeft;
    private Button TopToBottom;
    private Button BottomToTop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_start_animation);
        Default=findViewById(R.id.btnDefault);
        LefToRight=findViewById(R.id.btnLeftToRight);
        RightToLeft=findViewById(R.id.btnRightToLeft);
        TopToBottom=findViewById(R.id.btnTopToBottom);
        BottomToTop=findViewById(R.id.btnBottomToTop);

        Default.setOnClickListener(this);
        LefToRight.setOnClickListener(this);
        RightToLeft.setOnClickListener(this);
        TopToBottom.setOnClickListener(this);
        BottomToTop.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnDefault:
                Intent intent = new Intent(MainStartAnimation.this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.btnLeftToRight:
                Intent intent1 = new Intent(MainStartAnimation.this,MainActivity.class);
                startActivity(intent1);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_our_right);
                break;
            case R.id.btnRightToLeft:
                Intent intent2 = new Intent(MainStartAnimation.this,MainActivity.class);
                startActivity(intent2);
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_left);
                break;
            case R.id.btnTopToBottom:
                Intent intent3 = new Intent(MainStartAnimation.this,MainActivity.class);
                startActivity(intent3);
                overridePendingTransition(R.anim.slide_in_top,R.anim.slide_out_top);
                break;
            case R.id.btnBottomToTop:
                Intent intent4 = new Intent(MainStartAnimation.this,MainActivity.class);
                startActivity(intent4);
                overridePendingTransition(R.anim.slide_in_bottom,R.anim.slide_out_bottom);
                break;
        }
    }
}