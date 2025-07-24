package com.goldenegg.oaklandsinterns.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.goldenegg.oaklandsinterns.fragments.LocalNumbers;
import com.goldenegg.oaklandsinterns.fragments.OfficialNumbers;

public class EmergencyAdapter extends FragmentStateAdapter {

    public EmergencyAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new OfficialNumbers();  // First tab - Official Emergency numbers
            case 1:
                return new LocalNumbers(); // Second tab - location specific numbers
            default:
                return new OfficialNumbers();
        }
    }

    @Override
    public int getItemCount() {
        return 2; // Number of fragments (tabs)
    }
}