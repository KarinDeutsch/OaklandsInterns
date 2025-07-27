package com.goldenegg.oaklandsinterns.chat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.goldenegg.oaklandsinterns.R;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_USER = 0;
    private static final int TYPE_ASSISTANT = 1;
    private static final int TYPE_SYSTEM = 2;

    private List<Message> messageList;

    public ChatAdapter(List<Message> messageList) {
        this.messageList = messageList;
    }

    @Override
    public int getItemViewType(int position) {
        Message message = messageList.get(position);
        switch (message.getType()) {
            case USER:
                return TYPE_USER;
            case ASSISTANT:
                return TYPE_ASSISTANT;
            case SYSTEM:
            default:
                return TYPE_SYSTEM;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (viewType == TYPE_USER) {
            View view = inflater.inflate(R.layout.item_user_message, parent, false);
            return new UserMessageViewHolder(view);
        } else if (viewType == TYPE_ASSISTANT) {
            View view = inflater.inflate(R.layout.item_chat_message, parent, false);
            return new AssistantMessageViewHolder(view);
        } else {
            View view = inflater.inflate(R.layout.item_system_message, parent, false);
            return new SystemMessageViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Message message = messageList.get(position);
        if (holder instanceof UserMessageViewHolder) {
            ((UserMessageViewHolder) holder).bind(message);
        } else if (holder instanceof AssistantMessageViewHolder) {
            ((AssistantMessageViewHolder) holder).bind(message);
        } else if (holder instanceof SystemMessageViewHolder) {
            ((SystemMessageViewHolder) holder).bind(message);
        }
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    static class UserMessageViewHolder extends RecyclerView.ViewHolder {
        private TextView userMessageText;

        public UserMessageViewHolder(@NonNull View itemView) {
            super(itemView);
            userMessageText = itemView.findViewById(R.id.text_user_message);
        }

        public void bind(Message message) {
            // FIXED: Use getMessage() instead of getContent()
            userMessageText.setText(message.getMessage());
        }
    }

    static class AssistantMessageViewHolder extends RecyclerView.ViewHolder {
        private TextView assistantMessageText;

        public AssistantMessageViewHolder(@NonNull View itemView) {
            super(itemView);
            assistantMessageText = itemView.findViewById(R.id.text_chat_message);
        }

        public void bind(Message message) {
            // FIXED: Use getMessage() instead of getContent()
            assistantMessageText.setText(message.getMessage());
        }
    }

    static class SystemMessageViewHolder extends RecyclerView.ViewHolder {
        private TextView systemMessageText;

        public SystemMessageViewHolder(@NonNull View itemView) {
            super(itemView);
            systemMessageText = itemView.findViewById(R.id.text_system_message);
        }

        public void bind(Message message) {
            // FIXED: Use getMessage() instead of getContent()
            systemMessageText.setText(message.getMessage());
        }
    }
}
