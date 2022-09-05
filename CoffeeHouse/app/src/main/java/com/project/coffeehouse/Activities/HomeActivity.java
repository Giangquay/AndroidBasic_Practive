package com.project.coffeehouse.Activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;
import com.project.coffeehouse.DAO.NhanVienDAO;
import com.project.coffeehouse.DTO.ThanhToanDTO;
import com.project.coffeehouse.Fragments.DisplayCategoryFragment;
import com.project.coffeehouse.Fragments.DisplayHomeFragment;
import com.project.coffeehouse.Fragments.DisplayInformationFragment;
import com.project.coffeehouse.Fragments.DisplayMenuFragment;
import com.project.coffeehouse.Fragments.DisplayStaffFragment;
import com.project.coffeehouse.Fragments.DisplayStatisticFragment;
import com.project.coffeehouse.Fragments.DisplayTableFragment;
import com.project.coffeehouse.R;

import java.util.List;


public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    MenuItem selectedFeature, selectedManager;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    FragmentManager fragmentManager;
    TextView TXT_menu_tennv, TXT_menu_hotennv;
    int maquyen = 0, manv;
    SharedPreferences sharedPreferences;
    BottomNavigationView bot_nav;
    List<ThanhToanDTO> thanhToanDTOList;
    NhanVienDAO nhanVienDAO;
    SpaceNavigationView spaceNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);

        //region thuộc tính bên view
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        navigationView = (NavigationView)findViewById(R.id.navigation_view_trangchu);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        View view = navigationView.getHeaderView(0);
        TXT_menu_tennv = (TextView) view.findViewById(R.id.txt_menu_tennv);
        //endregion

        //hiện thị fragment home mặc định
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction tranDisplayHome = fragmentManager.beginTransaction();
        DisplayTableFragment displayHomeFragment = new DisplayTableFragment();
        tranDisplayHome.replace(R.id.contentView, displayHomeFragment);
        tranDisplayHome.commit();

        //Khởi tạo và thiết lập bottom navigation
        spaceNavigationView = (SpaceNavigationView) findViewById(R.id.space);
        spaceNavigationView.initWithSaveInstanceState(savedInstanceState);

        setBottomNav();
        spaceNavigationView.changeCurrentItem(-1);


        //xử lý toolbar và navigation
        setSupportActionBar(toolbar); //tạo toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //tạo nút mở navigation
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar
        ,R.string.opentoggle,R.string.closetoggle){
            @Override
            public void onDrawerOpened(View drawerView) {    super.onDrawerOpened(drawerView); }

            @Override
            public void onDrawerClosed(View drawerView) {    super.onDrawerClosed(drawerView); }
        };
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


        //lấy file share prefer
        sharedPreferences = getSharedPreferences("luuquyen", Context.MODE_PRIVATE);
        maquyen = sharedPreferences.getInt("maquyen",0);

//        //hiện thị fragment home mặc định
//        fragmentManager = getSupportFragmentManager();
//        FragmentTransaction tranDisplayHome = fragmentManager.beginTransaction();
//        DisplayHomeFragment displayHomeFragment = new DisplayHomeFragment();
//        tranDisplayHome.replace(R.id.contentView, displayHomeFragment);
//        tranDisplayHome.commit();
//        navigationView.setCheckedItem(R.id.nav_home);



    }
    //Hàm thiết lập bottom navigation
    public void setBottomNav(){
        spaceNavigationView.addSpaceItem(new SpaceItem("Thực đơn", R.drawable.ic_menu));
        spaceNavigationView.addSpaceItem(new SpaceItem("Thống kê", R.drawable.ic_baseline_event_24));
        spaceNavigationView.addSpaceItem(new SpaceItem("Quản lý", R.drawable.user_cog_solid));
        spaceNavigationView.addSpaceItem(new SpaceItem("Thông tin", R.drawable.ic_baseline_person_24));
        spaceNavigationView.setSpaceBackgroundColor(ContextCompat.getColor(this, R.color.grown));
        spaceNavigationView.setCentreButtonIcon(R.drawable.ic_baseline_restaurant_menu_24);
        spaceNavigationView.setActiveSpaceItemColor(ContextCompat.getColor(this, R.color.teal_200));
        spaceNavigationView.setCentreButtonColor(ContextCompat.getColor(this, R.color.teal_700));
        spaceNavigationView.showIconOnly();

        spaceNavigationView.setSpaceOnClickListener(new SpaceOnClickListener() {
            @Override
            public void onCentreButtonClick() {
                spaceNavigationView.changeCurrentItem(-1);
                spaceNavigationView.setCentreButtonColor(ContextCompat.getColor(HomeActivity.this, R.color.teal_200));

                fragmentManager = getSupportFragmentManager();
                FragmentTransaction tranDisplayHome = fragmentManager.beginTransaction();
                DisplayTableFragment displayHomeFragment = new DisplayTableFragment();

                tranDisplayHome.replace(R.id.contentView,displayHomeFragment);
                tranDisplayHome.commit();
            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {
                spaceNavigationView.setCentreButtonColor(ContextCompat.getColor(HomeActivity.this, R.color.teal_700));
                Toast.makeText(HomeActivity.this,  itemName, Toast.LENGTH_SHORT).show();
                switch (itemIndex){
                    case 0:             // Menu
                        fragmentManager = getSupportFragmentManager();
                        FragmentTransaction tranDisplayMenu = fragmentManager.beginTransaction();
                        DisplayCategoryFragment displayMenuFragment = new DisplayCategoryFragment();

                        tranDisplayMenu.replace(R.id.contentView,displayMenuFragment);
                        tranDisplayMenu.commit();
                        break;
                    case 1:             // Thống kê
                        fragmentManager = getSupportFragmentManager();
                        FragmentTransaction tranDisplayReport = fragmentManager.beginTransaction();
                        DisplayStatisticFragment displayReportFragment = new DisplayStatisticFragment();

                        tranDisplayReport.replace(R.id.contentView,displayReportFragment);
                        tranDisplayReport.commit();
                        break;
                    case 2:             //Quản lý
                        if(maquyen == 1){
                        fragmentManager = getSupportFragmentManager();
                        FragmentTransaction tranDisplayManager = fragmentManager.beginTransaction();
                        DisplayStaffFragment displayManagerFragment = new DisplayStaffFragment();

                        tranDisplayManager.replace(R.id.contentView,displayManagerFragment);
                        tranDisplayManager.commit();
                        }else {
                            Toast.makeText(getApplicationContext(),"Bạn không có quyền truy cập",Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 3:             //Thông tin
                        fragmentManager = getSupportFragmentManager();
                        FragmentTransaction tranDisplayUserInfo = fragmentManager.beginTransaction();
                        DisplayInformationFragment displayUserInfoFragment = new DisplayInformationFragment();

                        tranDisplayUserInfo.replace(R.id.contentView,displayUserInfoFragment);
                        tranDisplayUserInfo.commit();
                        break;
                }
            }

            @Override
            public void onItemReselected(int itemIndex, String itemName) {
                Toast.makeText(HomeActivity.this, itemIndex + " " + itemName, Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        spaceNavigationView.onSaveInstanceState(outState);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        return false;
    }

}