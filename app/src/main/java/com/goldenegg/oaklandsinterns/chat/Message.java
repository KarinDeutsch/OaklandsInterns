package com.goldenegg.oaklandsinterns.chat;

public class Message {

    public enum MessageType {
        USER,
        ASSISTANT,
        SYSTEM
    }

    private String sender;
    private String receiver; // nullable for group/general chats
    private String message;
    private long timestamp;
    private MessageType type;

    public Message() {
        // Firebase needs empty constructor
    }

    public Message(String sender, String receiver, String message, long timestamp, MessageType type) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.timestamp = timestamp;
        this.type = type; // initialize message type
    }

    // Getters and setters

    public String getSender() { return sender; }
    public void setSender(String sender) { this.sender = sender; }

    public String getReceiver() { return receiver; }
    public void setReceiver(String receiver) { this.receiver = receiver; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public long getTimestamp() { return timestamp; }
    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }

    // Add getter and setter for type:

    public MessageType getType() { return type; }
    public void setType(MessageType type) { this.type = type; }
}
