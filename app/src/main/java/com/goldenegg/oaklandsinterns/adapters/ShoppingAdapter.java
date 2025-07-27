package com.goldenegg.oaklandsinterns.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.goldenegg.oaklandsinterns.R;
import com.goldenegg.oaklandsinterns.models.ShoppingPlace;

import java.util.ArrayList;
import java.util.List;

public class ShoppingAdapter extends RecyclerView.Adapter<ShoppingAdapter.ShoppingViewHolder> {
    private List<ShoppingPlace> shoppingPlaces;
    private final double baseLat;
    private final double baseLon;

    // Constructor that accepts base coordinates and ensures shoppingPlaces is never null
    public ShoppingAdapter(List<ShoppingPlace> shoppingPlaces, double baseLat, double baseLon) {
        this.shoppingPlaces = shoppingPlaces != null ? shoppingPlaces : new ArrayList<>();  // Ensure the list is not null
        this.baseLat = baseLat;
        this.baseLon = baseLon;
    }

    @Override
    public ShoppingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shopping_item, parent, false);
        return new ShoppingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ShoppingViewHolder holder, int position) {
        ShoppingPlace shoppingPlace = shoppingPlaces.get(position);
        holder.nameTextView.setText(shoppingPlace.getName());
        holder.categoryTextView.setText(shoppingPlace.getCategory());
        holder.addressTextView.setText(shoppingPlace.getAddress());
        holder.phoneTextView.setText(shoppingPlace.getPhone());
        holder.websiteTextView.setText(shoppingPlace.getWebsite());

        // Get distance in meters and display it
        double distanceInMeters = shoppingPlace.getDistanceInMeters(baseLat, baseLon);
        holder.distanceTextView.setText(String.format("Distance: %.2f meters", distanceInMeters));

        // Apply fade-in animation when an item is bound
        holder.itemView.setAlpha(0f);  // Start with the item hidden
        holder.itemView.animate().alpha(1f).setDuration(500); // Fade in over 500 ms
    }

    @Override
    public int getItemCount() {
        return shoppingPlaces.size();
    }

    public static class ShoppingViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, categoryTextView, addressTextView, phoneTextView, websiteTextView, distanceTextView;

        public ShoppingViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            categoryTextView = itemView.findViewById(R.id.categoryTextView);
            addressTextView = itemView.findViewById(R.id.addressTextView);
            phoneTextView = itemView.findViewById(R.id.phoneTextView);
            websiteTextView = itemView.findViewById(R.id.websiteTextView);
            distanceTextView = itemView.findViewById(R.id.distanceTextView);
        }
    }

    // Method to update the list dynamically
    public void updateList(List<ShoppingPlace> newList) {
        this.shoppingPlaces = newList != null ? newList : new ArrayList<>();
        notifyDataSetChanged();
    }
}