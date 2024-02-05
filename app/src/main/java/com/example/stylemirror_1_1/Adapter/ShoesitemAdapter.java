package com.example.stylemirror_1_1.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.stylemirror_1_1.databinding.ViewholderShoesListBinding;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.example.stylemirror_1_1.Activity.DetailActivity;
import com.example.stylemirror_1_1.domain.ShoesDomain;

import java.util.ArrayList;


public class ShoesitemAdapter extends RecyclerView.Adapter<ShoesitemAdapter.Viewholder> {
    ArrayList<ShoesDomain> items;
    Context context;
    ViewholderShoesListBinding binding;

    public ShoesitemAdapter(ArrayList<ShoesDomain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ShoesitemAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ViewholderShoesListBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false);
        context = parent.getContext();
        return new Viewholder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ShoesitemAdapter.Viewholder holder, int position) {
        binding.shoestitle.setText(items.get(position).getShoesTitle());
        binding.shoesprice.setText("$" + items.get(position).getShoesPrice());
        binding.shoesscore.setText("" + items.get(position).getShoesScore());
        binding.shoesreview.setText("" + items.get(position).getShoesReview());

        int drawableResourced = holder.itemView.getResources().getIdentifier(items.get(position).getShoesPicUrl()
                , "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(context)
                .load(drawableResourced)
                .transform(new GranularRoundedCorners(30, 30, 0, 0))
                .into(binding.shoespic);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("object2", items.get(position));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        public Viewholder(ViewholderShoesListBinding binding) {
            super(binding.getRoot());
        }
    }
}
