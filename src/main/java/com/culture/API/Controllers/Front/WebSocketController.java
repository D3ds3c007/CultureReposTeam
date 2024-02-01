package com.culture.API.Controllers.Front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.culture.API.Models.MongodbEntity.Message;
import com.culture.API.Repository.MessageRepository;

@RestController
@RequestMapping("/api")
public class WebSocketController {

    @Autowired
    private MessageRepository messageRepository;

    private final SimpMessagingTemplate messagingTemplate;

    public WebSocketController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public Message sendMessage(Message message)
    {
        //Save message to MongoDB
        //Your  MongoDB integreation logic here
        try {
            messageRepository.save(message);
        } catch (Exception e) {
            
        }
        return message;
    }

    @PostMapping("/message")
    public ResponseEntity<Message> sendRestMessage(@RequestBody Message message) {
        // Your logic for handling REST API messages
        // You can handle this similar to WebSocket messages
        
        // Here, you can send the message to the WebSocket topic
        Message m = null;
        try {
            m = messageRepository.save(message);
            messagingTemplate.convertAndSend("/topic/messages", m);
            return new ResponseEntity<>(m, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(m, HttpStatus.INTERNAL_SERVER_ERROR);

        }
        
    }
    
}
