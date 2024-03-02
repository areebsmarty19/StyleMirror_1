package com.example.stylemirror_1_1.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
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
//    MeowBottomNavigation meowBottomNavigation;

//    String url1,url2,url3;
//    protected final int home = 1;
//    protected final int view = 2;
//    protected final int book = 3;
//    protected final int search = 4;
//    protected final int cart = 5;
//    protected final int profile = 5;

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

        //Nav Bar Of App.
//        meowBottomNavigation = findViewById(R.id.appBar);
//        meowBottomNavigation.add(new MeowBottomNavigation.Model(view,R.drawable.baseline_view_list_24));
//        meowBottomNavigation.add(new MeowBottomNavigation.Model(book,R.drawable.baseline_bookmark_border_24));
//        meowBottomNavigation.add(new MeowBottomNavigation.Model(home,R.drawable.baseline_home_24));
//        meowBottomNavigation.add(new MeowBottomNavigation.Model(search,R.drawable.baseline_search_24));
//        meowBottomNavigation.add(new MeowBottomNavigation.Model(cart,R.drawable.baseline_shopping_cart_24));
////        meowBottomNavigation.add(new MeowBottomNavigation.Model(profile,R.drawable.baseline_person_outline_24));
//
//        meowBottomNavigation.show(home,true);
//
//        meowBottomNavigation.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
//            @Override
//            public Unit invoke(MeowBottomNavigation.Model model) {
//                String name;
//                switch (model.getId()){
//
//                    case view:
//                        name="View More";
//                        Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
//                        Intent intent5 = new Intent(MainActivity.this,activity_explorer.class);
//                        startActivity(intent5);
//                        break;
//
//                    case book:
//                        name="WishList";
//                        Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
//                        Intent intent2 = new Intent(MainActivity.this,activity_fav_items.class);
//                        startActivity(intent2);
//                        break;
//
//                    case home:
//                        name="Home";
//                        Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
////                        Intent intent1 = new Intent(MainActivity.this,activity_explorer.class);
////                        startActivity(intent1);
//                        break;
//
//                    case search:
//                        name="Search";
//                        Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
//                        Intent intent3 = new Intent(MainActivity.this,activity_search.class);
//                        startActivity(intent3);
//                        break;
//
//                    case cart:
//                        name="Cart";
//                        Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
//                        Intent intent4 = new Intent(MainActivity.this,CartActivity.class);
//                        startActivity(intent4);
//                        break;
//
//                }
//                return null;
//            }
//        });

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

        binding.makeup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, activity_cosmetics_list.class);
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
        sliderDomainArrayList.add(new SliderDomain(R.drawable.specposter));
        sliderDomainArrayList.add(new SliderDomain(R.drawable.shoebanner));
        sliderDomainArrayList.add(new SliderDomain(R.drawable.cosmetics));

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
        items.add(new PopularDomain(1,"Air Max 270 Sneakers For Men","shoess_1","shoess_1","shoess_1",0,4,9796,"Wipe with clean cloth Nike's first lifestyle Air Max brings you style, comfort and big attitude in the Nike Air Max 270. The design draws inspiration from Air Max icons, showcasing Nike's greatest innovation with its large window and fresh array of colours.","https://www.flipkart.com/nike-air-max-270-sneakers-men/p/itm1d9717048f829?pid=SHOGQZKYZYC3K2B4&cmpid=product.share.pp&_refId=PP.1f10854d-aa61-4c99-a442-686cc67a67a6.SHOGQZKYZYC3K2B4&_appId=WA"));
        items.add(new PopularDomain(16,"UV Protection Aviator Sunglasses","spects_7","spects_7","spects_7",0,0,1274,"Material Composition","https://www.flipkart.com/speksee-aviator-sunglasses/p/itm578b54233f383?pid=SGLGUE8U4ABQVH5Y&cmpid=product.share.pp&_refId=PP.306a0ee9-796a-457d-a55a-aee80e38ff9f.SGLGUE8U4ABQVH5Y&_appId=WA"));
        items.add(new PopularDomain(3,"Phone","item_3","","",3,4.9,800,"Immerse yourself in a world of vibrant visuals and immersive sound with the monitor Its cutting-edge monitor technology brings every scene to life with striking clarity and rich colors With seamless integration and a sleek, modern design, the monitor Pro is not just a monitor , but a centerpiece for your entertainment space.With its sleek, modern design, the monitor is not just a TV, but a centerpiece for your entertainment space. The ultra-slim bezel and premium finish blend seamlessly with any decor",""));

        binding.PopularView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        binding.PopularView.setAdapter(new PopularAdapter(items,this));
    }
}