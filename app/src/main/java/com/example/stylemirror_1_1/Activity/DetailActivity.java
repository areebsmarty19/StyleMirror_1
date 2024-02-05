package com.example.stylemirror_1_1.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.example.stylemirror_1_1.Helper.ManagmentCart;
import com.example.stylemirror_1_1.R;
import com.example.stylemirror_1_1.databinding.ActivityDetailBinding;
import com.example.stylemirror_1_1.domain.PopularDomain;
import com.example.stylemirror_1_1.domain.ShoesDomain;


public class DetailActivity extends AppCompatActivity {
    private ActivityDetailBinding binding;
    private PopularDomain object;
    private ShoesDomain object2;
    private int numberOrder = 1;
    private ManagmentCart managmentCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getBundles();
        managmentCart = new ManagmentCart(this);
        statusBarColor();
    }

    private void statusBarColor() {
        Window window = DetailActivity.this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(DetailActivity.this, R.color.white));
    }

    private void getBundles() {
        object = (PopularDomain) getIntent().getSerializableExtra("object");
        object2 = (ShoesDomain) getIntent().getSerializableExtra("object2");
        int drawableResourceId = this.getResources().getIdentifier(object.getPicUrl(), "drawable", this.getPackageName());
        int drawableResourceId2 = this.getResources().getIdentifier(object.getPicUrl(), "drawable", this.getPackageName());
        Glide.with(this)
                .load(drawableResourceId)
                .into(binding.productImage);
        Glide.with(this)
                .load(drawableResourceId2)
                .into(binding.productImage);
        binding.productName.setText(object.getTitle());
            binding.productPrice.setText("$" + object.getPrice());
            binding.productFullDescription.setText(object.getDescription());
            //binding.reviewTxt.setText(object.getReview() + "");
            //binding.ratingTxt.setText(object.getScore() + "");

            binding.addToCart.setOnClickListener(v -> {
                object.setNumberInCart(numberOrder);
                managmentCart.insertFood(object);
            });
//        Switch() {
//            case object:
//            binding.productName.setText(object.getTitle());
//            binding.productPrice.setText("$" + object.getPrice());
//            binding.productFullDescription.setText(object.getDescription());
//            //binding.reviewTxt.setText(object.getReview() + "");
//            //binding.ratingTxt.setText(object.getScore() + "");
//
//            binding.addToCart.setOnClickListener(v -> {
//                object.setNumberInCart(numberOrder);
//                managmentCart.insertFood(object);
//            });
//            break;
//            case object2:
//            binding.productName.setText(object2.getShoesTitle());
//            binding.productPrice.setText("$" + object2.getShoesPrice());
//            binding.productFullDescription.setText(object2.getShoesDescription());
//            //binding.reviewTxt.setText(object2.getReview() + "");
//            //binding.ratingTxt.setText(object2.getScore() + "");
//
//            binding.addToCart.setOnClickListener(v -> {
//                object2.setShoesNumberInCart(numberOrder);
//                managmentCart.insertFood(object2);
//            });
//            }
        binding.buyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                object.setNumberInCart(numberOrder);
                managmentCart.insertFood(object);
                Intent intent = new Intent(DetailActivity.this,CartActivity.class);
                startActivity(intent);
            }
        });
        binding.backBtn.setOnClickListener(v -> finish());
    }
}