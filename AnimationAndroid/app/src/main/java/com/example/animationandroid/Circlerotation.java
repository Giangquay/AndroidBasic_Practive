package com.example.animationandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;

import de.hdodenhof.circleimageview.CircleImageView;

public class Circlerotation extends AppCompatActivity {
    private CircleImageView mcircleImageView;
    private  Button btnStart,btnStop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circlerotation);
        mcircleImageView=findViewById(R.id.img_animation_avatar);
        btnStart=findViewById(R.id.btn_Start_Animation);
        btnStop=findViewById(R.id.btn_Stop_Animation);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animtionStart();
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationStop();
            }
        });
    }

    private void animationStop() {
        mcircleImageView.animate().cancel();
    }

    private void animtionStart() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                mcircleImageView.animate().rotationBy(360).withEndAction(this).setDuration(10000)
                        .setInterpolator(new LinearInterpolator()).start();
            }
        } ;
        mcircleImageView.animate().rotation(360).withEndAction(runnable).setDuration(10000)
                .setInterpolator(new LinearInterpolator()).start();
    }
}