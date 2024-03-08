package com.example.stylemirror_1_1.Adapter;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.example.stylemirror_1_1.Helper.FavDB;
import com.example.stylemirror_1_1.databinding.ViewholderShoesListBinding;
import com.example.stylemirror_1_1.domain.PopularDomain;
import com.example.stylemirror_1_1.R;
import com.example.stylemirror_1_1.Activity.DetailActivity;

import java.util.ArrayList;
import java.util.List;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.Viewholder>{
    private ArrayList<PopularDomain> items;
    private Context context;
    private FavDB favDB;

    public PopularAdapter(ArrayList<PopularDomain> items, Context context) {
        this.items = items;
        this.context = context;
        this.favDB = new FavDB(context);
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewholderShoesListBinding binding = ViewholderShoesListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new Viewholder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        PopularDomain item = items.get(position);

        holder.binding.titleTxt.setText(formatTitle(item.getTitle()));
        holder.binding.feeTxt.setText("" + item.getPrice());

        String description = items.get(position).getDescription();
        String des = description.length() > 38 ? description.substring(0,20) + "\n" + description.substring(20,38) : description;
        holder.binding.descriptionTxt.setText(des + "...");

        int drawableResourced = holder.itemView.getResources().getIdentifier(items.get(position).getPicUrl1()
                , "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(context)
                .load(drawableResourced)
                .transform(new GranularRoundedCorners(30, 30, 0, 0))
                .into(holder.binding.pic);

        holder.binding.favBtn.setImageResource(favDB.checkFavoriteStatus(item.getId()) ? R.drawable.ic_bookmark_filled : R.drawable.ic_bookmark);

        holder.binding.favBtn.setOnClickListener(v -> {
            boolean isFavorite = favDB.checkFavoriteStatus(item.getId());
            if (isFavorite) {
                favDB.remove_fav(item.getId());
                Toast.makeText(context, item.getTitle() +" Removed from Favorites.", Toast.LENGTH_SHORT).show();
            } else {
                favDB.insertIntoTheDatabase(item.getTitle(), item.getPicUrl1(), item.getPicUrl2(), item.getPicUrl3(), item.getPrice(), item.getDescription(), item.getId(), "1");
                Toast.makeText(context, item.getTitle()+" Added to Favorites.", Toast.LENGTH_SHORT).show();
            }
            holder.binding.favBtn.setImageResource(isFavorite ? R.drawable.ic_bookmark : R.drawable.ic_bookmark_filled);
        });

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context,DetailActivity.class);
            intent.putExtra("object", items.get(position));
            Toast.makeText(context, items.get(position).getTitle(), Toast.LENGTH_SHORT).show();
            context.startActivity(intent);
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

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class Viewholder extends RecyclerView.ViewHolder {
        ViewholderShoesListBinding binding;

        Viewholder(ViewholderShoesListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

