package com.example.stylemirror_1_1.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.stylemirror_1_1.Dbmodels.DatabaseHelper;
import com.example.stylemirror_1_1.databinding.ActivityLoginBinding;

public class activity_login extends AppCompatActivity {
    private ActivityLoginBinding binding;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);

        // Check if user is already logged in
        if (loggedIn()) {
            startMainActivity();
            return; // Return to prevent further execution of onCreate
        }

        binding.forgetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_login.this,activity_forget_password.class);
                startActivity(intent);
            }
        });
        binding.logbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = binding.username.getText().toString();
                String password = binding.password.getText().toString();

                if (username.equals("") || password.equals("")) {
                    Toast.makeText(activity_login.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                } else {
                    if (password.length() >= 6 && password.length() <= 12) {
                        boolean checkCredentials = databaseHelper.checkEmailPassword(username, password);
                        if (checkCredentials) {
                            databaseHelper.setUserLoggedIn(true); // Mark user as logged in
                            Toast.makeText(activity_login.this, "Login Successfully!", Toast.LENGTH_SHORT).show();
                            startMainActivity();
                        } else {
                            Toast.makeText(activity_login.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(activity_login.this, "Invalid Password!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        binding.nuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_login.this, activity_register.class);
                startActivity(intent);
            }
        });
    }

    // Method to check if user is logged in
    private boolean loggedIn() {
        return databaseHelper.isLoggedIn(); // You need to implement isLoggedIn method in DatabaseHelper
    }

    // Method to start MainActivity
    private void startMainActivity() {
        Intent intent = new Intent(activity_login.this, MainActivity.class);
        intent.putExtra("username", binding.username.getText().toString());
        startActivity(intent);
        finish();
    }
}
