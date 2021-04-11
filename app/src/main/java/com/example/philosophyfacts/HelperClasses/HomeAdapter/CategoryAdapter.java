package com.example.philosophyfacts.HelperClasses.HomeAdapter;

import android.content.Context;
import android.content.res.Resources;
import android.media.Image;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.philosophyfacts.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    ArrayList<CategoryHelperClass> categoryLocations;

    public CategoryAdapter(ArrayList<CategoryHelperClass> categoryLocations) {
        this.categoryLocations = categoryLocations;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_card_design, parent, false);
        CategoryViewHolder categoryViewHolder = new CategoryViewHolder(view);

        return categoryViewHolder;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        CategoryHelperClass categoryHelperClass = categoryLocations.get(position);
        holder.image.setImageResource(categoryHelperClass.getImage());
        holder.title.setText(categoryHelperClass.getTitle());
        View itemView = holder.itemView;
        RelativeLayout relativeLayout = itemView.findViewById(R.id.relative_recycler);

        if (categoryHelperClass.getTitle().contains("Mc Donalds")) {
            relativeLayout.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.card_2));
        } else if (categoryHelperClass.getTitle().contains("New York")) {
            relativeLayout.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.card_1));
        } else {
            relativeLayout.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.card_3));
        }
    }

    @Override
    public int getItemCount() {
        return categoryLocations.size();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.category_image);
            title = itemView.findViewById(R.id.category_title);
        }
    }
}
