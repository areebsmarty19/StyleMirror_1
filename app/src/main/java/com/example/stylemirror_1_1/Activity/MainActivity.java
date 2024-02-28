package com.example.stylemirror_1_1.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.stylemirror_1_1.Adapter.PopularAdapter;
import com.example.stylemirror_1_1.Adapter.SliderAdapter;
import com.example.stylemirror_1_1.R;
import com.example.stylemirror_1_1.databinding.ActivityMainBinding;
import com.example.stylemirror_1_1.domain.PopularDomain;
import com.example.stylemirror_1_1.Dbmodels.DatabaseHelper;
import com.google.android.gms.common.api.Response;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    String usrname;
    String email1;
    DatabaseHelper databaseHelper;

    String url1,url2,url3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);
//        String username = getIntent().getStringExtra("username");
//        if (username != null ){
//            binding.textView2.setText(username);
//        }
        if (loggedIn()) {
            usrname = UsernameOfLoggInUser();
            binding.textView2.setText(UsernameOfLoggInUser());
        }
//        if (UsernameOfLoggInUser().equals("")){
//            binding.textView2.setText(UsernameOfLoggInUser());
//        }
        else {
            String username = getIntent().getStringExtra("username");
            binding.textView2.setText(username);
        }
        statusBarColor();
        initRecyclerView();
        bottomNavigation();

        email1 = EmailOfLoggInUser();

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

        binding.spec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, activity_specs_list.class);
                startActivity(intent);
            }
        });

        binding.sneakers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, activity_shoes_list.class);
                startActivity(intent);
            }
        });

//        binding.formals.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, activity_shoes_list.class);
//                startActivity(intent);
//            }
//        });

        binding.makeup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, activity_cosmetics_list.class);
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
         binding.profileBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(MainActivity.this, activity_profile.class);
                 startActivity(intent);
             }
         });

         binding.searchBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(MainActivity.this, activity_search.class);
                 startActivity(intent);
             }
         });

        ArrayList<SliderData> sliderDataArrayList = new ArrayList<>();

        // initializing the slider view.

        // adding the urls inside array list
        sliderDataArrayList.add(new SliderData(R.drawable.specposter));
        sliderDataArrayList.add(new SliderData(R.drawable.shoebanner));
        sliderDataArrayList.add(new SliderData(R.drawable.cosmetics));

        SliderView sliderView = findViewById(R.id.slider);


        // passing this array list inside our adapter class.
        SliderAdapter adapter = new SliderAdapter(this, sliderDataArrayList);

        // below method is used to set auto cycle direction in left to
        // right direction you can change according to requirement.
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);

        // below method is used to
        // setadapter to sliderview.
        sliderView.setSliderAdapter(adapter);

        // below method is use to set
        // scroll time in seconds.
        sliderView.setScrollTimeInSec(3);

        // to set it scrollable automatically
        // we use below method.
        sliderView.setAutoCycle(true);

        // to start autocycle below method is used.
        sliderView.startAutoCycle();
    }

    private String UsernameOfLoggInUser(){
        return databaseHelper.getUsernameByIfLoggIn();
    }
    private String EmailOfLoggInUser(){
        return databaseHelper.getEmailByIfLoggIn();
    }
    private boolean loggedIn() {
        return databaseHelper.isLoggedIn(); // You need to implement isLoggedIn method in DatabaseHelper
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
        items.add(new PopularDomain(16,"UV Protection Aviator Sunglasses","spects_7",0,0,1274,"Material Composition"));
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