package com.goldenegg.oaklandsinterns.adapters;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.goldenegg.oaklandsinterns.R;
import com.goldenegg.oaklandsinterns.models.LocalNumberItem;

import java.util.List;

public class LocalNumberAdapter extends RecyclerView.Adapter<LocalNumberAdapter.ViewHolder> {

    private List<LocalNumberItem> data;

    public LocalNumberAdapter(List<LocalNumberItem> data) {
        this.data = data;
    }

    public void updateData(List<LocalNumberItem> newList) {
        this.data = newList;
        notifyDataSetChanged();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView type, name, address, phone;

        public ViewHolder(View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.card_icon);
            type = itemView.findViewById(R.id.card_type);
            name = itemView.findViewById(R.id.card_name);
            address = itemView.findViewById(R.id.card_address);
            phone = itemView.findViewById(R.id.card_phone);
        }

        public void bind(LocalNumberItem item) {
            icon.setImageResource(item.getIconRes());
            type.setText(item.getType());
            name.setText(item.getName());
            address.setText(item.getAddress());
            phone.setText(item.getPhone());

            address.setOnClickListener(v -> {
                String mapQuery = "geo:0,0?q=" + Uri.encode(item.getAddress());
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(mapQuery));
                intent.setPackage("com.google.android.apps.maps");

                if (intent.resolveActivity(v.getContext().getPackageManager()) != null) {
                    v.getContext().startActivity(intent);
                }
            });
        }

    }

    @NonNull
    @Override
    public LocalNumberAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_local_numbers, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LocalNumberAdapter.ViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}