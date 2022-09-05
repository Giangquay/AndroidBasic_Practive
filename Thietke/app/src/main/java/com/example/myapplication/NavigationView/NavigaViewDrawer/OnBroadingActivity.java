package com.example.myapplication.NavigationView.NavigaViewDrawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.myapplication.NavigationView.NavigaViewDrawer.FragmentOnBroading.ViewPaperAdapterBoarding;
import com.example.myapplication.R;

import me.relex.circleindicator.CircleIndicator;
import me.relex.circleindicator.CircleIndicator2;
import me.relex.circleindicator.CircleIndicator3;

public class OnBroadingActivity extends AppCompatActivity {
    private TextView Skip;
    private ViewPager2 viewPager2;
    private RelativeLayout layoutBottom;
    private CircleIndicator3 circleIndicator;
    private LinearLayout layoutNext;
    private void initLayout()
    {
        Skip = findViewById(R.id.tv_skip);
        viewPager2=findViewById(R.id.view_pager);
        layoutBottom=findViewById(R.id.layout_bottom);
        circleIndicator=findViewById(R.id.circle_indicator);
        layoutNext=findViewById(R.id.layoutNext);
        Skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager2.setCurrentItem(2);
            }
        });
        layoutNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewPager2.getCurrentItem()<2)
                {
                    viewPager2.setCurrentItem(viewPager2.getCurrentItem()+1);
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_broading);
        initLayout();
        ViewPaperAdapterBoarding viewPaper= new ViewPaperAdapterBoarding(this);
        viewPager2.setAdapter(viewPaper);
        circleIndicator.setViewPager(viewPager2);
       viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
           @Override
           public void onPageSelected(int position) {
               super.onPageSelected(position);
               if (position==2)
               {
                   Skip.setVisibility(View.GONE);
                   layoutBottom.setVisibility(View.GONE);
               }else
               {
                   Skip.setVisibility(View.VISIBLE);
                   layoutBottom.setVisibility(View.VISIBLE);
               }
           }
       });
    }
}