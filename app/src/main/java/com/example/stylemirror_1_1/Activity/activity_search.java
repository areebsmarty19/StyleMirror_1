package com.example.stylemirror_1_1.Activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.stylemirror_1_1.R;
import com.example.stylemirror_1_1.databinding.ActivitySearchBinding;
import com.example.stylemirror_1_1.domain.PopularDomain;
import com.example.stylemirror_1_1.Adapter.SearchAdapter;

import java.util.ArrayList;
import java.util.Locale;

public class activity_search extends AppCompatActivity {

    ActivitySearchBinding binding;
    private ArrayList<PopularDomain> mList;
    private SearchAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mList = new ArrayList<>(); // Initialize mList before adding data
        addDataToList();

        adapter = new SearchAdapter(mList,this);
        binding.recyclerView.setAdapter(adapter);

        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });
    }

    private void filterList(String query) {
        if (query != null) {
            ArrayList<PopularDomain> filteredList = new ArrayList<>();
            for (PopularDomain data : mList) {
                if (data.getTitle().toLowerCase(Locale.ROOT).contains(query.toLowerCase(Locale.ROOT))) {
                    filteredList.add(data);
                }
            }

            if (filteredList.isEmpty()) {
                Toast.makeText(this, "No Data found", Toast.LENGTH_SHORT).show();
            } else {
                adapter.setFilteredList(filteredList);
            }
        }
    }

    private void addDataToList() {
        mList.add(new PopularDomain(1,"Air Max 270 Sneakers For Men", R.drawable.shoess_1,0,4,9796,"Wipe with clean cloth Nike's first lifestyle Air Max brings you style, comfort and big attitude in the Nike Air Max 270. The design draws inspiration from Air Max icons, showcasing Nike's greatest innovation with its large window and fresh array of colours."));
        mList.add(new PopularDomain(2,"Nike Viale Premium Men's Running Shoes", R.drawable.shoess_2,0,0,5695,""));
        mList.add(new PopularDomain(3,"Imba M Running Shoes For Men", R.drawable.shoess_3,0, (int) 4.1,1852,"Nike Viale Premium Men's Running Shoes NIKE men's running shoes"));
        mList.add(new PopularDomain(4,"BADLAV® Air Force Black Sneakers for Men", R.drawable.shoess_4,0, (int) 3.3,491,""));
        mList.add(new PopularDomain(5,"Blue Shades Clouded Sky Personalized Sneakers Lightweight Walking Shoes", R.drawable.shoess_5,0,0,0,"Design Concept: Sports Fusion Fashion, technology used in the upper and sole material. Application of skin-friendly Suede and TPR Outsole,strict machine suture. Material: Innovative use of skin-friendly Suede for a optimal breathable comfortable & lightweight feeling.Quickly absorb sweat and drying friendly,make feet cool and dry. Sole: High-quality rubber sole for lightweight cushioning. Vertical and horizontal flex grooves give you flexibility in all directions. Don’t crease and easy to clean Characteristics: Antimicrobial lining minimizes the risk of odor causing bacteria.Anti-odor technology applied to footbed to prevent the growth of odor-causing microbes."));
        mList.add(new PopularDomain(6,"NIKE Mens Full Force LoRunning Shoe", R.drawable.shoess_6,0, (int) 2.9,5947,"Materials: Breathable suede Upper + Non Slip Rubber Sole. Breathable suede Upper upper material make it possible that your feet to breathe freely while running or walking; Rubber sole adapts to ground stability and working strategy to optimize unique performance per bump and push. Applications: It's walking shoes, sneakers, running shoes, jogging shoes, gym sports, work out, exercise shoes, fabric sneakers, stretchy sneakers, training, flexible, fitness, mesh flats. Size: Please read the size details in the left image before purchase. The colour maybe different from the picture shown due to the different screen of display or reflecting light when shooting. Best for Gifts: The perfect gift to share with your families, girlfriend/friends on birthdays, Holiday, Halloween, Teacher's Day, Mother's Day, Thanksgiving Day, and Christmas day etc.Unique Design: A variety of colorful prints and Personalized patterns, Please click on our store to find more different styles."));
        mList.add(new PopularDomain(11,"Toughened Glass Lens", R.drawable.spects_1,0, (int) 4.1,1280,"Top of Form ,Currently one of the most iconic sunglass models in the world. This style of sunglasses is credited with being one of the first popularized style of sunglasses to be developed. In its military usage, the sunglasses replaced the outmoded flight goggles used previously, as they were lighter, thinner, and more elegantly designed. Aviate Classic sunglasses are a timeless model that combines great aviator styling with exceptional quality, performance and comfort. With a classic metal frame, you can see the world through a variety of lens colors including dark, gradient, mercury and day and night that provide optimum visual clarity and 100% UV protection.\"))"));
        mList.add(new PopularDomain(12,"Ray-Ban Men's Square Sunglasses", R.drawable.spects_2,0, (int) 4.1,10497,"Material Composition"));
        mList.add(new PopularDomain(13,"Ray-Ban Rb3447 Round Metal Sunglasses", R.drawable.spects_3,0, (int) 4.1,0,"Timeless Ray-Ban Round sunglasses feature retro round metal frames, a look worn by legendary musicians and inspired by 1960s counter-culture Round shape, matte gold metal frame, fixed crystal green polarized lenses that make these frames look real Featuring an iconic G-15 lens engineered to give you the clearest and most natural vision absorbing 85% of visible light and blocking most blue light, it delivers remarkable color contrast and visual clarity."));
        mList.add(new PopularDomain(14,"UV Protected Unisex Sunglasses", R.drawable.spects_4,0,5,348,"A perfect blend of highly durable modern day materials styled with pure craftsmanship and the trust of thousands of customers."));
        mList.add(new PopularDomain(15,"UV Protection Over-sized Sunglasses", R.drawable.spects_5,0,0,499,"Material Composition"));
        mList.add(new PopularDomain(16,"John Jacobs Brown Browline Polarized and UV Protected Sunglasses", R.drawable.spects_6,0, (int) 4.1,2807,"Material Composition UV protected"));
        mList.add(new PopularDomain(17,"UV Protection Aviator Sunglasses", R.drawable.spects_7,0,0,1274,"Material Composition"));
        mList.add(new PopularDomain(18,"Fastrack Mirrored Aviator Men's Sunglasses", R.drawable.spects_8,0, (int) 2.3,2295,"Material Composition"));
        mList.add(new PopularDomain(19,"UV Protection Cat-eye Sunglasses",R.drawable.spects_9,0, (int) 3.9,404,"Material Composition"));
        mList.add(new PopularDomain(20,"Riding Glasses Wayfarer Sunglasses",R.drawable.spects_10,0,0,182,"The amazing accessories to enhance your style statement is Spectacles Frames. They are trendy and never really go out of style. Made of polycarbonate material our products are ergonomically designed to give you a comfortable head hugging fit. Thus providing all-day wearing comfort. Spectacles Frames have been designed keeping your comfort and care as our first priority. These Spectacles Frames are really light and have been made of high quality frame with Stunning Looks & Flashy Colors. Mehjabeen enterprise Frames give you 100% protection against harmful UVA/UVB rays and are polarized for your eye care. Stay young. What do You get? Sunglasses * 1 Sunglasses Case * 1 Cleaning Soft Cloth * 1 sunglasses for mens sunglasses for women stylish sunglasses for women sunglasses for men."));
    }
}
