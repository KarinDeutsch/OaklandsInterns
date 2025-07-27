package com.goldenegg.oaklandsinterns.basics;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.goldenegg.oaklandsinterns.BasicsActivity;
import com.goldenegg.oaklandsinterns.MainActivity;
import com.goldenegg.oaklandsinterns.NurseriesActivity;
import com.goldenegg.oaklandsinterns.R;

public class TransportTipsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport_tips);


        // Logo button – go to MainActivity
        ImageView imageViewLogo = findViewById(R.id.oakland_logo);
        imageViewLogo.setOnClickListener(v ->
                startActivity(new Intent(TransportTipsActivity.this, MainActivity.class))
        );

        // Back button – go to BasicsActivity
        ImageView imageViewBack = findViewById(R.id.btnBack);
        imageViewBack.setOnClickListener(v ->
                startActivity(new Intent(TransportTipsActivity.this, BasicsActivity.class))
        );
    }
}