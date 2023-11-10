package com.example.canteen_app12;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class menuPage extends AppCompatActivity {
private  int quantity=0;
    FirebaseDatabase firebaseDatabase;

    // creating a variable for our Database
    // Reference for Firebase.
    DatabaseReference databaseReference;
    private List<FooditemModel> selectedFoodItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_page);
        firebaseDatabase = FirebaseDatabase.getInstance();
        // Find the plus and minus buttons
        Button plusButton1 = findViewById(R.id.plus_button1);
        Button minusButton1 = findViewById(R.id.minus_button1);

// Find the quantity TextView
        TextView quantityTextView = findViewById(R.id.quantity_text1);

// Initialize the quantity value
        quantity = 0;

// Set OnClickListener for plus button
        plusButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Increment the quantity value
                quantity++;

                // Update the quantity TextView
                quantityTextView.setText(String.valueOf(quantity));
            }
        });

// Set OnClickListener for minus button
        minusButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity > 0) {
                    // Decrement the quantity value
                    quantity--;

                    // Update the quantity TextView
                    quantityTextView.setText(String.valueOf(quantity));
                }
            }
        });

        /////////////// pluus buttons
        Button plusButton2 = findViewById(R.id.plus_button1);
        Button minusButton2 = findViewById(R.id.minus_button1);

// Find the quantity TextView
        TextView quantity2 = findViewById(R.id.quantity_text1);

// Initialize the quantity value
        quantity = 0;

// Set OnClickListener for plus button
        plusButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Increment the quantity value
                quantity++;

                // Update the quantity TextView
                quantity2.setText(String.valueOf(quantity));
            }
        });

// Set OnClickListener for minus button
        minusButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity > 0) {
                    // Decrement the quantity value
                    quantity--;

                    // Update the quantity TextView
                    quantity2.setText(String.valueOf(quantity));
                }
            }
        });
        ////// plus button 3
        Button plusButton3 = findViewById(R.id.plus_button1);
        Button minusButton3 = findViewById(R.id.minus_button1);

// Find the quantity TextView
        TextView quantity3 = findViewById(R.id.quantity_text1);

// Initialize the quantity value
        quantity = 0;

// Set OnClickListener for plus button
        plusButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Increment the quantity value
                quantity++;

                // Update the quantity TextView
                quantity3.setText(String.valueOf(quantity));
            }
        });

// Set OnClickListener for minus button
        minusButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity > 0) {
                    // Decrement the quantity value
                    quantity--;

                    // Update the quantity TextView
                    quantity3.setText(String.valueOf(quantity));
                }
            }
        });



        // Example code to add a selected food item
        FooditemModel foodItem = new FooditemModel();
        foodItem.setName("Food Item 1");
        foodItem.setQuantity(0); // Get the quantity from the TextView
        foodItem.setDescription("Description of Food Item 1");
//        if(selectedFoodItems.isEmpty())
//        selectedFoodItems.clear();
        selectedFoodItems.add(foodItem);
        // Get a reference to the Firebase database

// Find the order button
        Button orderButton = findViewById(R.id.order_button);
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform Firebase data upload
               FirebaseDatabase.getInstance().getReference().child("order").child("Table 1").push().setValue(selectedFoodItems).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                // Data successfully saved to Firebase
                                Toast.makeText(menuPage.this, "Order placed successfully!", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                // Error occurred while saving data to Firebase
                                Toast.makeText(menuPage.this, "Failed to place order.", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });














    }
}