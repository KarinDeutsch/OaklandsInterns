package com.goldenegg.oaklandsinterns.chat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.goldenegg.oaklandsinterns.MainActivity;
import com.goldenegg.oaklandsinterns.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnNoAcc, btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnNoAcc = findViewById(R.id.btnNoAcc);
        btnLogin = findViewById(R.id.btnLogin);

        btnNoAcc.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        if (v.getId() == R.id.btnNoAcc) {
            intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
            Toast.makeText(LoginActivity.this, "Redirected to Registration Screen", Toast.LENGTH_SHORT).show(); // Added .show()
        } else if (v.getId() == R.id.btnLogin) { // Corrected ID here
            intent = new Intent(LoginActivity.this, com.goldenegg.oaklandsinterns.ChatActivity.class);
            startActivity(intent);
            Toast.makeText(LoginActivity.this, "Login processing", Toast.LENGTH_SHORT).show(); // Added .show()
        }
    }
}