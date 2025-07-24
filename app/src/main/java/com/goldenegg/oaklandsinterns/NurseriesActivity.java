package com.goldenegg.oaklandsinterns;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.views.MapView;
import org.osmdroid.api.IMapController;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.overlay.Marker;

import java.io.File;

public class NurseriesActivity extends AppCompatActivity {

    private MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nurseries);

        // Initialize ImageView (Oakland logo)
        ImageView imageView = findViewById(R.id.oakland_logo);
        imageView.setOnClickListener(v -> startActivity(new Intent(NurseriesActivity.this, MainActivity.class)));

        // Initialize mapView after setContentView
        mapView = findViewById(R.id.mapview);

        // Initialize OSMdroid with updated cache handling
        Configuration.getInstance().load(getApplicationContext(), getSharedPreferences("osmdroid", MODE_PRIVATE));

        // Set tile source for the map
        mapView.setTileSource(TileSourceFactory.MAPNIK);

        // Set map zoom level and center position
        IMapController mapController = mapView.getController();
        mapView.setMaxZoomLevel(19.0);  // Increased max zoom level for better navigation
        mapController.setZoom(10.0);  // Set an initial zoom level
        mapController.setCenter(new GeoPoint(39.9625, -82.983330));

        // Add markers for each nursery
        addMarker(39.9625, -82.983330, "Columbus Location", "1156 Oakland Park Avenue\nColumbus, OH 43224-3317", "614-268-3511", "columbus");
        addMarker(40.1409, -82.9662, "Delaware Location", "25 Kilbourne Road\nDelaware, OH 43015", "740-369-5454", "delaware");
        addMarker(40.1040, -82.9823, "Dublin Location", "4261 West Dublin-Granville Road\nDublin, OH 43017", "614-874-2400", "dublin");
        addMarker(40.1652, -82.8515, "New Albany Location", "5211 Johnstown Road\nNew Albany, OH 43054", "614-917-1020", "newalbany");

        // Additional map settings
        mapView.setTilesScaledToDpi(true);
    }

    private void addMarker(double latitude, double longitude, String title, String address, String phoneNumber, String nurseryId) {
        Marker marker = new Marker(mapView);
        marker.setPosition(new GeoPoint(latitude, longitude));
        marker.setTitle(title);
        marker.setSnippet("📍 Address: " + address + "\n📞 Phone: " + phoneNumber);

        // Set custom marker icon
        Drawable drawable = getDrawable(R.drawable.marker);
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, 40, 40, false);
            marker.setIcon(new BitmapDrawable(getResources(), scaledBitmap));
        }

        marker.setOnMarkerClickListener((m, mapView) -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(title)
                    .setMessage(address + "\nPhone: " + phoneNumber)
                    .setPositiveButton("Call", (dialog, which) -> {
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse("tel:" + phoneNumber));
                        startActivity(intent);
                    })
                    .setNegativeButton("Close", (dialog, which) -> dialog.dismiss())
                    .setNeutralButton("More Info", (dialog, which) -> {
                        Intent intent = new Intent(NurseriesActivity.this, NurseryDetailsActivity.class);
                        intent.putExtra("nursery_name", title);
                        intent.putExtra("nursery_address", address);
                        intent.putExtra("nursery_phone", phoneNumber);
                        intent.putExtra("nursery_id", nurseryId);
                        startActivity(intent);
                    })
                    .show();
            return true;
        });

        mapView.getOverlays().add(marker);
        mapView.invalidate();
    }
}