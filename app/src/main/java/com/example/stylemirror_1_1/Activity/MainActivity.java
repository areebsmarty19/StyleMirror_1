package com.example.stylemirror_1_1.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.stylemirror_1_1.Adapter.PopularAdapter;
import com.example.stylemirror_1_1.R;
import com.example.stylemirror_1_1.databinding.ActivityMainBinding;
import com.example.stylemirror_1_1.domain.PopularDomain;
import com.example.stylemirror_1_1.Dbmodels.DatabaseHelper;

import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;
    String usrname;
    String email1;
    DatabaseHelper databaseHelper;

    private HandlerThreadManager handlerThreadManager;

    private AmazonApiClient amazonApiClient;

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
        String username = getIntent().getStringExtra("usrname");
        String email = getIntent().getStringExtra("email");

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
         binding.profileBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(MainActivity.this, activity_profile.class);
                 intent.putExtra("usrname", usrname);
                 intent.putExtra("email", email1);
                 startActivity(intent);
             }
         });
        amazonApiClient = AmazonApiClient.getInstance();
        handlerThreadManager = new HandlerThreadManager("ProductDetailsHandlerThread");

        // Fetch product details asynchronously
        handlerThreadManager.post(new Runnable() {
            @Override
            public void run() {
                amazonapiservice.AmazonApiService apiService = RetrofitClient.getClient("https://vitototti.p.rapidapi.com/").create(amazonapiservice.AmazonApiService.class);
                Call<ProductResponse> call = apiService.getProductDetails("1b115e0b9emsh209cfd59f7a8c07p13c229jsn0ec691b11e99", "B07GR5MSKD");

                call.enqueue(new Callback<ProductResponse>() {
                    @Override
                    public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
                        if (response.isSuccessful()) {
                            ProductResponse productResponse = response.body();
                            if (productResponse != null && productResponse.getProduct() != null) {
                                final String title = productResponse.getProduct().getTitle();
                                final String description = productResponse.getProduct().getDescription();
                                final String price = productResponse.getProduct().getPrice();

                                // Update UI on the main thread
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        TextView productTitleTextView = findViewById(R.id.product_title);
                                        TextView productDescriptionTextView = findViewById(R.id.product_description);
                                        TextView productPriceTextView = findViewById(R.id.product_price);

                                        productTitleTextView.setText(title);
                                        productDescriptionTextView.setText(description);
                                        productPriceTextView.setText(price);
                                    }
                                });
                            }
                        } else {
                            Log.e("MainActivity", "Error fetching product details: " + response.message());
                        }
                    }

                    @Override
                    public void onFailure(Call<ProductResponse> call, Throwable t) {
                        Log.e("MainActivity", "Error fetching product details: " + t.getMessage());
                    }
                });
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handlerThreadManager.quit();
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