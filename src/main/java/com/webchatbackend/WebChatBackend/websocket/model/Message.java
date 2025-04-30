package com.webchatbackend.WebChatBackend.websocket.model;

import java.util.Date;

public class Message {
    private String message;
    private int senderID;
    private String time;

    public Message() {

    }

    public Message(String message, int senderID, String time) {
        this.message = message;
        this.senderID = senderID;
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getSenderID() {
        return senderID;
    }

    public void setSenderID(int senderID) {
        this.senderID = senderID;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                ", senderID=" + senderID +
                ", time=" + time +
                '}';
    }
}
