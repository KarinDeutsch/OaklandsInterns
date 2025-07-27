package com.goldenegg.oaklandsinterns.chat;

import java.util.List;

public class Chat {

    public enum ChatType {
        GENERAL,
        GROUP,
        PRIVATE
    }

    private String chatId;
    private ChatType chatType;
    private List<String> participants; // List<String>
    private String name;
    private String lastMessage;
    private long timestamp;

    public Chat() {
        // Firebase needs empty constructor
    }

    public Chat(String chatId, ChatType chatType, List<String> participants, String name) {
        this.chatId = chatId;
        this.chatType = chatType;
        this.participants = participants;
        this.name = name;
        this.timestamp = System.currentTimeMillis();
    }

    // Getters and setters

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public ChatType getChatType() {
        return chatType;
    }

    public void setChatType(ChatType chatType) {
        this.chatType = chatType;
    }

    public List<String> getParticipants() {
        return participants;
    }

    public void setParticipants(List<String> participants) {
        this.participants = participants;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
