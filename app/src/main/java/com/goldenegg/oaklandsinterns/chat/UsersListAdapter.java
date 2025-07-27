package com.goldenegg.oaklandsinterns.chat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.goldenegg.oaklandsinterns.R;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UsersListAdapter extends RecyclerView.Adapter<UsersListAdapter.UserViewHolder>{

    private List<User> userList;
    private Set<String> selectedUserIds = new HashSet<>();

    public UsersListAdapter(List<User> userList) {
        this.userList = userList;
    }

    public Set<String> getSelectedUserIds() {
        return selectedUserIds;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user_select, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = userList.get(position);
        holder.usernameText.setText(user.getUsername());
        holder.checkbox.setChecked(selectedUserIds.contains(user.getUserId()));

        holder.itemView.setOnClickListener(v -> {
            if (selectedUserIds.contains(user.getUserId())) {
                selectedUserIds.remove(user.getUserId());
                holder.checkbox.setChecked(false);
            } else {
                selectedUserIds.add(user.getUserId());
                holder.checkbox.setChecked(true);
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView usernameText;
        CheckBox checkbox;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            usernameText = itemView.findViewById(R.id.user_name);
            checkbox = itemView.findViewById(R.id.checkbox);
        }
    }
}
