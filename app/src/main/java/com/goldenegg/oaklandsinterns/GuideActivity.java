package com.goldenegg.oaklandsinterns;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class GuideActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton btnColumbus, btnDelaware, btnDublin, btnNewAlbany;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        btnColumbus = findViewById(R.id.btnColumbus);
        btnDelaware = findViewById(R.id.btnDelaware);
        btnDublin = findViewById(R.id.btnDublin);
        btnNewAlbany = findViewById(R.id.btnNewAlbany);

        btnColumbus.setOnClickListener(this);
        btnDelaware.setOnClickListener(this);
        btnDublin.setOnClickListener(this);
        btnNewAlbany.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        if (v.getId() == R.id.btnColumbus) {
            intent = new Intent(GuideActivity.this, local_columbus.class);
            startActivity(intent);
            Toast.makeText(GuideActivity.this, "Opening Columbus Guide!", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.btnDelaware) {
            intent = new Intent(GuideActivity.this, local_delaware.class);
            startActivity(intent);
            Toast.makeText(GuideActivity.this, "Opening Delaware Guide!", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.btnDublin) {
            intent = new Intent(GuideActivity.this, local_dublin.class);
            startActivity(intent);
            Toast.makeText(GuideActivity.this, "Opening Dublin Guide!", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.btnNewAlbany) {
            intent = new Intent(GuideActivity.this, local_albany.class);
            startActivity(intent);
            Toast.makeText(GuideActivity.this, "Opening New Albany Guide!", Toast.LENGTH_SHORT).show();
        }
    }
}