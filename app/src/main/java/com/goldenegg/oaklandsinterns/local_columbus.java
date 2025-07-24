package com.goldenegg.oaklandsinterns;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.goldenegg.oaklandsinterns.local.colActivities;
import com.goldenegg.oaklandsinterns.local.colImportant;
import com.goldenegg.oaklandsinterns.local.colShop;
import com.goldenegg.oaklandsinterns.local.colTransport;

public class local_columbus extends AppCompatActivity implements View.OnClickListener {
    ImageButton btnShopping, btnTransport, btnActivities, btnImportant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_columbus);

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
            intent = new Intent(local_columbus.this, colShop.class);
            startActivity(intent);
            Toast.makeText(local_columbus.this, "Opening Columbus Shopping!", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.btnTransport) {
            intent = new Intent(local_columbus.this, colTransport.class);
            startActivity(intent);
            Toast.makeText(local_columbus.this, "Opening Columbus Transportation!", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.btnActivities) {
            intent = new Intent(local_columbus.this, colActivities.class);
            startActivity(intent);
            Toast.makeText(local_columbus.this, "Opening Columbus Activities!", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.btnImportant) {
            intent = new Intent(local_columbus.this, colImportant.class);
            startActivity(intent);
            Toast.makeText(local_columbus.this, "Opening Columbus Important Info!", Toast.LENGTH_SHORT).show();
        }
    }
}
