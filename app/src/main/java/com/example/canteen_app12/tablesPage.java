package com.example.canteen_app12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class tablesPage extends AppCompatActivity {
   LinearLayout t1,t2,t3,t4,t5,t6;

    String T1="";
    TextView tt1,tt2,tt3,tt5,tt4,tt6;
    tableActivity tableActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables_page);
        tableActivity = new tableActivity();
        t1= findViewById(R.id.id_t1);
        t2= findViewById(R.id.id_t2);
        t3= findViewById(R.id.id_t3);
        t4= findViewById(R.id.id_t4);
        t5= findViewById(R.id.id_t5);
        t6= findViewById(R.id.id_t6);
        tt1= findViewById(R.id.table1);
        tt2= findViewById(R.id.table2);
        tt3= findViewById(R.id.table3);
        tt4= findViewById(R.id.table4);
        tt5= findViewById(R.id.table5);
        tt6= findViewById(R.id.table6);
        tt1.setText(tt1.getText().toString());
        tableActivity.setTable(tt1.getContext().toString());


//        tableName.setTablenumber(T1);
        Toast.makeText(this, T1, Toast.LENGTH_SHORT).show();
       //
//        tableName.setTablenumber(T1);
//        tableName.setTablename(T1);

        //

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                T1=tt1.getText().toString();
//                tableName.setTablenumber(T1);
//                tableActivity.setTable(T1);
                Intent intent = new Intent(tablesPage.this,menuPage.class);
                intent.putExtra("tablesnames",T1);
                startActivity(intent);
            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                T1=tt2.getText().toString();
//                tableName.setTablename(T1);
                Intent intent = new Intent(tablesPage.this,ordering.class);
                intent.putExtra("tablesnames",T1);
                startActivity(intent);
            }
        });
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                T1=tt3.getText().toString();
//                tableName.setTablename(T1);
                Intent intent = new Intent(tablesPage.this,ordering.class);
                intent.putExtra("tablesnames",T1);
                startActivity(intent);
            }
        });
        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                T1=tt4.getText().toString();
//                tableName.setTablename(T1);
                Intent intent = new Intent(tablesPage.this,ordering.class);
                intent.putExtra("tablesnames",T1);
                startActivity(intent);
            }
        });
        t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                T1=tt5.getText().toString();
//                tableName.setTablename(T1);
                Intent intent = new Intent(tablesPage.this,ordering.class);
                intent.putExtra("tablesnames",T1);
                startActivity(intent);
            }
        });
        t6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                T1=tt6.getText().toString();
//                tableName.setTablename(T1);
                Intent intent = new Intent(tablesPage.this,ordering.class);
                intent.putExtra("tablesnames",T1);
                startActivity(intent);
            }
        });



    }
}