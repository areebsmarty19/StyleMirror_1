package com.example.stylemirror_1_1.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.stylemirror_1_1.Dbmodels.DatabaseHelper;
import com.example.stylemirror_1_1.databinding.ActivitySplashScreenBinding;
import com.example.stylemirror_1_1.R;

public class activity_splash_screen extends AppCompatActivity {

    ActivitySplashScreenBinding binding;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);

        startAnimation();
    }

    private void startAnimation() {
        binding.imageView.setImageResource(R.drawable.style_mirror_logo);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.fly_in); // Use "fly_in" animation
        binding.imageView.startAnimation(animation);

        // Move to the next activity after the splash duration
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Check if the user is logged in
                if (loggedIn()) {
                    // User is logged in, navigate to MainActivity
                    Intent intent = new Intent(activity_splash_screen.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    // User is not logged in, navigate to LoginActivity
                    Intent intent = new Intent(activity_splash_screen.this, activity_login.class);
                    startActivity(intent);
                }
                finish(); // Finish the splash activity to prevent going back to it when pressing back button
            }
        }, 2000);
    }

    private boolean loggedIn() {
        return databaseHelper.isLoggedIn(); // You need to implement isLoggedIn method in DatabaseHelper
    }
}