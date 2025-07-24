package com.goldenegg.oaklandsinterns;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.goldenegg.oaklandsinterns.adapters.ImageAdapter;

public class NurseryDetailsActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private ImageAdapter imageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nursery_details);

        // Get data from intent
        String name = getIntent().getStringExtra("nursery_name");
        String address = getIntent().getStringExtra("nursery_address");
        String phone = getIntent().getStringExtra("nursery_phone");
        String locationId = getIntent().getStringExtra("nursery_id");

        // Null safety
        if (name == null) name = "Unknown Name";
        if (address == null) address = "Unknown Address";
        if (phone == null) phone = "Unknown Phone";
        if (locationId == null) locationId = "";

        // Set top basic info views
        TextView nameView = findViewById(R.id.NurseryName);
        TextView addressView = findViewById(R.id.address);
        TextView phoneView = findViewById(R.id.phone);

        nameView.setText(name);
        addressView.setText(address);
        phoneView.setText(phone);

        // ViewPager for images
        viewPager = findViewById(R.id.viewPager);
        imageAdapter = new ImageAdapter(getImages(locationId));
        viewPager.setAdapter(imageAdapter);

        // Back button
        Button backButton = findViewById(R.id.backbtn);
        backButton.setOnClickListener(v -> finish());

        // Extra info TextViews
        TextView heading = findViewById(R.id.info_heading);
        TextView paragraph1 = findViewById(R.id.info_paragraph1);
        TextView paragraph2 = findViewById(R.id.info_paragraph2);

        heading.setText("About This Nursery");

        switch (locationId.toLowerCase()) {
            case "columbus":
                paragraph1.setText("The Columbus nursery is located near downtown.");
                paragraph2.setText("It specializes in native trees, shrubs, and offers garden tours.");
                break;
            case "delaware":
                paragraph1.setText("The Delaware nursery has a large greenhouse.");
                paragraph2.setText("We also host seasonal planting workshops.");
                break;
            case "dublin":
                paragraph1.setText("Dublin is known for ornamental trees and landscaping advice.");
                paragraph2.setText("Customers love our peaceful koi pond and bonsai section.");
                break;
            case "newalbany":
                paragraph1.setText("Our newest location focuses on organic and native plants.");
                paragraph2.setText("We offer community classes and hands-on garden events.");
                break;
            default:
                paragraph1.setText("Visit one of our nurseries for expert plant advice.");
                paragraph2.setText("We offer a wide variety of trees, flowers, and shrubs.");
                break;
        }
    }

    // Return image resource IDs based on location
    private int[] getImages(String locationId) {
        switch (locationId.toLowerCase()) {
            case "columbus":
                return new int[]{
                        R.drawable.columbus1,
                        R.drawable.columbus2,
                        R.drawable.columbus3,
                        R.drawable.columbus4,
                        R.drawable.columbus5,
                        R.drawable.columbus6,
                        R.drawable.columbus7
                };
            case "delaware":
                return new int[]{
                        R.drawable.delaware1,
                        R.drawable.delaware2
                };
            case "newalbany":
                return new int[]{
                        R.drawable.newalbany1,
                        R.drawable.newalbany2
                };
            case "dublin":
                return new int[]{
                        R.drawable.dublin1,
                        R.drawable.dublin2
                };
            default:
                return new int[]{
                        R.drawable.loading
                };
        }
    }
}