package com.goldenegg.oaklandsinterns.basics;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.goldenegg.oaklandsinterns.MainActivity;
import com.goldenegg.oaklandsinterns.R;

public class BasicLawsActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_laws); // MAKE SURE THIS MATCHES YOUR XML FILE NAME

        ImageView imageView = findViewById(R.id.oakland_logo);
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(BasicLawsActivity.this, MainActivity.class));
    }
}
