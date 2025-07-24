//package com.goldenegg.oaklandsinterns.chat;
//
//import com.google.firebase.Timestamp;
//
//public class Message {
//    private String content;
//    private boolean isUserMessage;
//    private Timestamp timestamp; // Add this line
//
//    public Message() {
//        // Empty constructor for Firestore
//    }
//
//    public Message(String content, boolean isUserMessage) {
//        this.content = content;
//        this.isUserMessage = isUserMessage;
//    }
//
//    // Getters and setters
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public boolean isUserMessage() {
//        return isUserMessage;
//    }
//
//    public void setUserMessage(boolean userMessage) {
//        isUserMessage = userMessage;
//    }
//
//    public Timestamp getTimestamp() { // Getter
//        return timestamp;
//    }
//
//    public void setTimestamp(Timestamp timestamp) {
//        this.timestamp = timestamp;
//    }
//
//}