package com.culture.API.Controllers;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.culture.API.Models.Field;
import com.culture.API.Models.Owner;
import com.culture.API.Models.DTO.OwnerDTO;
import com.culture.API.Models.MongodbEntity.FieldLocalisation;
import com.culture.API.Models.MongodbEntity.Notification;
import com.culture.API.Models.MongodbEntity.PendingField;
import com.culture.API.Models.Request.AddFieldRequest;
import com.culture.API.Repository.FieldRepository;
import com.culture.API.Repository.NotificationRepository;
import com.culture.API.Repository.OwnerRepository;
import com.culture.API.Repository.PendingFieldRepository;
import com.culture.API.Repository.FieldLocalisationRepository;
import com.culture.API.Repository.FieldPicturesRepository;
import com.culture.API.Utils.HashGenerator;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin(origins = "*", methods= {RequestMethod.POST, RequestMethod.GET})
@RestController
@RequestMapping("/api")
public class NotificationController {
    @Autowired
    private NotificationRepository repository;

    @Autowired
    private FieldRepository fieldrepository;
    
    @Autowired
    private PendingFieldRepository pendingdRepository;

    @Autowired
    private FieldPicturesRepository picturesdRepository;

    @Autowired
    private FieldLocalisationRepository localisationdRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private FieldLocalisationRepository localisationRepository;

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
    public ResponseEntity<Notification> insertNotif(@RequestBody AddFieldRequest request) {

        String hashcode = HashGenerator.generateCode();

        System.out.println(request.getLocalisation().length);

        try {
        System.out.println(request.getLocalisation().length);
            Owner o = Owner.findOwnerById(1, ownerRepository);

            OwnerDTO oDto = new OwnerDTO(o.getIdOwner(), o.getName(), o.getEmail());

            PendingField p = new PendingField();
                p.setArea(request.getArea());
                p.setOwner(oDto);
                p.setDescription(request.getDescription());
                p.setLocation(request.getLocation());
                p.setHashcode(hashcode);
                pendingdRepository.save(p);


            for (int i = 0; i < request.getLocalisation().length; i++) {
                FieldLocalisation l = new FieldLocalisation();
                    l.setHashcode(hashcode);
                    l.setLatitude(request.getLocalisation()[i].getPosition().getLat());
                    l.setLongitude(request.getLocalisation()[i].getPosition().getLng());
                localisationdRepository.save(l);
            }

            Notification notify = new Notification();
              notify.setHashcode(hashcode);
              notify.setOwner(oDto);
              notify.setDate(new Timestamp(System.currentTimeMillis()));

             Notification n = Notification.save(notify, repository);
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/validate")
    public  ResponseEntity<Field> validateNotif(@RequestParam(value = "hashcode") String hashcode) {
        try {
            Field f = Notification.validate(ownerRepository,repository, fieldrepository, pendingdRepository, hashcode);
            return new ResponseEntity<>(f, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/refuse")
    public  ResponseEntity<Object> refuseNotif(@RequestParam(value = "hashcode") String hashcode) {
        try {
            Notification.refuse(repository, pendingdRepository, picturesdRepository, localisationdRepository, hashcode);
            return new ResponseEntity<>("Refused", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
