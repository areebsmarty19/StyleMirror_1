package com.example.stylemirror_1_1.Activity;

import android.database.Cursor;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.stylemirror_1_1.Adapter.PopularAdapter;
import com.example.stylemirror_1_1.Helper.FavDB;
import com.example.stylemirror_1_1.databinding.ActivityFavitemsBinding;
import com.example.stylemirror_1_1.domain.PopularDomain;

import java.util.ArrayList;

public class activity_fav_items extends AppCompatActivity {
    private ActivityFavitemsBinding binding;
    private FavDB favDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFavitemsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        favDB = new FavDB(this);

        ArrayList<PopularDomain> favoriteItems = getFavoriteItems();

        binding.productList.setLayoutManager(new LinearLayoutManager(this));
        binding.productList.setAdapter(new PopularAdapter(favoriteItems,this));
    }

    private ArrayList<PopularDomain> getFavoriteItems() {
        ArrayList<PopularDomain> favoriteItems = new ArrayList<>();
        Cursor cursor = favDB.select_all_favorite_list();

        if (cursor != null && cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex(FavDB.KEY_ID));
                String title = cursor.getString(cursor.getColumnIndex(FavDB.ITEM_TITLE));
                String imageUrl1 = cursor.getString(cursor.getColumnIndex(FavDB.ITEM_IMAGE1));
                String imageUrl2 = cursor.getString(cursor.getColumnIndex(FavDB.ITEM_IMAGE2));
                String imageUrl3 = cursor.getString(cursor.getColumnIndex(FavDB.ITEM_IMAGE3));
                Double price = cursor.getDouble(cursor.getColumnIndex(FavDB.ITEM_PRICE));
                String description = cursor.getString(cursor.getColumnIndex(FavDB.ITEM_DESCRIPTION));

                favoriteItems.add(new PopularDomain(id, title, imageUrl1, imageUrl2, imageUrl3, price, description));
            } while (cursor.moveToNext());
            cursor.close();
        }
        return favoriteItems;
    }
}
