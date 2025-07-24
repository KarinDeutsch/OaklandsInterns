//package com.goldenegg.oaklandsinterns.chat;
//
//import android.graphics.Color;
//import android.os.Message;
//import android.view.Gravity;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.goldenegg.oaklandsinterns.R;
//
//import java.util.List;
//
//public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {
//    private List<Message> messageList;
//
//    public ChatAdapter(List<Message> messageList) {
//        this.messageList = messageList;
//    }
//
//    @NonNull
//    @Override
//    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.item_chat_message, parent, false);
//        return new ChatViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {
//        Message message = messageList.get(position);
//        holder.bind(message);
//    }
//
//    @Override
//    public int getItemCount() {
//        return messageList.size();
//    }
//
//    class ChatViewHolder extends RecyclerView.ViewHolder {
//        TextView textView;
//
//        ChatViewHolder(@NonNull View itemView) {
//            super(itemView);
//            textView = itemView.findViewById(R.id.textViewMessage);
//        }
//
//        void bind(Message message) {
//            textView.setText(message.getContent());
//            if (message.isUserMessage()) {
//                textView.setBackgroundColor(Color.parseColor("#DCF8C6")); // green bubble
//                textView.setGravity(Gravity.END);
//            } else {
//                textView.setBackgroundColor(Color.WHITE);
//                textView.setGravity(Gravity.START);
//            }
//        }
//    }
//}