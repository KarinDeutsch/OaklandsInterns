//package com.goldenegg.oaklandsinterns.chat;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.goldenegg.oaklandsinterns.MainActivity;
//import com.goldenegg.oaklandsinterns.R;
//
//public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
//    Button btnRegister, btnRegLogin;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_register);
//
//        btnRegister = findViewById(R.id.btnRegister);
//        btnRegLogin = findViewById(R.id.btnRegLogin);
//
//        btnRegister.setOnClickListener(this);
//        btnRegLogin.setOnClickListener(this);
//    }
//
//    @Override
//    public void onClick(View v) {
//        Intent intent;
//        if (v.getId() == R.id.btnRegister) {
//            intent = new Intent(RegisterActivity.this, MainActivity.class);
//            startActivity(intent);
//            Toast.makeText(RegisterActivity.this, "Registration button clicked", Toast.LENGTH_SHORT).show();
//        } else if (v.getId() == R.id.btnRegLogin) {
//            intent = new Intent(RegisterActivity.this, LoginActivity.class);
//            startActivity(intent);
//            Toast.makeText(RegisterActivity.this, "Login opening", Toast.LENGTH_SHORT).show();
//        }
//    }
//}