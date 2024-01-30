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


@Document(collection="FieldPictures")
public class FieldPictures {
    
    @Basic
    private String hashcode;

    @Basic
    private double longitude;

    @Basic
    private double latitude;

    public FieldPictures(){

    }

    public FieldPictures(String hashcode, double longitude, double latitude){
        this.hashcode = hashcode;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getHashcode() {
        return hashcode;
    }

    public void setHashcode(String hashcode) {
        this.hashcode = hashcode;
    }
}