package com.example.myapplication.NavigationView.NavigaViewDrawer.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.myapplication.NavigationView.NavigaViewDrawer.Fragment.CartFragment;
import com.example.myapplication.NavigationView.NavigaViewDrawer.Fragment.DeliveryFragment;
import com.example.myapplication.NavigationView.NavigaViewDrawer.Fragment.GiftFragment;
import com.example.myapplication.NavigationView.NavigaViewDrawer.Fragment.ProfileFragment;
import com.example.myapplication.NavigationView.NavigaViewDrawer.Fragment.ShopFragment;

public class Viewpager2Adapter extends FragmentStateAdapter {


    public Viewpager2Adapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 0:
                return new ShopFragment();
            case 1:
                return new GiftFragment();
            case 2:
                return new CartFragment();
            case 3:
                return new DeliveryFragment();
            case 4:
                return new ProfileFragment();
            default:
                return new ShopFragment();
        }
    }
}
