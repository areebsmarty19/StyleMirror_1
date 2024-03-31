package com.example.stylemirror_1_1.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.example.stylemirror_1_1.Helper.ChangeNumberItemsListener;
import com.example.stylemirror_1_1.Helper.ManagmentCart;
import com.example.stylemirror_1_1.databinding.ViewholderCartBinding;
import com.example.stylemirror_1_1.domain.PopularDomain;
import com.example.stylemirror_1_1.Activity.CartActivity;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.Viewholder> {
    ArrayList<PopularDomain> items;
    Context context;
    ViewholderCartBinding binding;
    ChangeNumberItemsListener changeNumberItemsListener;
    ManagmentCart managmentCart;


    public CartAdapter(ArrayList<PopularDomain> items,Context context, ChangeNumberItemsListener changeNumberItemsListener) {
        this.items = items;
        managmentCart = new ManagmentCart(context);
        this.changeNumberItemsListener = changeNumberItemsListener;
    }

    @NonNull
    @Override
    public CartAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ViewholderCartBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        context = parent.getContext();

        return new Viewholder(binding);
    }

    @Override
    public void onBindViewHolder(CartAdapter.Viewholder holder, @SuppressLint("RecyclerView") int position) {
        binding.titleTxt.setText(formatTitle(items.get(position).getTitle()));
        binding.totalEachItem.setText("₹" + items.get(position).getPrice());

        int drawableResourced = holder.itemView.getResources().getIdentifier(items.get(position).getPicUrl1()
                , "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(context)
                .load(drawableResourced)
                .transform(new GranularRoundedCorners(30, 30, 0, 0))
                .into(binding.pic);


        binding.removeItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(context)
                        .setTitle("Remove Item")
                        .setMessage("Are you sure you want to remove this item from the cart?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Call removeItem from ManagmentCart
                                managmentCart.removeItem(position, () -> {
                                // Notify activity to recalculate cart
                                changeNumberItemsListener.change();
                                if (managmentCart.getListCart().size() >= 0 ){
                                    Intent intent = new Intent(context,CartActivity.class);
                                    context.startActivity(intent);
                                    ((Activity) context).finish();
                                }
                                });
                                // Dismiss the dialog
                                dialog.dismiss();
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
            }
        });


        binding.buyItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = items.get(position).getUrl();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        ViewholderCartBinding binding;
        public Viewholder(ViewholderCartBinding b) {
            super(b.getRoot());
            binding=b;
        }
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
