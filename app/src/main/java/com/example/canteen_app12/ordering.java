package com.example.canteen_app12;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Objects;

public class ordering extends AppCompatActivity {
    private EditText employeeNameEdt, employeePhoneEdt, employeeAddressEdt;
    private Button sendDatabtn;

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
        setContentView(R.layout.activity_ordering);
        employeeNameEdt = findViewById(R.id.idfood);
        employeePhoneEdt = findViewById(R.id.idquantity);


        // below line is used to get the
        // instance of our FIrebase database.
        firebaseDatabase = FirebaseDatabase.getInstance();

        // below line is used to get reference for our database.
        databaseReference = firebaseDatabase.getReference("orderd_details");

        // initializing our object
        // class variable.
        orderd_details = new orderd_details();

        sendDatabtn = findViewById(R.id.placeorder);
        //access the data name of table
        Bundle bundle=getIntent().getExtras();
        String tt =bundle.getString("tablesnames");

        // adding on click listener for our button.
        sendDatabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // getting text from our edittext fields.
                String name = employeeNameEdt.getText().toString();
                String phone = employeePhoneEdt.getText().toString();

                HashMap<String, Object> m = new HashMap<String,Object>();
                m.put("quantity",phone);

                m.put("foodname",name);
//                String s= tableName.getTablenumber();
                databaseReference.setValue(orderd_details);
//                String s1="T1";
                firebaseDatabase.getInstance().getReference().child("order").child(tt).push().setValue(m);
                Toast.makeText(ordering.this, "ORDER PLACED.", Toast.LENGTH_SHORT).show();

                // below line is for checking whether the
                // edittext fields are empty or not.
//                if (TextUtils.isEmpty(name) && TextUtils.isEmpty(phone) && TextUtils.isEmpty(address)) {
//                    // if the text fields are empty
//                    // then show the below message.
//                    Toast.makeText(ordering.this, "Please add some data.", Toast.LENGTH_SHORT).show();
//                } else {
//                    // else call the method to add
//                    // data to our database.
//                    addDatatoFirebase(name, phone, address);
//                }
            }
        });
    }

    private void addDatatoFirebase(String name, String phone, String address) {
        // below 3 lines of code is used to set
        // data in our object class.
        orderd_details.setFoodName(name);
        orderd_details.setQuantity(phone);
        orderd_details.setTable(address);


        // we are use add value event listener method
        // which is called with database reference.
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // inside the method of on Data change we are setting
                // our object class to our database reference.
                // data base reference will sends data to firebase.
                HashMap<String, Object> m = new HashMap<>();
                m.put("FoodName",orderd_details.getFoodName().toString());
                m.put("FoodName",orderd_details.getTable().toString());
                m.put("FoodName",orderd_details.getQuantity().toString());
//                databaseReference.setValue(orderd_details);
                firebaseDatabase.getInstance().getReference().child("orders").push().setValue(m);
                // after adding this data we are showing toast message.
                Toast.makeText(ordering.this, "data added", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // if the data is not added or it is cancelled then
                // we are displaying a failure toast message.
                Toast.makeText(ordering.this, "Fail to add data " + error, Toast.LENGTH_SHORT).show();
            }
        });
    }
}