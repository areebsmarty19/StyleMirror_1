package com.example.stylemirror_1_1.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.stylemirror_1_1.Dbmodels.DatabaseHelper;
import com.example.stylemirror_1_1.databinding.ActivityLoginBinding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class activity_login extends AppCompatActivity {
    private ActivityLoginBinding binding;
    DatabaseHelper databaseHelper;

    // Define regex patterns for username and password
    private static final String USERNAME_PATTERN = "^[a-zA-Z]{2,}\\s[a-zA-Z]{2,}$";
    private static final String PASSWORD_PATTERN = "^(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,12}$";

    // Matcher object for regex validation
    private Matcher usernameMatcher,passwordMatcher;

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

                // Validate username
                if (username.isEmpty()) {
                    Toast.makeText(activity_login.this, "Username field is mandatory", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Validate password
                if (password.isEmpty()) {
                    Toast.makeText(activity_login.this, "Password field is mandatory", Toast.LENGTH_SHORT).show();
                    return;
                }

                // validate username format
                if (!isValidUsername(username)) {
                    Toast.makeText(activity_login.this, "Invalid username format! Username should have at least 2 words", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Validate password format
                if (!isValidPassword(password)) {
                    Toast.makeText(activity_login.this, "Invalid Password! Password should have at least 6 characters, including one capital letter and one special symbol", Toast.LENGTH_SHORT).show();
                    return;
                }

                boolean checkCredentials = databaseHelper.checkEmailPassword(username, password);
                if (checkCredentials) {
                    databaseHelper.setUserLoggedIn(true); // Mark user as logged in
                    Toast.makeText(activity_login.this, "Login Successfully!", Toast.LENGTH_SHORT).show();
                    startMainActivity();
                    finish();
                } else {
                    Toast.makeText(activity_login.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
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

    // Method to start MainActivity
    private void startMainActivity() {
        Intent intent = new Intent(activity_login.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    // Method to check if user is logged in
    private boolean loggedIn() {
        return databaseHelper.isLoggedIn(); // You need to implement isLoggedIn method in DatabaseHelper
    }

    // Method to validate username using regex
    private boolean isValidUsername(String username) {
        usernameMatcher = Pattern.compile(USERNAME_PATTERN).matcher(username);
        return usernameMatcher.matches();
    }

    // Method to validate password using regex
    private boolean isValidPassword(String password) {
        passwordMatcher = Pattern.compile(PASSWORD_PATTERN).matcher(password);
        return passwordMatcher.matches();
    }
}
