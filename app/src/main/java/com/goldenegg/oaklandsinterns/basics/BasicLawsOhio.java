package com.goldenegg.oaklandsinterns.basics;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.goldenegg.oaklandsinterns.BasicsActivity;
import com.goldenegg.oaklandsinterns.EmergencyActivity;
import com.goldenegg.oaklandsinterns.MainActivity;
import com.goldenegg.oaklandsinterns.R;

public class BasicLawsOhio extends AppCompatActivity implements View.OnClickListener {
    ImageView logo;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_law_ohio);

        ImageView logo = findViewById(R.id.oakland_logo);
        Button btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(this);
        logo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        if (v.getId() == R.id.btnBack) {
            intent = new Intent(BasicLawsOhio.this, BasicsActivity.class);  // Ensure this points to EmergencyActivity
            startActivity(intent);
            Toast.makeText(BasicLawsOhio.this, "Going back to Main Menu", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.oakland_logo) {
            intent = new Intent(BasicLawsOhio.this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(BasicLawsOhio.this, "Going back to Basics!", Toast.LENGTH_SHORT).show();
        }
    }
}
