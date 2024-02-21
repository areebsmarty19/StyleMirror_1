package com.example.stylemirror_1_1.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.stylemirror_1_1.R;
import com.example.stylemirror_1_1.databinding.ActivityProfileBinding;
import com.example.stylemirror_1_1.Dbmodels.DatabaseHelper;

public class activity_profile extends AppCompatActivity {

    ActivityProfileBinding binding;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);

        String username = UsernameOfLoggInUser();
        String email = EmailOfLoggInUser();

        // Display the username in the activity_profile layout
        binding.usernameTextView.setText("Username : " + username);
        binding.emailTextView.setText("Email : " + email);

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

    private String UsernameOfLoggInUser(){
        return databaseHelper.getUsernameByIfLoggIn();
    }
    private String EmailOfLoggInUser(){
        return databaseHelper.getEmailByIfLoggIn();
    }

}