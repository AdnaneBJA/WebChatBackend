package com.webchatbackend.WebChatBackend.websocket.model;

import java.util.Arrays;
import java.util.Date;

public class Message {
    private String message;
    private int senderID;
    private String time;
    private String username;
    private String imageURL;

    public Message() {

    }

    public Message(String message, int senderID, String time, String username, String imageURL) {
        this.message = message;
        this.senderID = senderID;
        this.time = time;
        this.username = username;
        this.imageURL = imageURL;
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


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                ", senderID=" + senderID +
                ", time='" + time + '\'' +
                ", username='" + username + '\'' +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }
}
