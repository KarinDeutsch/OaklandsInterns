package com.goldenegg.oaklandsinterns.basics;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.goldenegg.oaklandsinterns.BasicsActivity;
import com.goldenegg.oaklandsinterns.MainActivity;
import com.goldenegg.oaklandsinterns.R;

public class ShoppingTipsActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnSalesTaxInfographic, btnPaymentMethodInfographic, btnBagsInfographic, btnAlcoholInfographic, btnChainsInfographic, btnCouponsInfographic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_tips);

        ImageView imageView = findViewById(R.id.oakland_logo);
        btnSalesTaxInfographic = findViewById(R.id.btnSalesTaxInfographic);
        btnPaymentMethodInfographic = findViewById(R.id.btnPaymentMethodInfographic);
        btnBagsInfographic = findViewById(R.id.btnBagsInfographic);
        btnAlcoholInfographic = findViewById(R.id.btnAlcoholInfographic);
        btnChainsInfographic = findViewById(R.id.btnChainsInfographic);
        btnCouponsInfographic = findViewById(R.id.btnCouponsInfographic);


        // Set button listeners
        btnSalesTaxInfographic.setOnClickListener(this);
        btnPaymentMethodInfographic.setOnClickListener(this);
        btnBagsInfographic.setOnClickListener(this);
        btnAlcoholInfographic.setOnClickListener(this);
        btnChainsInfographic.setOnClickListener(this);
        btnCouponsInfographic.setOnClickListener(this);


        // Logo button – go to MainActivity
        ImageView imageViewLogo = findViewById(R.id.oakland_logo);
        imageViewLogo.setOnClickListener(v ->
                startActivity(new Intent(ShoppingTipsActivity.this, MainActivity.class))
        );

        // Back button – go to BasicsActivity
        ImageView imageViewBack = findViewById(R.id.btnBack);
        imageViewBack.setOnClickListener(v ->
                startActivity(new Intent(ShoppingTipsActivity.this, BasicsActivity.class))
        );
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSalesTaxInfographic) {
            // TODO: Open robocalls infographic PDF
            /*
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(Uri.parse("file:///android_asset/robocalls_infographic.pdf"), "application/pdf");
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(intent);
            */
        } else if (v.getId() == R.id.btnPaymentMethodInfographic) {
            // TODO: Open SIM infographic PDF
            /*
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(Uri.parse("file:///android_asset/sim_infographic.pdf"), "application/pdf");
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(intent);
            */
        } else if (v.getId() == R.id.btnBagsInfographic) {
            // TODO: Open carrier infographic PDF
            /*
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(Uri.parse("file:///android_asset/carrier_infographic.pdf"), "application/pdf");
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(intent);
            */
        }  else if (v.getId() == R.id.btnChainsInfographic) {
            // TODO: Open SIM infographic PDF
            /*
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(Uri.parse("file:///android_asset/sim_infographic.pdf"), "application/pdf");
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(intent);
            */
        } else if (v.getId() == R.id.btnAlcoholInfographic) {
            // TODO: Open SIM infographic PDF
            /*
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(Uri.parse("file:///android_asset/sim_infographic.pdf"), "application/pdf");
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(intent);
            */
        } else if (v.getId() == R.id.btnCouponsInfographic) {
            // TODO: Open SIM infographic PDF
            /*
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(Uri.parse("file:///android_asset/sim_infographic.pdf"), "application/pdf");
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(intent);
            */
        }
    }
}