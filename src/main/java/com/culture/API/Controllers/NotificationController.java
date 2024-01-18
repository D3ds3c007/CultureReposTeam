package com.culture.API.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.culture.API.Models.MongodbEntity.Notification;
import com.culture.API.Repository.NotificationRepository;

@RestController
@RequestMapping("/api")
public class NotificationController {
    private final NotificationRepository repository;

    @Autowired
    public NotificationController(NotificationRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/notifications")
    public  ResponseEntity<List<Notification>> getAllNotification() {
        List<Notification> notifs = repository.findAll(); 
        System.out.println(notifs.size() + "qdsqflkgfhsfdkjqdhgsdfhkdhdsfkdsj");
        System.out.println(notifs.get(0).getName());
        return new ResponseEntity<>(notifs, HttpStatus.OK);

    }

    @PostMapping("/notification")
    public  ResponseEntity<Notification> insertNotif() {
        Notification notification = new Notification(2, "Hello");
        Notification n = repository.save(notification);
        return new ResponseEntity<>(n, HttpStatus.OK);

    }

}
