package com.culture.API.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.culture.API.Models.Field;
import com.culture.API.Models.MongodbEntity.Notification;
import com.culture.API.Repository.NotificationRepository;
import com.culture.API.Utils.HashGenerator;

@RestController
@RequestMapping("/api")
public class NotificationController {
    
    @Autowired
    private final NotificationRepository repository;

    @Autowired
    private final FieldRepository fieldrepository;


    @GetMapping("/notifications")
    public  ResponseEntity<List<Notification>> getAllNotification() {
        try {
            List<Notification> notifs = Notification.findAll(repository); 
            return new ResponseEntity<>(notifs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/notification")
    public  ResponseEntity<Notification> insertNotif(@RequestBody Notification notif) {

        String hashcode = HashGenerator.generateCode();
        notif.setHashcode(hashcode);

        try {
            Notification n = repository.save(notif);
            return new ResponseEntity<>(n, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
