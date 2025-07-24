package com.goldenegg.oaklandsinterns;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton btnBasics, btnEmergency, btnFaq, btnGuide, btnLocation, btnNursery, btnPlants, btnUSA, btnChat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
App Progress Overview:
===============================
- Emergency: ✅ Done
- FAQ: ✅ Complete
- Guide: 🟡 In progress (Co: missing shopping data but layout done, transport WIP, Activity & info full missing), DE, NA, DU missing fully
- Nursery: ✅ Done
- Plants: ⛔ Not started yet
- USA: 🟡 Started, needs more content
- Basics: 🟡 started with layout in integration of videos
- Chat: 🟡 Login and register is setup, json from firebase integriert and basic chat setup.
        missing: full working chat w/ DM, group chat and setup database as well as image pick for
        profile
*/


        btnEmergency = findViewById(R.id.btnEmergency);
        btnFaq = findViewById(R.id.btnFAQ);
        btnGuide = findViewById(R.id.btnGuide);
        btnNursery = findViewById(R.id.btnNursery);
        btnPlants = findViewById(R.id.btnPlants);
        btnUSA = findViewById(R.id.btnUSA);
        btnBasics = findViewById(R.id.btnBasics);
        btnChat = findViewById(R.id.btnChat);

        btnEmergency.setOnClickListener(this);
        btnFaq.setOnClickListener(this);
        btnGuide.setOnClickListener(this);
        btnNursery.setOnClickListener(this);
        btnPlants.setOnClickListener(this);
        btnUSA.setOnClickListener(this);
        btnBasics.setOnClickListener(this);
        btnChat.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        if (v.getId() == R.id.btnEmergency) {
            intent = new Intent(MainActivity.this, EmergencyActivity.class);  // Ensure this points to EmergencyActivity
            startActivity(intent);
            Toast.makeText(MainActivity.this, "Opening Emergency Contacts!", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.btnBasics) {
            intent = new Intent(MainActivity.this, BasicsActivity.class);
            startActivity(intent);
            Toast.makeText(MainActivity.this, "Opening Basic Information!", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.btnFAQ) {
            intent = new Intent(MainActivity.this, FaqActivity.class);
            startActivity(intent);
            Toast.makeText(MainActivity.this, "Opening FAQs!", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.btnGuide) {
            intent = new Intent(MainActivity.this, GuideActivity.class);
            startActivity(intent);
            Toast.makeText(MainActivity.this, "Opening Guide!", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.btnNursery) {
            intent = new Intent(MainActivity.this, NurseriesActivity.class);
            startActivity(intent);
            Toast.makeText(MainActivity.this, "Opening Nursery Information!", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.btnPlants) {
            intent = new Intent(MainActivity.this, PlantKnowledgeActivity.class);
            startActivity(intent);
            Toast.makeText(MainActivity.this, "Opening Plant Knowledge!", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.btnUSA) {
            intent = new Intent(MainActivity.this, UsaOhioActivity.class);
            startActivity(intent);
            Toast.makeText(MainActivity.this, "Opening USA & Ohio Information!", Toast.LENGTH_SHORT).show();
        } /*else if (v.getId() == R.id.btnChat) {
            intent = new Intent(MainActivity.this, ChatActivity.class);
            startActivity(intent);
            Toast.makeText(MainActivity.this, "Opening Chat!", Toast.LENGTH_SHORT).show();
           }*/
    }
}

