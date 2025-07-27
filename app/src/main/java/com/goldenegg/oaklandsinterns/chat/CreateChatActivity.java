package com.goldenegg.oaklandsinterns.chat;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.goldenegg.oaklandsinterns.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CreateChatActivity extends AppCompatActivity {

    private EditText editTextChatName;
    private RecyclerView recyclerViewUsers;
    private Button buttonCreate, buttonCancel;

    private List<User> usersList = new ArrayList<>();
    private UsersListAdapter usersListAdapter;  // FIXED: Use UsersListAdapter, not ChatsListAdapter

    private DatabaseReference usersRef;
    private DatabaseReference chatsRef;

    private String currentUserId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_chat);

        editTextChatName = findViewById(R.id.editTextChatName);
        recyclerViewUsers = findViewById(R.id.recyclerViewUsers);
        buttonCreate = findViewById(R.id.buttonCreate);
        buttonCancel = findViewById(R.id.buttonCancel);

        recyclerViewUsers.setLayoutManager(new LinearLayoutManager(this));
        usersListAdapter = new UsersListAdapter(usersList);  // FIXED: instantiate UsersListAdapter
        recyclerViewUsers.setAdapter(usersListAdapter);

        usersRef = FirebaseDatabase.getInstance().getReference("users");
        chatsRef = FirebaseDatabase.getInstance().getReference("chats");

        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            currentUserId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        } else {
            Toast.makeText(this, "User not authenticated", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        loadUsers();

        buttonCreate.setOnClickListener(v -> createChat());
        buttonCancel.setOnClickListener(v -> finish());
    }

    private void loadUsers() {
        usersRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                usersList.clear();
                for (DataSnapshot userSnapshot : snapshot.getChildren()) {
                    User user = userSnapshot.getValue(User.class);
                    if (user != null && !user.getUserId().equals(currentUserId)) {
                        usersList.add(user);
                    }
                }
                usersListAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(CreateChatActivity.this, "Failed to load users", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void createChat() {
        Set<String> selectedUserIds = usersListAdapter.getSelectedUserIds();

        if (selectedUserIds.isEmpty()) {
            Toast.makeText(this, "Select at least one user", Toast.LENGTH_SHORT).show();
            return;
        }

        // Add current user to participants
        selectedUserIds.add(currentUserId);

        String chatName = editTextChatName.getText().toString().trim();

        Chat.ChatType chatType = selectedUserIds.size() == 1 ? Chat.ChatType.PRIVATE : Chat.ChatType.GROUP;

        if (chatType == Chat.ChatType.GROUP && chatName.isEmpty()) {
            Toast.makeText(this, "Please enter a group name", Toast.LENGTH_SHORT).show();
            return;
        }

        String chatId;
        if (chatType == Chat.ChatType.PRIVATE) {
            List<String> sortedIds = new ArrayList<>(selectedUserIds);
            Collections.sort(sortedIds);
            chatId = "private_" + TextUtils.join("_", sortedIds);
        } else {
            chatId = chatsRef.push().getKey();
        }

        if (chatId == null) {
            Toast.makeText(this, "Error creating chat", Toast.LENGTH_SHORT).show();
            return;
        }

        // IMPORTANT: Your Chat class expects List<String> for participants,
        // but you currently have a Set<String>. So convert it to List<String>:
        List<String> participantsList = new ArrayList<>(selectedUserIds);

        Chat newChat = new Chat(chatId, chatType, participantsList, chatType == Chat.ChatType.GROUP ? chatName : null);
        newChat.setTimestamp(System.currentTimeMillis());
        newChat.setLastMessage(""); // Initialize lastMessage empty

        chatsRef.child(chatId).setValue(newChat)
                .addOnSuccessListener(aVoid -> {
                    Toast.makeText(this, "Chat created", Toast.LENGTH_SHORT).show();
                    finish();
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(this, "Failed to create chat: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                });
    }
}
