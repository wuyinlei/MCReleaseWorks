package com.mingchu.mcreleaseworks;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import me.drakeet.multitype.ItemViewProvider;

/**
 * Created by wuyinlei on 2017/3/7.
 */

public class CategoryItemViewProvider extends ItemViewProvider<Category, CategoryItemViewProvider.ViewHolder> {

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(
            @NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_category, parent, false);
        return new ViewHolder(view);
    }


    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull Category category) {
        holder.title.setText(category.title);
        holder.img.setImageResource(category.img);
    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        @NonNull
        private final TextView title;
        private final ImageView img;


        ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img);
            title = (TextView) itemView.findViewById(R.id.title);
        }
    }
}
