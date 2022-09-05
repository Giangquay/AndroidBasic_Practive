package com.example.animationandroid.ShowAndHideBottomNavigationVie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.example.animationandroid.R;
import com.example.animationandroid.ShowAndHide.TranslateAnimationUtil;

import java.util.ArrayList;
import java.util.List;

public class BottomNavigationView extends AppCompatActivity {
    private RecyclerView recyclerView;
    private UserAdapter mUserAdapter;
    private AHBottomNavigation mAhBottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation_view);
        recyclerView=findViewById(R.id.RecyleAnimaion);
        mAhBottomNavigation=findViewById(R.id.bottom_navigation);
        mUserAdapter= new UserAdapter();
        AHBottomNavigationItem item1 = new AHBottomNavigationItem(R.string.tab_1, R.drawable.home, R.color.color_tab_1);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem(R.string.tab_2, R.drawable.heart, R.color.color_tab_2);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem(R.string.tab_3, R.drawable.user, R.color.color_tab_3);

        LinearLayoutManager mlinLinearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mlinLinearLayoutManager);
// Add items
        mAhBottomNavigation.addItem(item1);
        mAhBottomNavigation.addItem(item2);
        mAhBottomNavigation.addItem(item3);

        // dat mau net cho bottomNavigation
        mAhBottomNavigation.setColored(true);

        mUserAdapter.setData(GetListUser());
        recyclerView.setAdapter(mUserAdapter);

        RecyclerView.ItemDecoration mItemDecoration= new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(mItemDecoration);

        recyclerView.setOnTouchListener(new TranslateAnimationUtil(this,mAhBottomNavigation));
    }

    private List<String> GetListUser() {
        List<String> list = new ArrayList<>();
        for (int i=0;i<20;i++){
            list.add("User name "+i);
        }
        return  list;
    }
}