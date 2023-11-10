package com.example.canteen_app12;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class adminTableView extends AppCompatActivity {
    LinearLayout t1,t2,t3,t4,t5,t6;

    String T1="";

    TextView tt1,tt2,tt3,tt5,tt4,tt6;
    tableActivity tableActivity;
    // creating a variable for our
    // Firebase Database.
    FirebaseDatabase firebaseDatabase;

    // creating a variable for our Database
    // Reference for Firebase.
    DatabaseReference databaseReference;

    // creating a variable for
    // our object class
    orderd_details orderd_details;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_table_view);
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

        firebaseDatabase = FirebaseDatabase.getInstance();

        // below line is used to get reference for our database.
        databaseReference = firebaseDatabase.getReference("orderd_details");

        // initializing our object
        // class variable.
        orderd_details = new orderd_details();

//        tableName.setTablenumber(T1);
//        Toast.makeText(this, T1, Toast.LENGTH_SHORT).show();
//        Toast.makeText(this,ss+"yes", Toast.LENGTH_SHORT).show()
//
//            editText.setText("unoccupied");
//            editText.setTextColor(Color.rgb(0,200,0));


        //
//        tableName.setTablenumber(T1);
//        tableName.setTablename(T1);

        //

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String str;
            str="";
                TextView editText;
                editText  = findViewById(R.id.id_occupyt1);
                T1=tt1.getText().toString();
                FirebaseDatabase.getInstance().getReference().child("order").child(T1).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        if(snapshot.exists()){

                            editText.setText("occupied");

                        }
                        else {
                            editText.setText("unoccupied");


                            editText.setTextColor(Color.rgb(0,200,0));
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
//                tableName.setTablenumber(T1);
//                tableActivity.setTable(T1);
                Intent intent = new Intent(adminTableView.this,menuPage.class);
                intent.putExtra("tablesnames",T1);
                Toast.makeText(adminTableView.this,str, Toast.LENGTH_SHORT).show();
                intent.putExtra("state",str);
                startActivity(intent);
            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                T1=tt2.getText().toString();
                FirebaseDatabase.getInstance().getReference().child("order").child(T1).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        TextView editText;
                        editText  = findViewById(R.id.id_occupyt2);
                        if(snapshot.getChildrenCount()>0) {
                            //username found
                            editText.setText("occupied");

                        }else{
                            // username not found
                            editText.setText("unccupied");
                            editText.setTextColor(Color.rgb(0,200,0));
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
//                tableName.setTablename(T1);
                Intent intent = new Intent(adminTableView.this,showOrders.class);
                intent.putExtra("tablesnames",T1);
                startActivity(intent);
            }
        });
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                T1=tt3.getText().toString();
                FirebaseDatabase.getInstance().getReference().child("order").child(T1).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        TextView editText;
                        editText  = findViewById(R.id.id_occupyt3);
                        if(snapshot.getChildrenCount()>0) {
                            //username found
                            editText.setText("occupied");

                        }else{
                            // username not found
                            editText.setText("unoccupied");

                            editText.setTextColor(Color.rgb(0,200,0));
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
//                tableName.setTablename(T1);
                Intent intent = new Intent(adminTableView.this,showOrders.class);
                intent.putExtra("tablesnames",T1);
                startActivity(intent);
            }
        });
        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                T1=tt4.getText().toString();
                FirebaseDatabase.getInstance().getReference().child("order").child(T1).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        TextView editText;
                        editText  = findViewById(R.id.id_occupyt4);
                        if(snapshot.exists()){

                            editText.setText("occupied");
                        }
                        else {
                            editText.setText("unoccupied");
                            editText.setTextColor(Color.rgb(0,200,0));
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
//                tableName.setTablename(T1);
                Intent intent = new Intent(adminTableView.this,showOrders.class);
                intent.putExtra("tablesnames",T1);
                startActivity(intent);
            }
        });
        t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                T1=tt5.getText().toString();
                FirebaseDatabase.getInstance().getReference().child("order").child(T1).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        TextView editText;
                        editText  = findViewById(R.id.id_occupyt5);
                        if(snapshot.exists()){

                            editText.setText("occupied");
                        }
                        else {
                            editText.setText("unoccupied");
                            editText.setTextColor(Color.rgb(0,200,0));
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
//                tableName.setTablename(T1);
                Intent intent = new Intent(adminTableView.this,showOrders.class);
                intent.putExtra("tablesnames",T1);
                startActivity(intent);
            }
        });
        t6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                T1=tt6.getText().toString();
                FirebaseDatabase.getInstance().getReference().child("order").child(T1).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        TextView editText;
                        editText  = findViewById(R.id.id_occupyt6);
                        if(snapshot.exists()){

                            editText.setText("occupied");
                        }
                        else {
                            editText.setText("unoccupied");
                            editText.setTextColor(Color.rgb(0,200,0));
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
//                tableName.setTablename(T1);
                Intent intent = new Intent(adminTableView.this,showOrders.class);
                intent.putExtra("tablesnames",T1);
                startActivity(intent);
            }
        });



    }
}