package com.example.canteen_app12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CardView user,admin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = findViewById(R.id.userbtn);
        admin=findViewById(R.id.adminbtn);
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "going to user login page", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, userpage.class);
                startActivity(intent);
//                finish();
            }
        });
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "going to  admin page", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, adminPage.class);
                startActivity(intent);
//                finish();
            }
        });

    }
}