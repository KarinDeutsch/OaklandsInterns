package com.goldenegg.oaklandsinterns.basics;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.goldenegg.oaklandsinterns.MainActivity;
import com.goldenegg.oaklandsinterns.NurseriesActivity;
import com.goldenegg.oaklandsinterns.R;

public class LawsRulesActivity extends AppCompatActivity implements View.OnClickListener{
    ImageButton btnUSLaw, btnOhioLaw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laws);

        // Initialize ImageView (Oakland logo)
        ImageView imageView = findViewById(R.id.oakland_logo);
        imageView.setOnClickListener(v -> startActivity(new Intent(LawsRulesActivity.this, MainActivity.class)));

        btnUSLaw = findViewById(R.id.btnUSLaw);
        btnOhioLaw = findViewById(R.id.btnOhioLaw);

        btnUSLaw.setOnClickListener(this);
        btnOhioLaw.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        if (v.getId() == R.id.btnUSLaw) {
            intent = new Intent(LawsRulesActivity.this, BasicLawsActivity.class);
            startActivity(intent);
            Toast.makeText(LawsRulesActivity.this, "US Laws opening", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.btnOhioLaw) {
            intent = new Intent (LawsRulesActivity.this, BasicLawsOhio.class);
            startActivity(intent);
            Toast.makeText(LawsRulesActivity.this, "Ohio Laws opening", Toast.LENGTH_SHORT).show();
        }
    }

}