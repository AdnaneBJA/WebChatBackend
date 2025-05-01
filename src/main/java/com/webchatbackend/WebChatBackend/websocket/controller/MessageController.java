package com.webchatbackend.WebChatBackend.websocket.controller;

import com.webchatbackend.WebChatBackend.websocket.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


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

    @GetMapping("/messages")
    @ResponseBody
    public List<Message> retrieveAllMessages() {
        return arrayList;
    }
}
