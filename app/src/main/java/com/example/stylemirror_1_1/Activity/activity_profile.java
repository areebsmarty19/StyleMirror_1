package com.example.stylemirror_1_1.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.stylemirror_1_1.R;
import com.example.stylemirror_1_1.databinding.ActivityProfileBinding;

public class activity_profile extends AppCompatActivity {

    ActivityProfileBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String username = getIntent().getStringExtra("usrname");
        String email = getIntent().getStringExtra("email");

        // Display the username in the activity_profile layout
        binding.usernameTextView.setText("Username: " + username);
        binding.emailTextView.setText(""+email);

        binding.tbr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_profile.this, activity_fav_items.class);
                startActivity(intent);
            }
        });

        binding.tbr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_profile.this, CartActivity.class);
                startActivity(intent);
            }
        });
        binding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_profile.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}