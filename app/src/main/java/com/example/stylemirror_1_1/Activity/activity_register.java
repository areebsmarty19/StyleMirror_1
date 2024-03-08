package com.example.stylemirror_1_1.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.stylemirror_1_1.Dbmodels.DatabaseHelper;
import com.example.stylemirror_1_1.databinding.ActivityRegisterBinding;

import android.util.Patterns;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class activity_register extends AppCompatActivity {

    ActivityRegisterBinding binding;
    DatabaseHelper databaseHelper;

    // Define regex patterns for username and password
    private static final String USERNAME_PATTERN = "^[a-zA-Z]{2,}\\s[a-zA-Z]{2,}$";
    private static final String PASSWORD_PATTERN = "^(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,12}$";

    // Pattern for email validation provided by Android Patterns class
    // This pattern is a basic validation, more strict validation can be done if needed
    private Pattern emailPattern = Patterns.EMAIL_ADDRESS;

    // Matcher objects for regex validation
    private Matcher usernameMatcher, passwordMatcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);

        binding.SignUpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = binding.username.getText().toString();
                String email = binding.email.getText().toString();
                String password = binding.password.getText().toString();

                // Validate username
                if (!isValidUsername(username)) {
                    Toast.makeText(activity_register.this, "Invalid username format! Username should have at least 2 words", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Validate email
                if (!isValidEmail(email)) {
                    Toast.makeText(activity_register.this, "Invalid email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Validate password
                if (!isValidPassword(password)) {
                    Toast.makeText(activity_register.this, "Invalid password format! Password should have at least 6 characters, including one capital letter and one special symbol", Toast.LENGTH_SHORT).show();
                    return;
                }

                // If all validations pass, proceed with registration
                if (password.length() >= 6 && password.length() <= 12) {
                    Boolean checkUserEmail = databaseHelper.checkEmail(email);

                    if (!checkUserEmail) {
                        Boolean insert = databaseHelper.insertdata(username,email, password);

                        if (insert) {
                            Toast.makeText(activity_register.this, "Signup Successfully!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(activity_register.this, activity_login.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(activity_register.this, "Signup Failed!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(activity_register.this, "User already exists! Please login", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(activity_register.this, "Password Should be Greater than 6 letters and between 12 letters", Toast.LENGTH_SHORT).show();
                }
            }
        });


        binding.existingUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_register.this, activity_login.class);
                startActivity(intent);
                finish();
            }
        });
    }

    // Method to validate username using regex
    private boolean isValidUsername(String username) {
        usernameMatcher = Pattern.compile(USERNAME_PATTERN).matcher(username);
        return usernameMatcher.matches();
    }

    // Method to validate email using Android Patterns
    private boolean isValidEmail(String email) {
        return emailPattern.matcher(email).matches();
    }

    // Method to validate password using regex
    private boolean isValidPassword(String password) {
        passwordMatcher = Pattern.compile(PASSWORD_PATTERN).matcher(password);
        return passwordMatcher.matches();
    }
}
