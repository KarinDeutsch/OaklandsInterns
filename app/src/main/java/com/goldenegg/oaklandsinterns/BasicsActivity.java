package com.goldenegg.oaklandsinterns;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.goldenegg.oaklandsinterns.basics.ConversionsActivity;
import com.goldenegg.oaklandsinterns.basics.CustomsTipsActivity;
import com.goldenegg.oaklandsinterns.basics.EatingTipsActivity;
import com.goldenegg.oaklandsinterns.basics.HouseTipsActivity;
import com.goldenegg.oaklandsinterns.basics.LawsRulesActivity;
import com.goldenegg.oaklandsinterns.basics.PhoneActivity;
import com.goldenegg.oaklandsinterns.basics.ShoppingTipsActivity;
import com.goldenegg.oaklandsinterns.basics.TippingActivity;
import com.goldenegg.oaklandsinterns.basics.TransportTipsActivity;
import com.goldenegg.oaklandsinterns.basics.WeatherActivity;

public class BasicsActivity  extends AppCompatActivity implements View.OnClickListener {
    ImageButton btnHouse, btnTips, btnTransport, btnPhone, btnEating, btnCustoms, btnLaws, btnWeather, btnConversions, btnShopping;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basics);

        /*
App Progress Overview:
===============================
- House: ⛔ Not started yet
- Tips: ✅ Done
- Transport: 🟡  Videos and infographics missing, rest done
- Phone: 🟡  infographics missing, rest done
- Eating: ⛔ Not started yet
- Customs: 🟡  Images missing, rest done
- shopping: 🟡  infographics missing, rest done
- Laws:  ✅ Done (ohio incl back button)
- Weather: ⛔ Not started yet
- Conversions: ⛔ Not started yet
*/


        // Initialize ImageView (Oakland logo)
        ImageView imageView = findViewById(R.id.oakland_logo);
        imageView.setOnClickListener(v -> startActivity(new Intent(BasicsActivity.this, MainActivity.class)));

        btnHouse = findViewById(R.id.btnHouse);
        btnTips = findViewById(R.id.btnTips);
        btnTransport = findViewById(R.id.btnTransport);
        btnPhone = findViewById(R.id.btnPhone);
        btnEating = findViewById(R.id.btnEating);
        btnCustoms = findViewById(R.id.btnCustoms);
        btnLaws = findViewById(R.id.btnLaws);
        btnWeather = findViewById(R.id.btnWeather);
        btnConversions = findViewById(R.id.btnConversions);
        btnShopping = findViewById(R.id.btnShopping);

        btnHouse.setOnClickListener(this);
        btnTips.setOnClickListener(this);
        btnTransport.setOnClickListener(this);
        btnPhone.setOnClickListener(this);
        btnEating.setOnClickListener(this);
        btnCustoms.setOnClickListener(this);
        btnLaws.setOnClickListener(this);
        btnWeather.setOnClickListener(this);
        btnConversions.setOnClickListener(this);
        btnShopping.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        if (v.getId() == R.id.btnHouse) {
            intent = new Intent(BasicsActivity.this, HouseTipsActivity.class);
            startActivity(intent);
            Toast.makeText(BasicsActivity.this, "Opening Household Tips!", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.btnTips) {
            intent = new Intent(BasicsActivity.this, TippingActivity.class);
            startActivity(intent);
            Toast.makeText(BasicsActivity.this, "Opening Tips & Shopping Information!", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.btnTransport) {
            intent = new Intent(BasicsActivity.this, TransportTipsActivity.class);
            startActivity(intent);
            Toast.makeText(BasicsActivity.this, "Opening Transport Tips!", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.btnPhone) {
            intent = new Intent(BasicsActivity.this, PhoneActivity.class);
            startActivity(intent);
            Toast.makeText(BasicsActivity.this, "Opening Phone Tips!", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.btnEating) {
            intent = new Intent(BasicsActivity.this, EatingTipsActivity.class);
            startActivity(intent);
            Toast.makeText(BasicsActivity.this, "Opening Eating Tips!", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.btnCustoms) {
            intent = new Intent(BasicsActivity.this, CustomsTipsActivity.class);
            startActivity(intent);
            Toast.makeText(BasicsActivity.this, "Opening Customs Tips!", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.btnLaws) {
            intent = new Intent(BasicsActivity.this, LawsRulesActivity.class);
            startActivity(intent);
            Toast.makeText(BasicsActivity.this, "Opening Laws & Rules!", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.btnWeather) {
            intent = new Intent(BasicsActivity.this, WeatherActivity.class);
            startActivity(intent);
            Toast.makeText(BasicsActivity.this, "Opening Weather Information!", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.btnConversions) {
            intent = new Intent(BasicsActivity.this, ConversionsActivity.class);
            startActivity(intent);
            Toast.makeText(BasicsActivity.this, "Opening Conversions Information!", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.oakland_logo) {
            intent = new Intent(BasicsActivity.this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(BasicsActivity.this, "Going back to Main Screen", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.btnShopping) {
            intent = new Intent(BasicsActivity.this, ShoppingTipsActivity.class);
            startActivity(intent);
            Toast.makeText(BasicsActivity.this, "Opening Shopping Tips", Toast.LENGTH_SHORT).show();
        }
    }
}