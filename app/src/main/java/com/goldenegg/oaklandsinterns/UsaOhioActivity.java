package com.goldenegg.oaklandsinterns;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.goldenegg.oaklandsinterns.adapters.UsaOhioPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class UsaOhioActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private UsaOhioPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usa_ohio);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager2);

        // Set up the adapter
        pagerAdapter = new UsaOhioPagerAdapter(this);
        viewPager2.setAdapter(pagerAdapter);

        // Link TabLayout with ViewPager2
        new TabLayoutMediator(tabLayout, viewPager2,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        switch (position) {
                            case 0:
                                tab.setText("USA");
                                break;
                            case 1:
                                tab.setText("Ohio");
                                break;
                        }
                    }
                }).attach();

        // Call setupTabIcons AFTER the TabLayoutMediator is attached
        setupTabIcons();
    }

    private void setupTabIcons() {
        // Custom view for USA tab
        View usaTabView = LayoutInflater.from(UsaOhioActivity.this).inflate(R.layout.custom_tab, null);
        ImageView usaIcon = ((View) usaTabView).findViewById(R.id.tab_icon);
        TextView usaText = usaTabView.findViewById(R.id.tab_text);
        usaIcon.setImageResource(R.drawable.usa_flag); // USA flag image
        usaText.setText("USA");
        tabLayout.getTabAt(0).setCustomView(usaTabView); // Apply to first tab

        // Custom view for Ohio tab
        View ohioTabView = LayoutInflater.from(UsaOhioActivity.this).inflate(R.layout.custom_tab, null);
        ImageView ohioIcon = ohioTabView.findViewById(R.id.tab_icon);
        TextView ohioText = ohioTabView.findViewById(R.id.tab_text);
        ohioIcon.setImageResource(R.drawable.ohio_flag); // Ohio flag image
        ohioText.setText("Ohio");
        tabLayout.getTabAt(1).setCustomView(ohioTabView); // Apply to second tab
    }
}