package com.goldenegg.oaklandsinterns;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.goldenegg.oaklandsinterns.adapters.EmergencyAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class EmergencyActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private EmergencyAdapter pagerAdapter;
    TextView number_911, number_poison, number_crisis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager2);

        number_911 = findViewById(R.id.number_911);
        number_poison = findViewById(R.id.number_poison);
        number_crisis = findViewById(R.id.number_crisis);

        // Set up the adapter
        pagerAdapter = new EmergencyAdapter(this);
        viewPager2.setAdapter(pagerAdapter);

        // Link TabLayout with ViewPager2
        new TabLayoutMediator(tabLayout, viewPager2,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        switch (position) {
                            case 0:
                                tab.setText("Official Numbers");
                                break;
                            case 1:
                                tab.setText("Regional Numbers");
                                break;
                        }
                    }
                }).attach();

        number_911.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:911"));
            startActivity(intent);
        });

        number_poison.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:800-222-222"));
            startActivity(intent);
        });

        number_crisis.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:988"));
            startActivity(intent);
        });

        ImageView imageView = findViewById(R.id.oakland_logo);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EmergencyActivity.this, MainActivity.class));
            }
        });
    }
}