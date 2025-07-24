package com.goldenegg.oaklandsinterns;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.goldenegg.oaklandsinterns.local.albActivities;
import com.goldenegg.oaklandsinterns.local.albImportant;
import com.goldenegg.oaklandsinterns.local.albShop;
import com.goldenegg.oaklandsinterns.local.albTransport;

public class local_albany extends AppCompatActivity implements View.OnClickListener {
    ImageButton btnShopping, btnTransport, btnActivities, btnImportant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albany);

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
            intent = new Intent(local_albany.this, albShop.class);
            startActivity(intent);
            Toast.makeText(local_albany.this, "Opening New Albany Shopping!", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.btnTransport) {
            intent = new Intent(local_albany.this, albTransport.class);
            startActivity(intent);
            Toast.makeText(local_albany.this, "Opening New Albany Transportation!", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.btnActivities) {
            intent = new Intent(local_albany.this, albActivities.class);
            startActivity(intent);
            Toast.makeText(local_albany.this, "Opening New Albany Activities!", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.btnImportant) {
            intent = new Intent(local_albany.this, albImportant.class);
            startActivity(intent);
            Toast.makeText(local_albany.this, "Opening New Albany Important Info!", Toast.LENGTH_SHORT).show();
        }
    }
}
