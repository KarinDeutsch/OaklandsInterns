package com.goldenegg.oaklandsinterns.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.goldenegg.oaklandsinterns.R;
import com.goldenegg.oaklandsinterns.plant_knowledge.PlantCategory;

import java.util.List;

public class PlantCategoryAdapter extends RecyclerView.Adapter<PlantCategoryAdapter.CategoryViewHolder> {

    private final List<PlantCategory> categoryList;
    private final Context context;
    private OnItemClickListener listener; // For handling clicks

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public PlantCategoryAdapter(Context context, List<PlantCategory> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_category_item, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        PlantCategory currentItem = categoryList.get(position);

        holder.imageViewCategory.setImageResource(currentItem.getImageResourceId());
        holder.textViewCategoryTitle.setText(currentItem.getTitle());
        holder.textViewCategoryShortDescription.setText(currentItem.getShortDescription());
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageViewCategory;
        public TextView textViewCategoryTitle;
        public TextView textViewCategoryShortDescription;
        public CardView cardCategory;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewCategory = itemView.findViewById(R.id.imageViewCategory);
            textViewCategoryTitle = itemView.findViewById(R.id.textViewCategoryTitle);
            textViewCategoryShortDescription = itemView.findViewById(R.id.textViewCategoryShortDescription);
            cardCategory = itemView.findViewById(R.id.cardCategory);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}