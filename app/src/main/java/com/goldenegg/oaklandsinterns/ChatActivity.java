//package com.goldenegg.oaklandsinterns;
//
//import android.os.Bundle;
//import android.view.View;
//import android.view.inputmethod.InputMethodManager;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import java.util.Random;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.goldenegg.oaklandsinterns.R;
//import com.goldenegg.oaklandsinterns.chat.ChatAdapter;
//import com.goldenegg.oaklandsinterns.chat.Message;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import com.google.firebase.Timestamp;
//import com.google.firebase.firestore.DocumentSnapshot;
//import com.google.firebase.firestore.FirebaseFirestore;
//import com.google.firebase.firestore.CollectionReference;
//import com.google.firebase.firestore.DocumentReference;
//import com.google.firebase.firestore.FieldValue;
//
//public class ChatActivity extends AppCompatActivity {
//
//    private RecyclerView recyclerViewChat;
//    private EditText editTextMessage;
//    private Button buttonSend;
//    private ChatAdapter chatAdapter;
//    private List<Message> messageList = new ArrayList<>();
//
//    // Firestore instance
//    private FirebaseFirestore firestore = FirebaseFirestore.getInstance();
//    private CollectionReference messagesRef = firestore.collection("messages");
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_chat);
//
//        recyclerViewChat = findViewById(R.id.recyclerViewChat);
//        editTextMessage = findViewById(R.id.editTextMessage);
//        buttonSend = findViewById(R.id.buttonSend);
//
//        chatAdapter = new ChatAdapter(messageList);
//        recyclerViewChat.setLayoutManager(new LinearLayoutManager(this));
//        recyclerViewChat.setAdapter(chatAdapter);
//
////        buttonSend.setOnClickListener(v -> sendMessage());
//
//        recyclerViewChat.scrollToPosition(messageList.size() - 1);
//    }
//
//    String[] autoReplies = {
//            "That's interesting!",
//            "Can you tell me more?",
//            "Nice one!",
//            "Let's keep going!",
//            "I didn't expect that!"
//    };
//
//    private void sendMessage() {
//        String message = editTextMessage.getText().toString().trim();
//        if (!message.isEmpty()) {
//            // Add message to Firestore
//            sendMessageToFirestore(message, "user");
//
//            // Simulate system reply (optional)
//            String reply = autoReplies[new Random().nextInt(autoReplies.length)];
//            recyclerViewChat.postDelayed(() -> {
//                sendMessageToFirestore(reply, "system");
//            }, 500);
//
//            editTextMessage.setText("");  // Clear input field
//            hideKeyboard();
//        } else {
//            Toast.makeText(this, "Please enter a message.", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    private void sendMessageToFirestore(String message, String sender) {
//        // Create a new message object
//        Message messageObj = new Message(message, sender.equals("user"));
//
//        // Add timestamp field
//        messageObj.setTimestamp(Timestamp.now());
//
//        // Add the message to Firestore
//        messagesRef.add(messageObj)
//                .addOnSuccessListener(documentReference -> {
//                    messageList.add(messageObj);
//                    chatAdapter.notifyItemInserted(messageList.size() - 1);
//                    recyclerViewChat.scrollToPosition(messageList.size() - 1);
//                })
//                .addOnFailureListener(e -> {
//                    Toast.makeText(ChatActivity.this, "Failed to send message.", Toast.LENGTH_SHORT).show();
//                });
//    }
//
//    private void hideKeyboard() {
//        View view = this.getCurrentFocus();
//        if (view != null) {
//            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
//            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
//        }
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        messagesRef.orderBy("timestamp")  // Order by timestamp if you want to display messages in order
//                .addSnapshotListener((snapshot, e) -> {
//                    if (e != null) {
//                        Toast.makeText(ChatActivity.this, "Error loading messages.", Toast.LENGTH_SHORT).show();
//                        return;
//                    }
//
//                    messageList.clear();
//                    for (DocumentSnapshot document : snapshot.getDocuments()) {
//                        Message message = document.toObject(Message.class);
//
//                        // Check for null timestamp and set it to current time if needed
//                        if (message.getTimestamp() == null) {
//                            message.setTimestamp(Timestamp.now()); // Set current timestamp if it's null
//                        }
//
//                        messageList.add(message);
//                    }
//                    chatAdapter.notifyDataSetChanged();
//                    recyclerViewChat.scrollToPosition(messageList.size() - 1);
//                });
//    }
//}