package com.example.canteen_app12;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class loginform extends AppCompatActivity {


    MaterialButton login;
    Button admin;
    TextInputLayout userid, pass;
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginform);

        login = (MaterialButton) findViewById(R.id.loginbtn);
        userid = findViewById(R.id.userId);
        pass = findViewById(R.id.password);
        admin = findViewById(R.id.frgtbtn);
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginform.this, adminLogin.class);
                startActivity(intent);
                finish();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginform.this, userpage.class);
                startActivity(intent);
                finish();
            }
        });


//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//              String user,password;
//              user=String.valueOf(userid.getEditText().getText());
//              password=String.valueOf(pass.getEditText().getText());
//              if(TextUtils.isEmpty(user)){
//                  Toast.makeText(loginform.this, "INVALID USER", Toast.LENGTH_SHORT).show();
//                return;
//              }
//              if(TextUtils.isEmpty(password))
//              {
//                    Toast.makeText(loginform.this, "INVALID password", Toast.LENGTH_SHORT).show();
//                return;
//              }
//              firebaseAuth.signInWithEmailAndPassword(user,password)
//                      .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                          @Override
//                          public void onComplete(@NonNull Task<AuthResult> task) {
//                              if(task.isSuccessful()){
//
//                                  Toast.makeText(loginform.this, "succesful login", Toast.LENGTH_SHORT).show();
//                                Intent intent = new Intent(loginform.this,userpage.class);
//                                startActivity(intent);
//                                finish();
//                              }
//                              else {
//                                  Toast.makeText(loginform.this, "INVALId", Toast.LENGTH_SHORT).show();
//                              }
//                          }
//                      });
//            }
//        });
//    }
    }
    }
