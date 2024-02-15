package com.example.stylemirror_1_1.Adapter;

import android.content.Context;
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
    public void onBindViewHolder(CartAdapter.Viewholder holder, int position) {
        binding.titleTxt.setText(items.get(position).getTitle());
        binding.feeEachItem.setText("$" + items.get(position).getPrice());
        binding.totalEachItem.setText("$" + Math.round(items.get(position).getNumberInCart() * items.get(position).getPrice()));
        binding.numberItemTxt.setText(String.valueOf(items.get(position).getNumberInCart()));

        int drawableResourced = holder.itemView.getResources().getIdentifier(items.get(position).getPicUrl()
                , "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(context)
                .load(drawableResourced)
                .transform(new GranularRoundedCorners(30, 30, 0, 0))
                .into(binding.pic);

        binding.plusCartBtn.setOnClickListener(v -> managmentCart.plusNumberItem(items, position, () -> {
            changeNumberItemsListener.change();
            binding.numberItemTxt.setText(String.valueOf(items.get(position).getNumberInCart()));
            notifyItemChanged(position);
        }));

        binding.minusCartItem.setOnClickListener(v -> managmentCart.minusNumberItem(items, position, () -> {
            if (binding.numberItemTxt.getText().toString().equals("1")){
                binding.minusCartItem.setVisibility(View.INVISIBLE);
            }
            changeNumberItemsListener.change();
            binding.numberItemTxt.setText(String.valueOf(items.get(position).getNumberInCart()));
            notifyItemChanged(position);
        }));
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
}
