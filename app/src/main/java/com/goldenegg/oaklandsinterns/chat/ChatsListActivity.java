package com.goldenegg.oaklandsinterns.chat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.goldenegg.oaklandsinterns.ChatActivity;
import com.goldenegg.oaklandsinterns.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ChatsListActivity extends AppCompatActivity {

    private RecyclerView recyclerViewChats;
    private ChatsListAdapter adapter;
    private ArrayList<Chat> chatList;
    private DatabaseReference chatsRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chats_list);

        recyclerViewChats = findViewById(R.id.recyclerViewChats);
        recyclerViewChats.setLayoutManager(new LinearLayoutManager(this));

        chatList = new ArrayList<>();
        adapter = new ChatsListAdapter(chatList, chat -> {
            Intent intent = new Intent(ChatsListActivity.this, ChatActivity.class);
            intent.putExtra("chat_id", chat.getChatId());
            intent.putExtra("chat_type", chat.getChatType().toString().toLowerCase());
            startActivity(intent);
        });
        recyclerViewChats.setAdapter(adapter);


        FloatingActionButton fabAddChat = findViewById(R.id.fabAddChat);
        fabAddChat.setOnClickListener(v -> {
            Intent intent = new Intent(ChatsListActivity.this, CreateChatActivity.class);
            startActivity(intent);
        });

        chatsRef = FirebaseDatabase.getInstance().getReference("chats");

        loadChatsFromFirebase();
    }

    private void loadChatsFromFirebase() {
        String currentUserId = FirebaseAuth.getInstance().getCurrentUser().getUid();

        chatsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                chatList.clear();
                for (DataSnapshot chatSnapshot : snapshot.getChildren()) {
                    Chat chat = chatSnapshot.getValue(Chat.class);
                    if (chat != null) {
                        // FIXED: getParticipants() returns List<String> not Map
                        List<String> participants = chat.getParticipants();
                        if (participants != null && participants.contains(currentUserId)) {
                            chatList.add(chat);
                        }
                    }
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(ChatsListActivity.this, "Failed to load chats.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
