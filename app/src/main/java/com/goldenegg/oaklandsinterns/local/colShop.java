package com.goldenegg.oaklandsinterns.local;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.goldenegg.oaklandsinterns.FaqActivity;
import com.goldenegg.oaklandsinterns.MainActivity;
import com.goldenegg.oaklandsinterns.NurseriesActivity;
import com.goldenegg.oaklandsinterns.R;
import com.goldenegg.oaklandsinterns.adapters.ShoppingAdapter;
import com.goldenegg.oaklandsinterns.models.ShoppingPlace;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class colShop extends AppCompatActivity {
    private MapView mapView;
    private RecyclerView recyclerView;
    private Spinner filterSpinner;
    private ShoppingAdapter shoppingAdapter;
    private List<ShoppingPlace> shoppingPlaces = new ArrayList<>();
    private double columbusLat = 39.9625;
    private double columbusLon = -82.983330;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Fix for osmdroid: set proper user agent
        Configuration.getInstance().setUserAgentValue(getPackageName());

        setContentView(R.layout.activity_shopping);

        // Initialize ImageView (Oakland logo)
        ImageView imageView = findViewById(R.id.oakland_logo);
        imageView.setOnClickListener(v -> startActivity(new Intent(colShop.this, MainActivity.class)));

        mapView = findViewById(R.id.mapview);
        recyclerView = findViewById(R.id.shoppingRecyclerView);
        filterSpinner = findViewById(R.id.filterSpinner);

        // Setup map
        mapView.setTileSource(TileSourceFactory.MAPNIK);
        mapView.setMultiTouchControls(true);
        mapView.setMaxZoomLevel(19.0);
        IMapController mapController = mapView.getController();
        mapController.setZoom(10.0);
        mapController.setCenter(new GeoPoint(columbusLat, columbusLon));

        // Sample data
        shoppingPlaces.add(new ShoppingPlace("Grocery Store", "123 Elm Street", "(555) 123-4567", "www.grocerystore.com", "Grocery", 39.9612, -82.9988));
        shoppingPlaces.add(new ShoppingPlace("Mall", "456 Oak Avenue", "(555) 234-5678", "www.mall.com", "Mall", 39.9700, -82.9985));
        shoppingPlaces.add(new ShoppingPlace("Electronics Store", "789 Pine Road", "(555) 345-6789", "www.electronicsstore.com", "Electronics", 39.9600, -82.9975));
        shoppingPlaces.add(new ShoppingPlace("Clothing Store", "101 Maple Street", "(555) 456-7890", "www.clothingstore.com", "Clothing", 39.9625, -82.9960));
        shoppingPlaces.add(new ShoppingPlace("Hardware Store", "202 Birch Drive", "(555) 567-8901", "www.hardwarestore.com", "Hardware", 39.9630, -82.9950));
        shoppingPlaces.add(new ShoppingPlace("Pharmacy", "303 Cedar Lane", "(555) 678-9012", "www.pharmacy.com", "Pharmacy", 39.9615, -82.9940));

        // Setup RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        shoppingAdapter = new ShoppingAdapter(shoppingPlaces, columbusLat, columbusLon);
        recyclerView.setAdapter(shoppingAdapter);

        // Spinner setup
        Set<String> categories = new HashSet<>();
        categories.add("All");
        for (ShoppingPlace place : shoppingPlaces) {
            categories.add(place.getCategory().toLowerCase());
        }
        List<String> categoryList = new ArrayList<>(categories);
        Collections.sort(categoryList);

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categoryList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        filterSpinner.setAdapter(spinnerAdapter);

        // Initial marker display
        addMarkersToMap("all");

        filterSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedCategory = parent.getItemAtPosition(position).toString().toLowerCase();
                filterListByCategory(selectedCategory);
                addMarkersToMap(selectedCategory);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                filterListByCategory("all");
                addMarkersToMap("all");
            }
        });
    }

    private void filterListByCategory(String category) {
        List<ShoppingPlace> filteredList = new ArrayList<>();
        if (category.equals("all")) {
            filteredList.addAll(shoppingPlaces);
        } else {
            for (ShoppingPlace place : shoppingPlaces) {
                if (place.getCategory().toLowerCase().equals(category)) {
                    filteredList.add(place);
                }
            }
        }
        shoppingAdapter.updateList(filteredList);
    }

    private void addMarkersToMap(String categoryFilter) {
        mapView.getOverlays().clear();

        for (ShoppingPlace place : shoppingPlaces) {
            String placeCategory = place.getCategory().toLowerCase();
            if (!categoryFilter.equals("all") && !placeCategory.equals(categoryFilter)) {
                continue;
            }

            Marker marker = new Marker(mapView);
            marker.setPosition(new GeoPoint(place.getLat(), place.getLon()));
            marker.setTitle(place.getName());

            // Optional: use custom icon only if found
            int iconResId = 0;
            switch (placeCategory) {
                case "grocery":
                    iconResId = R.drawable.grocery_marker;
                    break;
                case "pharmacy":
                    iconResId = R.drawable.pharmacy_marker;
                    break;
                case "mall":
                case "electronics":
                    iconResId = R.drawable.electronics_marker;
                    break;
                case "clothing":
                    iconResId = R.drawable.clothes_marker;
                    break;
                case "hardware":
                    iconResId = R.drawable.marker;
                    break;
            }

            if (iconResId != 0) {
                Drawable iconDrawable = ContextCompat.getDrawable(this, iconResId);
                if (iconDrawable instanceof BitmapDrawable) {
                    Bitmap originalBitmap = ((BitmapDrawable) iconDrawable).getBitmap();
                    Bitmap scaledBitmap = Bitmap.createScaledBitmap(originalBitmap, 40, 40, false);
                    marker.setIcon(new BitmapDrawable(getResources(), scaledBitmap));
                }
            }

            mapView.getOverlays().add(marker);
            animateMarker(marker);
        }

        mapView.invalidate();
    }

    private void animateMarker(Marker marker) {
        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setDuration(500);
        fadeIn.setFillAfter(true);
        marker.setAlpha(0f); // Start transparent
        marker.setAlpha(1f); // Fade to full
    }
}