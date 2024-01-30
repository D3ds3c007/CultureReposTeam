package com.culture.API.Models.MongodbEntity;

import java.util.Date;
import java.sql.SQLException;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.culture.API.Models.Field;
import com.culture.API.Repository.FieldRepository;
import com.culture.API.Repository.NotificationRepository;
import com.culture.API.Repository.OwnerRepository;

import jakarta.persistence.Basic;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import com.culture.API.Models;


@Document(collection="Notification")
public class Notification {
    
    private Owner owner;

    @Basic
    private String hashcode;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public Notification(Owner owner, String hashcode, Date date) {
        this.owner = owner;
        this.hashcode = hashcode;
        this.date = date;
    }
    public Notification() {
        
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHashcode() {
        return hashcode;
    }

    public void setHashcode(String hashcode) {
        this.hashcode = hashcode;
    }
    
    public static List<Notification> findAll(NotificationRepository repository) throws SQLException {
        List<Notification> listNotif = repository.findAll();
        return listNotif;
    }

    public static Notification save(Notification notif, NotificationRepository repository) throws SQLException {
        Notification n = repository.save(notif);
        return n;
    }

    public static Notification findById(String hashcode, NotificationRepository repository)
    {
        return repository.findByHashcode(hashcode);
    }

    public static Field validate(NotificationRepository repository, FieldRepository fieldRepository, OwnerRepository ownerRepository, String hashcode){
        Notification notif = repository.findByHashcode(hashcode);

        Field f = new Field();
            f.setOwner(ownerRepository.findByidOwner(notif.getIdSender()));
            f.setHashcode(notif.getHashcode());

        try {
            Field f2 = Field.saveField(f, fieldRepository);
            repository.deleteByHashcode(notif.getHashcode());
            return f2;
        } catch (Exception e) {
            return null;
        }
        
    }

    public static void refuse(NotificationRepository repository, String hashcode){
        try {
            repository.deleteByHashcode(hashcode);
        } catch (Exception e) {

        }
    }
    
}
