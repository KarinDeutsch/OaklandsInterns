package com.goldenegg.oaklandsinterns;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.goldenegg.oaklandsinterns.chat.Message;
import com.goldenegg.oaklandsinterns.chat.ChatAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ChatAdapter chatAdapter;
    private List<Message> messageList;
    private EditText editTextMessage;
    private Button buttonSend;

    private String chatId;
    private String chatType; // "general", "group", or "private"
    private DatabaseReference messagesRef;
    private String currentUserId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        recyclerView = findViewById(R.id.recyclerViewChat);
        editTextMessage = findViewById(R.id.editTextMessage);
        buttonSend = findViewById(R.id.buttonSend);

        chatId = getIntent().getStringExtra("chat_id");
        chatType = getIntent().getStringExtra("chat_type");

        currentUserId = FirebaseAuth.getInstance().getCurrentUser().getUid();

        messageList = new ArrayList<>();
        chatAdapter = new ChatAdapter(messageList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(chatAdapter);

        messagesRef = FirebaseDatabase.getInstance().getReference("chats").child(chatId).child("messages");

        loadMessages();

        buttonSend.setOnClickListener(v -> sendMessage());
    }

    private void loadMessages() {
        messagesRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                messageList.clear();
                for (DataSnapshot messageSnapshot : snapshot.getChildren()) {
                    Message message = messageSnapshot.getValue(Message.class);
                    if (message != null) {
                        messageList.add(message);
                    }
                }
                chatAdapter.notifyDataSetChanged();
                if (!messageList.isEmpty()) {
                    recyclerView.scrollToPosition(messageList.size() - 1);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(ChatActivity.this, "Failed to load messages.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void sendMessage() {
        String content = editTextMessage.getText().toString().trim();
        if (content.isEmpty()) {
            Toast.makeText(this, "Please enter a message.", Toast.LENGTH_SHORT).show();
            return;
        }

        if ("private".equals(chatType)) {
            // For private chat, find other participant async, then send message with receiver set
            getOtherParticipantId(otherUserId -> {
                if (otherUserId == null) {
                    Toast.makeText(ChatActivity.this, "Error: Could not find chat recipient.", Toast.LENGTH_SHORT).show();
                    return;
                }
                sendMessageToFirebase(content, otherUserId);
            });
        } else {
            // For group/general chats, no receiver needed
            sendMessageToFirebase(content, null);
        }
    }

    private void sendMessageToFirebase(String content, String receiverId) {
        Message message = new Message(currentUserId, receiverId, content, System.currentTimeMillis());

        messagesRef.push().setValue(message)
                .addOnSuccessListener(aVoid -> {
                    editTextMessage.setText("");
                    recyclerView.scrollToPosition(messageList.size() - 1);
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(ChatActivity.this, "Failed to send message.", Toast.LENGTH_SHORT).show();
                });
    }

    // Callback interface for async fetching of other participant ID
    public interface ParticipantCallback {
        void onCallback(String otherUserId);
    }

    // Async method to get the other participant's user ID in a private chat
    private void getOtherParticipantId(ParticipantCallback callback) {
        DatabaseReference participantsRef = FirebaseDatabase.getInstance()
                .getReference("chats").child(chatId).child("participants");

        participantsRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot participant : snapshot.getChildren()) {
                    String uid = participant.getKey();
                    if (uid != null && !uid.equals(currentUserId)) {
                        callback.onCallback(uid);
                        return; // found other participant
                    }
                }
                callback.onCallback(null); // no other participant found
            }

            @Override
            public void onCancelled(DatabaseError error) {
                callback.onCallback(null); // error case
            }
        });
    }
}
