package com.example.stylemirror_1_1.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.stylemirror_1_1.databinding.ActivityExplorerBinding;

public class activity_explorer extends AppCompatActivity {

    ActivityExplorerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityExplorerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_explorer.this, activity_shoes_list.class);
                startActivity(intent);
            }
        });

        binding.imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_explorer.this,activity_specs_list.class);
                startActivity(intent);
            }
        });

        binding.imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_explorer.this,activity_cosmetics_list.class);
                startActivity(intent);
            }
        });
    }
}