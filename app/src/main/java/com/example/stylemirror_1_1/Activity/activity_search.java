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
        mList.add(new PopularDomain(1,"Air Max 270 Sneakers For Men", R.drawable.shoess_1));
        mList.add(new PopularDomain(2,"Nike Viale Premium Men's Running Shoes", R.drawable.shoess_2));
        mList.add(new PopularDomain(3,"Imba M Running Shoes For Men", R.drawable.shoess_3));
        mList.add(new PopularDomain(4,"BADLAV® Air Force Black Sneakers for Men", R.drawable.shoess_4));
        mList.add(new PopularDomain(5,"Blue Shades Clouded Sky Personalized Sneakers Lightweight Walking Shoes", R.drawable.shoess_5));
        mList.add(new PopularDomain(6,"NIKE Mens Full Force LoRunning Shoe", R.drawable.shoess_6));
        mList.add(new PopularDomain(11,"Toughened Glass Lens", R.drawable.spects_1));
        mList.add(new PopularDomain(12,"Ray-Ban Men's Square Sunglasses", R.drawable.spects_2));
        mList.add(new PopularDomain(13,"Ray-Ban Rb3447 Round Metal Sunglasses", R.drawable.spects_3));
        mList.add(new PopularDomain(14,"UV Protected Unisex Sunglasses", R.drawable.spects_4));
        mList.add(new PopularDomain(15,"UV Protection Over-sized Sunglasses", R.drawable.spects_5));
        mList.add(new PopularDomain(16,"John Jacobs Brown Browline Polarized and UV Protected Sunglasses", R.drawable.spects_6));
        mList.add(new PopularDomain(17,"UV Protection Aviator Sunglasses", R.drawable.spects_7));
        mList.add(new PopularDomain(18,"Fastrack Mirrored Aviator Men's Sunglasses", R.drawable.spects_8));
        mList.add(new PopularDomain(19,"UV Protection Cat-eye Sunglasses",R.drawable.spects_9));
        mList.add(new PopularDomain(20,"Riding Glasses Wayfarer Sunglasses",R.drawable.spects_10));
    }
}
