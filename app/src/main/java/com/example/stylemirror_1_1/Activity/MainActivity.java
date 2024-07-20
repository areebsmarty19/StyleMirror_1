package com.example.stylemirror_1_1.Activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;


import com.example.stylemirror_1_1.Adapter.PopularAdapter;
import com.example.stylemirror_1_1.Adapter.SliderAdapter;
import com.example.stylemirror_1_1.R;
import com.example.stylemirror_1_1.databinding.ActivityMainBinding;
import com.example.stylemirror_1_1.domain.PopularDomain;
import com.example.stylemirror_1_1.Dbmodels.DatabaseHelper;
import com.example.stylemirror_1_1.domain.SliderDomain;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);

        //Set the username.
        if (loggedIn()) {
            binding.textView2.setText(UsernameOfLoggInUser());
        }

        statusBarColor();
        initRecyclerView();

        //User Want to Log Out from the App.
        binding.logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Call User define function.
                logout();
            }
        });

        binding.spec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Spectacles List", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, activity_specs_list.class);
                startActivity(intent);
            }
        });

        binding.sneakers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Shoes List", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, activity_shoes_list.class);
                startActivity(intent);
            }
        });

        binding.makeup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Cosmetics List", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, activity_cosmetics_list.class);
                startActivity(intent);
            }
        });

        binding.ViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "View More", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, activity_explorer.class);
                startActivity(intent);
            }
        });

        //Listener Of All Nav Bar items.
         binding.explorerBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Toast.makeText(MainActivity.this, "View More", Toast.LENGTH_SHORT).show();
                 Intent intent = new Intent(MainActivity.this, activity_explorer.class);
                 startActivity(intent);
             }
         });
         binding.wishlistBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Toast.makeText(MainActivity.this, "Favorites Items", Toast.LENGTH_SHORT).show();
                 Intent intent = new Intent(MainActivity.this, activity_fav_items.class);
                 startActivity(intent);
             }
         });
         binding.searchBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Toast.makeText(MainActivity.this, "Search", Toast.LENGTH_SHORT).show();
                 Intent intent = new Intent(MainActivity.this, activity_search.class);
                 startActivity(intent);
             }
         });
         binding.cartBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Toast.makeText(MainActivity.this, "Cart", Toast.LENGTH_SHORT).show();
                 Intent intent = new Intent(MainActivity.this, CartActivity.class);
                 startActivity(intent);
             }
         });
         binding.profileBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Toast.makeText(MainActivity.this, "Profile", Toast.LENGTH_SHORT).show();
                 Intent intent = new Intent(MainActivity.this, activity_profile.class);
                 startActivity(intent);
             }
         });


        //Slider Code.
        ArrayList<SliderDomain> sliderDomainArrayList = new ArrayList<>();

        // initializing the slider view.
        // adding the urls inside array list
        sliderDomainArrayList.add(new SliderDomain(R.drawable.banner_1));
        sliderDomainArrayList.add(new SliderDomain(R.drawable.banner_2));
        sliderDomainArrayList.add(new SliderDomain(R.drawable.banner_3));

        SliderView sliderView = findViewById(R.id.slider);

        // passing this array list inside our adapter class.
        SliderAdapter adapter = new SliderAdapter(this, sliderDomainArrayList);

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

        //Log Out User From the App
        private void logout() {
            new AlertDialog.Builder(this)
                    .setTitle("Log Out")
                    .setMessage("Are you sure you want to Log Out From App?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            databaseHelper.setUserLoggedIn(false);

                            Intent intent = new Intent(MainActivity.this,activity_login.class);
                            startActivity(intent);
                            finish();
                            dialog.dismiss();
                        }
                    })
                    .setNegativeButton("No", null)
                    .show();
        }

    //Fetch If User Already Login or Not.
    private boolean loggedIn() {
        return databaseHelper.isLoggedIn(); // You need to implement isLoggedIn method in DatabaseHelper
    }

    //Fetch The Username Of Logged In User.
    private String UsernameOfLoggInUser(){
        return databaseHelper.getUsernameByIfLoggIn();
    }

    private void statusBarColor() {
        Window window=MainActivity.this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.purple_Dark));
    }

    //MainActivity Recycle View.
    private void initRecyclerView() {
        ArrayList<PopularDomain> items=new ArrayList<>();
        items.add(new PopularDomain(1,"Air Max 270 Sneakers For Men","shoess_1_1","shoess_1_2","shoess_1_3",0,4,9796,"Wipe with clean cloth Nike's first lifestyle Air Max brings you style, comfort and big attitude in the Nike Air Max 270. The design draws inspiration from Air Max icons, showcasing Nike's greatest innovation with its large window and fresh array of colours.","https://www.flipkart.com/nike-air-max-270-sneakers-men/p/itm1d9717048f829?pid=SHOGQZKYZYC3K2B4&cmpid=product.share.pp&_refId=PP.1f10854d-aa61-4c99-a442-686cc67a67a6.SHOGQZKYZYC3K2B4&_appId=WA"));
        items.add(new PopularDomain(16,"UV Protection Aviator Sunglasses","spects_7_1","spects_7_2","spects_7_3",0,0,1274,"Material Composition","https://www.flipkart.com/speksee-aviator-sunglasses/p/itm578b54233f383?pid=SGLGUE8U4ABQVH5Y&cmpid=product.share.pp&_refId=PP.306a0ee9-796a-457d-a55a-aee80e38ff9f.SGLGUE8U4ABQVH5Y&_appId=WA"));
        items.add(new PopularDomain(21, "Maybelline Color Sensational Lipstick Pink Thrill", "lips_1_1", "lips_1_2", "lips_1_3", 4.1, 34058, 1248, "Color Sensational The Creams delivers crisp color and smooth lips - Infused with Shea Butter, Color Sensational The Creams takes on a new feeling from the first touch of the packaging to the first swipe Color Sensational The Creams lipsticks deliver pure color pigments and Shea Butter for vibrant color, smooth lips and a creamy finish that does not bleed or feather Highly pigmented lip color with a creamy smooth glide during application that leaves lips feeling hydrated, nurtured, and conditioned Available in sensational lipstick shades you know and love - nudes, pinks, reds and plums - that are rich, warm and made to flatter your skin tone Color Sensational The Creams lipsticks now include your favorite shades from the Vivids and Buffs collections.", "https://www.amazon.in/Maybelline-Sensational-Lipstick-Hydrating-Packaging/dp/B07YXG7LSR"));
        items.add(new PopularDomain(31,"MARS Fabulash Eyelashes (Spice Art)","eyels_1_1","eyels_1_2","eyels_1_3",3.9,26,95,"Lashes Can be used for upto 10 times, If proper care is taken, Make Sure you clean the Band after every use and Store them Properly in the Box Provided They are a mix of natural and heavy lashes You can wear them everyday or in parties.These lashes have a thin band.","https://www.amazon.in/dp/B0BD8CWBST?ref_=cm_sw_r_mwn_dp_GYAVWZND92Y6Y7ETQ433&language=en_US"));
        items.add(new PopularDomain(41,"Miss Claire Single Eyeshadow - 0507","eyesh_1_1","eyesh_1_2","eyesh_1_3", 4.2, 6963, 80,"Miss Claire's Single Eye Shadow features a long-wearing crème powder formula that is super creamy, insanely pigmented, and has one swipe intensity. This collection features a range of everyday shades that combine high-pigment with high-shine.","https://www.nykaa.com/miss-claire-single-eyeshadow/p/271315?ptype=product&skuId=271289&utm_content=ads&utm_source=GooglePaid&utm_medium=PLA&utm_campaign=PerformanceMaxFullSiteATC&hlp=hlpa&gad_source=4&gclid=CjwKCAiAi6uvBhADEiwAWiyRduHTobTp_9BBDvS_liGkNx7hCNsWYf-lJW-OAYqC4yPDOY6NSISjxBoCyEAQAvD_BwE"));

        binding.PopularView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        binding.PopularView.setAdapter(new PopularAdapter(items,this));
    }
}