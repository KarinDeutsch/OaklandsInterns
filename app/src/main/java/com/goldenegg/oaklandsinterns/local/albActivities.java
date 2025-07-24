package com.goldenegg.oaklandsinterns.local;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.goldenegg.oaklandsinterns.R;

public class albActivities extends AppCompatActivity {
    ImageButton btnColumbus, btnDelaware, btnDublin, btnNewAlbany;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
    }
}