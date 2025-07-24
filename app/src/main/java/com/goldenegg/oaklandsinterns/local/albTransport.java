package com.goldenegg.oaklandsinterns.local;

import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.goldenegg.oaklandsinterns.R;

public class albTransport extends AppCompatActivity {
    ImageButton btnColumbus, btnDelaware, btnDublin, btnNewAlbany;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
    }
}