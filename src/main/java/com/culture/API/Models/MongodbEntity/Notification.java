package com.culture.API.Models.MongodbEntity;

import java.sql.Timestamp;
import java.sql.SQLException;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.culture.API.Models.Field;
import com.culture.API.Models.Owner;
import com.culture.API.Repository.NotificationRepository;

import jakarta.persistence.Basic;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Document(collection="Notification")
public class Notification {
    @Id
    private int id;

    @Basic
    private int idSender;

    @Basic
    private String hashcode;

    @Basic
    private double longitude;

    @Basic
    private double latitude;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp date;

    public Notification(int id, int idSender, double longitude, double latitude, Timestamp date) {
        this.id = id;
        this.idSender = idSender;
        this.longitude = longitude;
        this.latitude = latitude;
        this.date = date;
    }
    public Notification() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSender() {
        return idSender;
    }

    public void setIdSender(int idSender) {
        this.idSender = idSender;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
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

    public static Field validate(NotificationRepository repository, FieldRepository fieldRepository, OwnerRepository ownerRepository, int id){
        Notification notif = repository.findById(id);
        Field f = new Field();
        f.setLatitude(notif.getLatitude());
        f.setLongitude(notif.getLongitude());
        f.setOwner(OwnerRepository.findByidOwner(notif.getIdSender()));
        f.setHashcode(notif.getHashcode());

        Field f2 = Field.saveField(f, fieldRepository);
        return f2;
    }
    
}
