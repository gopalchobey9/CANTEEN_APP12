package com.example.canteen_app12;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class showOrders extends AppCompatActivity {
            Button showOrder;
            private ListView list;
            tableActivity tableActivity;
            TextView textView;
    Button completebtn;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_orders);
        showOrder = findViewById(R.id.idshoworder);
        list= findViewById(R.id.list);
        tableActivity = new tableActivity();
         completebtn = findViewById(R.id.id_completeOrder);
         textView = findViewById(R.id.id_status);


//        Toast.makeText(this, status, Toast.LENGTH_SHORT).show();
//        textView.setText(status);


//        completebtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            FirebaseDatabase.getInstance().getReference().child("order").child(tt).addListenerForSingleValueEvent(new ValueEventListener() {
//                @Override
//                public void onDataChange(@NonNull DataSnapshot snapshot) {
//                    for (DataSnapshot appleSnapshot: snapshot.getChildren()) {
//                        appleSnapshot.getRef().removeValue();
//                    }
//                }
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError error) {
//
//                }
//            });
//            }
//        });
        completebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle=getIntent().getExtras();
                String tt =bundle.getString("tablesnames");
                FirebaseDatabase.getInstance().getReference().child("order").child(tt).removeValue();
            }
        });

        showOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle=getIntent().getExtras();
                String tt =bundle.getString("tablesnames");
                ArrayList<String> a = new ArrayList<>();
                ArrayAdapter adapter = new ArrayAdapter<String>(showOrders.this,R.layout.items,a);
                list.setAdapter(adapter);
                String s = tableActivity.getTable().toString();
                Toast.makeText(showOrders.this, tt, Toast.LENGTH_SHORT).show();
//                Toast.makeText(showOrders.this, s, Toast.LENGTH_SHORT).show();
                FirebaseDatabase.getInstance().getReference().child("order").child(tt).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            a.clear();
                            for(DataSnapshot snapshot1: snapshot.getChildren()){
                            orderd_details i = snapshot1.getValue(orderd_details.class);
                            String t="Foodname :"+ i.getFoodName()+", Qauntity:"+i.getQuantity();
                            a.add(t);

                            }
                            adapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });
    }
}