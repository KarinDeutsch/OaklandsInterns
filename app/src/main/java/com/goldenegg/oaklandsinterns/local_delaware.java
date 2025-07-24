package com.goldenegg.oaklandsinterns;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.goldenegg.oaklandsinterns.local.delActivities;
import com.goldenegg.oaklandsinterns.local.delImportant;
import com.goldenegg.oaklandsinterns.local.delShop;
import com.goldenegg.oaklandsinterns.local.delTransport;

public class local_delaware extends AppCompatActivity implements View.OnClickListener {
    ImageButton btnShopping, btnTransport, btnActivities, btnImportant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delaware);

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
            intent = new Intent(local_delaware.this, delShop.class);
            startActivity(intent);
            Toast.makeText(local_delaware.this, "Opening Delaware Shopping!", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.btnTransport) {
            intent = new Intent(local_delaware.this, delTransport.class);
            startActivity(intent);
            Toast.makeText(local_delaware.this, "Opening Delaware Transportation!", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.btnActivities) {
            intent = new Intent(local_delaware.this, delActivities.class);
            startActivity(intent);
            Toast.makeText(local_delaware.this, "Opening Delaware Activities!", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.btnImportant) {
            intent = new Intent(local_delaware.this, delImportant.class);
            startActivity(intent);
            Toast.makeText(local_delaware.this, "Opening Delaware Important Info!", Toast.LENGTH_SHORT).show();
        }
    }
}
