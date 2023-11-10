package com.example.canteen_app12;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class adminLogin extends AppCompatActivity {
        TextInputEditText editTextEmail,editTextPassword;


        MaterialButton signup;
        TextView forgot;
    FirebaseAuth firebaseAuth= FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_login);
        signup = findViewById(R.id.signup1);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(adminLogin.this,adminPage.class);
                startActivity(intent);
                finish();
            }
        });
//
//        signup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String user,password;
//                user=String.valueOf(editTextEmail.getText());
//                password=String.valueOf(editTextPassword.getText());
//                if(TextUtils.isEmpty(user)){
//                    Toast.makeText(adminLogin.this, "INVALID USER", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                if(TextUtils.isEmpty(password))
//                {
//                    Toast.makeText(adminLogin.this, "INVALID password", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                firebaseAuth.signInWithEmailAndPassword(user,password)
//                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                            @Override
//                            public void onComplete(@NonNull Task<AuthResult> task) {
//                                if(task.isSuccessful()){
//                                    Toast.makeText(adminLogin.this, "succesful login", Toast.LENGTH_SHORT).show();
//                                    Intent intent = new Intent(adminLogin.this,userpage.class);
//                                    startActivity(intent);
//                                    finish();
//                                }
//                                else {
//                                    Toast.makeText(adminLogin.this, "INVALId", Toast.LENGTH_SHORT).show();
//                                }
//                            }
//                        });
//            }
//        });
    }
    }