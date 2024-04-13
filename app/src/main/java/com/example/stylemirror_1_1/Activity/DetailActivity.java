package com.example.stylemirror_1_1.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.example.stylemirror_1_1.Adapter.SliderAdapter;
import com.example.stylemirror_1_1.Helper.FavDB;
import com.example.stylemirror_1_1.Helper.ManagmentCart;
import com.example.stylemirror_1_1.R;
import com.example.stylemirror_1_1.databinding.ActivityDetailBinding;
import com.example.stylemirror_1_1.domain.PopularDomain;
import com.example.stylemirror_1_1.domain.SliderDomain;
import com.example.stylemirror_1_1.Adapter.SliderAdapter;
import com.smarteist.autoimageslider.SliderView;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    private final String shoeurl = "https://shoetry.netlify.app/";
    private final String specsurl = "https://specstry.netlify.app/";
    private final String cosmeticssurl = "https://cosm.netlify.app/";
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

        int drawableResourceId1 = this.getResources().getIdentifier(object.getPicUrl1(), "drawable", this.getPackageName());
        int drawableResourceId2 = this.getResources().getIdentifier(object.getPicUrl2(), "drawable", this.getPackageName());
        int drawableResourceId3 = this.getResources().getIdentifier(object.getPicUrl3(), "drawable", this.getPackageName());


        binding.productTitle.setText(object.getTitle());
        binding.productPrice.setText("" + object.getPrice());
        binding.productDescription.setText(object.getDescription());
        binding.reviewTxt.setText(String.valueOf(object.getScore()));
        binding.ratingTxt.setText(String.valueOf(object.getReview()));

        binding.addToCart.setOnClickListener(v -> {
            object.setNumberInCart(1);
            managmentCart.insertFood(object);
        });

        binding.buyNow.setOnClickListener(v -> {
            String url = object.getUrl();
            Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(url));
            startActivity(intent);
        });

        binding.favBtn.setImageResource(isFavorite ? R.drawable.ic_bookmark_filled : R.drawable.ic_bookmark);
        binding.favBtn.setOnClickListener(v -> {
            if (isFavorite) {
                favDB.remove_fav(object.getId());
                Toast.makeText(this, object.getTitle() +" Removed from Favorites.", Toast.LENGTH_SHORT).show();
            } else {
                favDB.insertIntoTheDatabase(object.getTitle(), object.getPicUrl1(), object.getPicUrl2(), object.getPicUrl3(), object.getPrice(), object.getDescription(), object.getId(), "1");
                Toast.makeText(this, object.getTitle() + " Added to Favorites.", Toast.LENGTH_SHORT).show();
            }
            isFavorite = !isFavorite;
            binding.favBtn.setImageResource(isFavorite ? R.drawable.ic_bookmark_filled : R.drawable.ic_bookmark);
        });

        binding.backBtn.setOnClickListener(v -> finish());

        binding.virtual.setOnClickListener(v->{

            String data = "";
            String id = object.getId();

            switch (id){

                case "1":
                case "11":
                case "21":
                    data = String.valueOf(0);
                    break;

                case "2":
                case "12" :
                case "22":
                    data = String.valueOf(1);
                    break;

                case "3":
                case "13" :
                case "23" :
                    data = String.valueOf(2);
                    break;

                case "4":
                case "14" :
                case "24" :
                    data = String.valueOf(3);
                    break;

                case "5":
                case "15" :
                case "25" :
                    data = String.valueOf(4);
                    break;

                case "6":
                case "16" :
                case "26" :
                    data = String.valueOf(5);
                    break;

                case "7":
                case "17" :
                case "27" :
                    data = String.valueOf(6);
                    break;

                case "8":
                case "18" :
                case "28" :
                    data = String.valueOf(7);
                    break;

                case "9":
                case "19" :
                case "29" :
                    data = String.valueOf(8);
                    break;

                case "10":
                case "20" :
                case "30" :
                    data = String.valueOf(9);
                    break;

                case "31" :
                    data = String.valueOf(10);
                    break;

                case "32" :
                    data = String.valueOf(11);
                    break;

                case "33" :
                    data = String.valueOf(12);
                    break;

                case "34" :
                    data = String.valueOf(13);
                    break;

                case "35" :
                    data = String.valueOf(14);
                    break;

                case "36" :
                    data = String.valueOf(15);
                    break;

                case "37" :
                    data = String.valueOf(16);
                    break;

                case "38" :
                    data = String.valueOf(17);
                    break;

                case "39" :
                    data = String.valueOf(18);
                    break;

                case "40" :
                    data = String.valueOf(19);
                    break;

                case "41" :
                    data = String.valueOf(20);
                    break;

                case "42" :
                    data = String.valueOf(21);
                    break;

                case "43" :
                    data = String.valueOf(22);
                    break;

                case "44" :
                    data = String.valueOf(23);
                    break;

                case "45" :
                    data = String.valueOf(24);
                    break;

                case "46" :
                    data = String.valueOf(25);
                    break;

                case "47" :
                    data = String.valueOf(26);
                    break;

                case "48" :
                    data = String.valueOf(27);
                    break;

                case "49" :
                    data = String.valueOf(28);
                    break;

                case "50" :
                    data = String.valueOf(29);
                    break;

                default:
                    data = String.valueOf(0);
                    break;

            }

            Intent intent = new Intent(Intent.ACTION_VIEW);
            String full="";
            int id1 = Integer.parseInt(id);
            if (id1 <= 10) {
                full = shoeurl + "?data=" + Uri.encode(data);
                intent.setData(Uri.parse(full));
                startActivity(intent);
            }
            else if (id1 <= 20 && id1 >10) {
                full = specsurl + "?data=" + Uri.encode(data);
                intent.setData(Uri.parse(full));
                startActivity(intent);
            }
            else{
                full = cosmeticssurl + "?data=" + Uri.encode(data);
                intent.setData(Uri.parse(full));
                startActivity(intent);
            }
        });

        //Slider! Multiple images of a product.
        ArrayList<SliderDomain> sliderDomainArrayList = new ArrayList<>();

        // initializing the slider view.
        // adding the urls inside array list
        sliderDomainArrayList.add(new SliderDomain(drawableResourceId1));
        sliderDomainArrayList.add(new SliderDomain(drawableResourceId2));
        sliderDomainArrayList.add(new SliderDomain(drawableResourceId3));

        SliderView sliderView = findViewById(R.id.slider);

        // passing this array list inside our adapter class.
        SliderAdapter adapter = new SliderAdapter(this, sliderDomainArrayList);

        // below method is used to
        // setadapter to sliderview.
        sliderView.setSliderAdapter(adapter);

        // below method is use to set
        // scroll time in seconds.
        sliderView.setScrollTimeInSec(3);
    }

}