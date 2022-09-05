package com.example.myapplication.NavigationView.NavigaViewDrawer.FragmentOnBroading;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPaperAdapterBoarding extends FragmentStateAdapter {


    public ViewPaperAdapterBoarding(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 0: return new FragmentOnboarding1();
            case 1: return new FragmentOnbroading2();
            case 2: return new FragmentOnbroading3();
            default:
                return new FragmentOnboarding1();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
