package com.example.stylemirror_1_1.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stylemirror_1_1.Activity.DetailActivity;
import com.example.stylemirror_1_1.databinding.ViewholderSearchListBinding;
import com.example.stylemirror_1_1.domain.PopularDomain;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {
    private List<PopularDomain> mList;
    private Context context;
    public SearchAdapter(List<PopularDomain> mList, Context context) {
        this.mList = mList;
        this.context=context;
    }

    public void setFilteredList(List<PopularDomain> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewholderSearchListBinding binding = ViewholderSearchListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PopularDomain data = mList.get(position);
        holder.binding.title.setText(formatTitle(data.getTitle()));
        holder.binding.image.setImageResource(Integer.parseInt(data.getPicUrl1()));

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("object", mList.get(position));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
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
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ViewholderSearchListBinding binding;
        ViewHolder(ViewholderSearchListBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}

