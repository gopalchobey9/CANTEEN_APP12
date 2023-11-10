package com.example.canteen_app12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class orderPage extends AppCompatActivity {
    LinearLayout orderfood;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);
        orderfood = findViewById(R.id.orderfood);
    orderfood.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(orderPage.this,tablesPage.class);
            startActivity(intent);


        }
    });

    }
}