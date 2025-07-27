package com.goldenegg.oaklandsinterns.basics;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.goldenegg.oaklandsinterns.BasicsActivity;
import com.goldenegg.oaklandsinterns.FaqActivity;
import com.goldenegg.oaklandsinterns.MainActivity;
import com.goldenegg.oaklandsinterns.NurseriesActivity;
import com.goldenegg.oaklandsinterns.R;

public class PhoneActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnRobocallsInfographic, btnSimInfographic, btnCarrierInfographic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);

        btnRobocallsInfographic = findViewById(R.id.btnRobocallsInfographic);
        btnSimInfographic = findViewById(R.id.btnSimInfographic);
        btnCarrierInfographic = findViewById(R.id.btnCarrierInfographic);


        // Logo button – go to MainActivity
        ImageView imageViewLogo = findViewById(R.id.oakland_logo);
        imageViewLogo.setOnClickListener(v ->
                startActivity(new Intent(PhoneActivity.this, MainActivity.class))
        );

        // Back button – go to BasicsActivity
        ImageView imageViewBack = findViewById(R.id.btnBack);
        imageViewBack.setOnClickListener(v ->
                startActivity(new Intent(PhoneActivity.this, BasicsActivity.class))
        );

        // Set button listeners
        btnRobocallsInfographic.setOnClickListener(this);
        btnSimInfographic.setOnClickListener(this);
        btnCarrierInfographic.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnRobocallsInfographic) {
            // TODO: Open robocalls infographic PDF
            /*
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(Uri.parse("file:///android_asset/robocalls_infographic.pdf"), "application/pdf");
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(intent);
            */
        } else if (v.getId() == R.id.btnSimInfographic) {
            // TODO: Open SIM infographic PDF
            /*
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(Uri.parse("file:///android_asset/sim_infographic.pdf"), "application/pdf");
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(intent);
            */
        } else if (v.getId() == R.id.btnCarrierInfographic) {
            // TODO: Open carrier infographic PDF
            /*
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(Uri.parse("file:///android_asset/carrier_infographic.pdf"), "application/pdf");
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(intent);
            */
        }
    }
}
