package com.example.stylemirror_1_1.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.example.stylemirror_1_1.Helper.FavDB;
import com.example.stylemirror_1_1.Helper.ManagmentCart;
import com.example.stylemirror_1_1.R;
import com.example.stylemirror_1_1.databinding.ActivityDetailBinding;
import com.example.stylemirror_1_1.domain.PopularDomain;

public class DetailActivity extends AppCompatActivity {

    private final String url = "https://specstry.netlify.app/";
    private ActivityDetailBinding binding;
    private PopularDomain object;
    private FavDB favDB;
    private ManagmentCart managmentCart;
    private boolean isFavorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        favDB = new FavDB(this);
        managmentCart = new ManagmentCart(this);

        statusBarColor();
        getBundles();
    }

    private void statusBarColor() {
        Window window = DetailActivity.this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(DetailActivity.this, R.color.white));
    }

    private void getBundles() {
        object = (PopularDomain) getIntent().getSerializableExtra("object");
        isFavorite = favDB.checkFavoriteStatus(object.getId());

        int drawableResourceId = this.getResources().getIdentifier(object.getPicUrl(), "drawable", this.getPackageName());

        Glide.with(this)
                .load(drawableResourceId)
                .into(binding.productImage);

        binding.productTitle.setText(formatTitle(object.getTitle()));
        binding.productPrice.setText("" + object.getPrice());
        binding.productDescription.setText(object.getDescription());
        binding.reviewTxt.setText(String.valueOf(object.getReview()));
        binding.ratingTxt.setText(String.valueOf(object.getScore()));

        binding.addToCart.setOnClickListener(v -> {
            object.setNumberInCart(1);
            managmentCart.insertFood(object);
        });

        binding.buyNow.setOnClickListener(v -> {
            object.setNumberInCart(1);
            managmentCart.insertFood(object);
            Intent intent = new Intent(DetailActivity.this, CartActivity.class);
            startActivity(intent);
        });

        binding.favBtn.setImageResource(isFavorite ? R.drawable.ic_bookmark_filled : R.drawable.ic_bookmark);
        binding.favBtn.setOnClickListener(v -> {
            if (isFavorite) {
                favDB.remove_fav(object.getId());
                Toast.makeText(this, object.getTitle() +" Removed from Favorites.", Toast.LENGTH_SHORT).show();
            } else {
                favDB.insertIntoTheDatabase(object.getTitle(), object.getPicUrl(), object.getPrice(), object.getDescription(), object.getId(), "1");
                Toast.makeText(this, object.getTitle() + " Added to Favorites.", Toast.LENGTH_SHORT).show();
            }
            isFavorite = !isFavorite;
            binding.favBtn.setImageResource(isFavorite ? R.drawable.ic_bookmark_filled : R.drawable.ic_bookmark);
        });
        binding.backBtn.setOnClickListener(v -> finish());

        binding.virtual.setOnClickListener(v->{

             String data = "";
             String id = object.getId();

//            intent.putExtra("id",object.getId());
            switch (id){
                case "11" :
                    data = String.valueOf(1);
                    break;

                case "12" :
                    data = String.valueOf(2);
                    break;

                case "13" :
                    data = String.valueOf(3);
                    break;

                case "14" :
                    data = String.valueOf(4);
                    break;

                case "15" :
                    data = String.valueOf(5);
                    break;

                case "16" :
                    data = String.valueOf(6);
                    break;

                case "17" :
                    data = String.valueOf(7);
                    break;

                case "18" :
                    data = String.valueOf(8);
                    break;

                case "19" :
                    data = String.valueOf(9);
                    break;

                case "20" :
                    data = String.valueOf(10);
                    break;

                default:
                    data = String.valueOf(1);
                    break;

            }
            String full = url+"?data="+ Uri.encode(data);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(full));
            startActivity(intent);

        });
    }

    private String formatTitle(String title) {
        StringBuilder formattedTitle = new StringBuilder();
        int consecutiveSpaces = 0;
        for (char c : title.toCharArray()) {
            if (c == ' ') {
                consecutiveSpaces++;
                if (consecutiveSpaces == 3) {
                    formattedTitle.append("\n");
                    consecutiveSpaces = 0;
                }
            }
            formattedTitle.append(c);
        }
        return formattedTitle.toString();
    }

}
