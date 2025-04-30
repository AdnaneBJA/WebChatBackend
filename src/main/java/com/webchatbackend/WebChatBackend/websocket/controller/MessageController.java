package com.webchatbackend.WebChatBackend.websocket.controller;

import com.webchatbackend.WebChatBackend.websocket.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;

@Controller

public class MessageController {
    ArrayList<Message> arrayList = new ArrayList<>();

    @MessageMapping("/message")
    @SendTo("/topic/message")
    public ArrayList<Message> message(Message message) {
        arrayList.add(message);
        System.out.println(arrayList);
        System.out.println("Received Message: " + message);
        return arrayList;
    }
}
