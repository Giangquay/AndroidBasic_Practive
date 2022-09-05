package com.example.myapplication.NavigationView.NavigaViewDrawer.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.NavigationView.NavigaViewDrawer.Adapter.Viewpager2Adapter;
import com.example.myapplication.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class NaviDrawerActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private ViewPager2 viewPager2 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navi_drawer);
        bottomNavigationView=findViewById(R.id.bottomNavigation);
        viewPager2=findViewById(R.id.view_pager);
        Viewpager2Adapter viewpager2Adapter = new Viewpager2Adapter(this);
        viewPager2.setAdapter(viewpager2Adapter);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.navigation_shop:
                        viewPager2.setCurrentItem(0);
                        break;
                    case R.id.navigation_gifts:
                        viewPager2.setCurrentItem(1);
                        break;
                    case R.id.navigation_cart:
                        viewPager2.setCurrentItem(2);
                        break;
                    case R.id.navigation_delivery:
                        viewPager2.setCurrentItem(3);
                        break;
                    case R.id.navigation_profile:
                        viewPager2.setCurrentItem(4);
                        break;


                }
                return true;
            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position)
                {
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.navigation_shop).setChecked(true);
                        break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.navigation_gifts).setChecked(true);
                        break;
                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.navigation_cart).setChecked(true);
                        break;
                    case 3:
                        bottomNavigationView.getMenu().findItem(R.id.navigation_delivery).setChecked(true);
                        break;
                    case 4:
                        bottomNavigationView.getMenu().findItem(R.id.navigation_profile).setChecked(true);
                }
            }
        });
    }


}