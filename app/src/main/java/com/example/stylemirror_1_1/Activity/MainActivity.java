package com.example.stylemirror_1_1.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.stylemirror_1_1.Adapter.PopularAdapter;
import com.example.stylemirror_1_1.R;
import com.example.stylemirror_1_1.databinding.ActivityMainBinding;
import com.example.stylemirror_1_1.domain.PopularDomain;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String username = getIntent().getStringExtra("username");
        binding.textView2.setText(username);

        statusBarColor();
        initRecyclerView();
        bottomNavigation();
         binding.explorerBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(MainActivity.this, activity_explorer.class);
                 startActivity(intent);
             }
         });
         binding.ViewAll.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(MainActivity.this, activity_explorer.class);
                 startActivity(intent);
             }
         });

         binding.wishlistBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(MainActivity.this, activity_fav_items.class);
                 startActivity(intent);
             }
         });

    }

    private void bottomNavigation() {
        binding.cartBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, CartActivity.class)));
    }

    private void statusBarColor() {
        Window window=MainActivity.this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.purple_Dark));
    }

    private void initRecyclerView() {
        ArrayList<PopularDomain> items=new ArrayList<>();
        items.add(new PopularDomain(1,"TRENDUTY Canvas Shoes for men","shoes1",15,4.1,852,"Allow your pair of shoes to air and de-odorize at\n"+
                "regular basis; use shoe bags to prevent any stains\n"+
                "or mildew; dust any dry dirt from the surface \n"+
                "using a clean cloth; do not use polish or shiner\n" +
                "TrenDuty represents the fashionable shoes range \n"+
                "from the Imported sneakers and canvas style of wears.\n"+
                "The fashion crowd is moving toward the wild and dramatic\n"+
                "styles rather than the simple and elegant ones.\n"+
                "TrenDuty All Sports Short Sneakers presents such a\n"+
                "fusion of classy and funky range of imported sneakers\n"+
                "for the youth who wants to look confident, with comfort\n"+
                "and style on his side, wants full control of his life."));
        items.add(new PopularDomain(2,"Smart Watch","item_2",10,4.5,450,"Immerse yourself in a world of vibrant visuals and\n" +
                " immersive sound with the monitor.\n" +
                " Its cutting-edge monitor technology brings every\n" +
                " scene to life with striking clarity and rich colors.\n" +
                " With seamless integration and a sleek, modern\n" +
                " design, the monitor Pro is not just a monitor , but a\n" +
                " centerpiece for your entertainment space.\n" +
                "With its sleek, modern design, the monitor is\n" +
                " not just a TV, but a centerpiece for your \n" +
                "entertainment space. The ultra-slim bezel and\n" +
                " premium finish blend seamlessly with any decor"));
        items.add(new PopularDomain(3,"Phone","item_3",3,4.9,800,"Immerse yourself in a world of vibrant visuals and\n" +
                " immersive sound with the monitor.\n" +
                " Its cutting-edge monitor technology brings every\n" +
                " scene to life with striking clarity and rich colors.\n" +
                " With seamless integration and a sleek, modern\n" +
                " design, the monitor Pro is not just a monitor , but a\n" +
                " centerpiece for your entertainment space.\n" +
                "With its sleek, modern design, the monitor is\n" +
                " not just a TV, but a centerpiece for your \n" +
                "entertainment space. The ultra-slim bezel and\n" +
                " premium finish blend seamlessly with any decor"));

        binding.PopularView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        binding.PopularView.setAdapter(new PopularAdapter(items,this));
    }
}