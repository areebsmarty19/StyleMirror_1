package com.example.stylemirror_1_1.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.stylemirror_1_1.Adapter.PopularAdapter;
import com.example.stylemirror_1_1.domain.PopularDomain;
import com.example.stylemirror_1_1.databinding.ActivityListBinding;

import java.util.ArrayList;

public class activity_list extends AppCompatActivity {
    ActivityListBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        itemlistRecyclerView();
    }
    private void itemlistRecyclerView() {
        ArrayList<PopularDomain> items=new ArrayList<>();
        items.add(new PopularDomain(4,"Shoes 1","shoes",15,4,500,"Immerse yourself in a world of vibrant visuals and\n" +
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
        items.add(new PopularDomain(5,"Shoes 2","shoes1",10,4.5,450,"Immerse yourself in a world of vibrant visuals and\n" +
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
        items.add(new PopularDomain(6,"Shoes 3","shoes4",3,4.9,800,"Immerse yourself in a world of vibrant visuals and\n" +
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

        binding.productList.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        binding.productList.setAdapter(new PopularAdapter(items));
    }
}