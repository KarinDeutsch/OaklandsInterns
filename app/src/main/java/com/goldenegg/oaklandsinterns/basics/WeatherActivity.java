package com.goldenegg.oaklandsinterns.basics;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.goldenegg.oaklandsinterns.BasicsActivity;
import com.goldenegg.oaklandsinterns.MainActivity;
import com.goldenegg.oaklandsinterns.R;

public class WeatherActivity extends AppCompatActivity {

        private TextView textViewTitle;
        private TextView textViewIntro;
        private TextView textViewSeasonsTitle;
        private TextView textViewSummer;
        private TextView textViewAutumn;
        private TextView textViewWinter;
        private TextView textViewSpring;
        private TextView textViewKeyPointsTitle;
        private TextView textViewTemperatureRange;
        private TextView textViewPrecipitation;
        private TextView textViewSevereWeather;
        private TextView textViewComparisonTip;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_weather);

            // Initialize ImageView (Oakland logo)
            ImageView imageView = findViewById(R.id.oakland_logo);
            imageView.setOnClickListener(v -> startActivity(new Intent(WeatherActivity.this, MainActivity.class)));

            // Initialize UI elements
            textViewSeasonsTitle = findViewById(R.id.textViewSeasonsTitle);
            textViewSummer = findViewById(R.id.textViewSummer);
            textViewAutumn = findViewById(R.id.textViewAutumn);
            textViewWinter = findViewById(R.id.textViewWinter);
            textViewSpring = findViewById(R.id.textViewSpring);
            textViewKeyPointsTitle = findViewById(R.id.textViewKeyPointsTitle);
            textViewTemperatureRange = findViewById(R.id.textViewTemperatureRange);
            textViewPrecipitation = findViewById(R.id.textViewPrecipitation);
            textViewSevereWeather = findViewById(R.id.textViewSevereWeather);
            textViewComparisonTip = findViewById(R.id.textViewComparisonTip);
        }
    }