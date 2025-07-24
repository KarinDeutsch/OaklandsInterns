package com.goldenegg.oaklandsinterns.plant_knowledge;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.goldenegg.oaklandsinterns.R;

public class CategoryDetailActivity extends AppCompatActivity {

    public static final String EXTRA_CATEGORY = "extra_category"; // Key for passing data

    private ImageView detailImageViewCategory;
    private TextView detailTextViewTitle;
    private TextView detailTextViewLongDescription;
    private TextView detailTextViewOhioContext;
    private TextView detailTextViewCareTips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_detail);

        // Initialize UI elements
        detailImageViewCategory = findViewById(R.id.detailImageViewCategory);
        detailTextViewTitle = findViewById(R.id.detailTextViewTitle);
        detailTextViewLongDescription = findViewById(R.id.detailTextViewLongDescription);
        detailTextViewOhioContext = findViewById(R.id.detailTextViewOhioContext);
        detailTextViewCareTips = findViewById(R.id.detailTextViewCareTips);

        // Get the PlantCategory object passed from MainActivity
        PlantCategory category = getIntent().getParcelableExtra(EXTRA_CATEGORY);

        if (category != null) {
            // Populate the views with data from the PlantCategory object
            detailImageViewCategory.setImageResource(category.getImageResourceId());
            detailTextViewTitle.setText(category.getTitle());
            detailTextViewLongDescription.setText(category.getLongDescription());
            detailTextViewOhioContext.setText(category.getOhioContext());
            detailTextViewCareTips.setText(category.getCareTips());

            // Set activity title to the category title
            setTitle(category.getTitle());
        } else {
            // Handle case where no category data was passed (e.g., show an error or finish activity)
            setTitle("Error");
            detailTextViewTitle.setText("No Category Found");
            detailTextViewLongDescription.setText("Please go back and select a category.");
        }
    }
}