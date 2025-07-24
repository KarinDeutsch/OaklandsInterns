package com.goldenegg.oaklandsinterns.basics;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.goldenegg.oaklandsinterns.BasicsActivity;
import com.goldenegg.oaklandsinterns.MainActivity;
import com.goldenegg.oaklandsinterns.NurseriesActivity;
import com.goldenegg.oaklandsinterns.R;

public class HouseTipsActivity extends AppCompatActivity {
    Button btnThermostat, btnGarbage, btnWindows, btnDoors, btnVents, btnAC;
    VideoView videoThermostat, videoGarbage, videoWindows, videoDoors, videoVents, videoAC;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_tips);


        // Initialize ImageView (Oakland logo)
        imageView = findViewById(R.id.oakland_logo);
        imageView.setOnClickListener(v -> startActivity(new Intent(HouseTipsActivity.this, MainActivity.class)));

        // Find all views
        videoThermostat = findViewById(R.id.videoThermostat);
        videoGarbage = findViewById(R.id.videoGarbage);
        videoWindows = findViewById(R.id.videoWindows);
        videoDoors = findViewById(R.id.videoDoors);
        videoVents = findViewById(R.id.videoVents);
        videoAC = findViewById(R.id.videoAC);

        btnThermostat = findViewById(R.id.btnThermostat);
        btnGarbage = findViewById(R.id.btnGarbage);
        btnWindows = findViewById(R.id.btnWindows);
        btnDoors = findViewById(R.id.btnDoors);
        btnVents = findViewById(R.id.btnVents);
        btnAC = findViewById(R.id.btnAC);

        // Set up each video
        //setVideo(videoThermostat, R.raw.video_thermostat);
        //setVideo(videoGarbage, R.raw.video_garbage);
        //setVideo(videoWindows, R.raw.video_windows);
        //setVideo(videoDoors, R.raw.video_doors);
        // setVideo(videoVents, R.raw.videoVents);
        // setVideo(videoAC, R.raw.videoAC);

        // Button actions
        btnThermostat.setOnClickListener(v ->
                Toast.makeText(this, "Thermostat tips coming soon!", Toast.LENGTH_SHORT).show()
        );
        btnGarbage.setOnClickListener(v ->
                Toast.makeText(this, "Garbage disposal tips coming soon!", Toast.LENGTH_SHORT).show()
        );
        btnWindows.setOnClickListener(v ->
                Toast.makeText(this, "Window tips coming soon!", Toast.LENGTH_SHORT).show()
        );
        btnDoors.setOnClickListener(v ->
                Toast.makeText(this, "Door tips coming soon!", Toast.LENGTH_SHORT).show()
        );
        btnVents.setOnClickListener(v ->
                Toast.makeText(this, "Vent tips coming soon!", Toast.LENGTH_SHORT).show()
        );
        btnAC.setOnClickListener(v ->
                Toast.makeText(this, "AC tips coming soon!", Toast.LENGTH_SHORT).show()
        );
    }

    private void setVideo(VideoView view, int rawId) {
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + rawId);
        view.setVideoURI(uri);
        view.setMediaController(new MediaController(this));
        view.requestFocus();
    }
}