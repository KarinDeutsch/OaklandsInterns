package com.goldenegg.oaklandsinterns;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.goldenegg.oaklandsinterns.local.dubActivities;
import com.goldenegg.oaklandsinterns.local.dubImportant;
import com.goldenegg.oaklandsinterns.local.dubShop;
import com.goldenegg.oaklandsinterns.local.dubTransport;

public class local_dublin extends AppCompatActivity implements View.OnClickListener {
    ImageButton btnShopping, btnTransport, btnActivities, btnImportant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dublin);

        btnShopping = findViewById(R.id.btnShopping);
        btnTransport = findViewById(R.id.btnTransport);
        btnActivities = findViewById(R.id.btnActivities);
        btnImportant = findViewById(R.id.btnImportant);

        btnShopping.setOnClickListener(this);
        btnTransport.setOnClickListener(this);
        btnActivities.setOnClickListener(this);
        btnImportant.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        if (v.getId() == R.id.btnShopping) {
            intent = new Intent(local_dublin.this, dubShop.class);
            startActivity(intent);
            Toast.makeText(local_dublin.this, "Opening Dublin Shopping!", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.btnTransport) {
            intent = new Intent(local_dublin.this, dubTransport.class);
            startActivity(intent);
            Toast.makeText(local_dublin.this, "Opening Dublin Transportation!", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.btnActivities) {
            intent = new Intent(local_dublin.this, dubActivities.class);
            startActivity(intent);
            Toast.makeText(local_dublin.this, "Opening Dublin Activities!", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.btnImportant) {
            intent = new Intent(local_dublin.this, dubImportant.class);
            startActivity(intent);
            Toast.makeText(local_dublin.this, "Opening Dublin Important Info!", Toast.LENGTH_SHORT).show();
        }
    }
}