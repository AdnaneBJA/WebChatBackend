package com.webchatbackend.WebChatBackend.websocket.controller;

import com.webchatbackend.WebChatBackend.websocket.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller

public class MessageController {
    @MessageMapping("/hello/message")
    @SendTo("/topic/message")
    public Message message(Message message) {
        System.out.println("Received Message: " + message);
        return new Message(message.getMessage());
    }
}
