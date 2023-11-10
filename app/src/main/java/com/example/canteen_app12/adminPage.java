package com.example.canteen_app12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class adminPage extends AppCompatActivity {
    LinearLayout orders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);
        orders = findViewById(R.id.idorders);
        orders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(adminPage.this,adminTableView.class);
                startActivity(intent);
            }
        });

    }
}