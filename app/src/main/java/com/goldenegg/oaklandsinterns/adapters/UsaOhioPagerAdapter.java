package com.goldenegg.oaklandsinterns.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.goldenegg.oaklandsinterns.fragments.USAFragment;
import com.goldenegg.oaklandsinterns.fragments.OhioFragment;

public class UsaOhioPagerAdapter extends FragmentStateAdapter {

    public UsaOhioPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new USAFragment();  // First tab - USA
            case 1:
                return new OhioFragment(); // Second tab - Ohio
            default:
                return new USAFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2; // Number of fragments (tabs)
    }
}