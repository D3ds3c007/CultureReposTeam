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


@Document(collection="PendingField")
public class PendingField {
    
    private Owner owner;

    @Basic
    private String hashcode;

    @Basic
    private String description;
    
    @Basic
    private String location;

    @Basic
    private double area;

    public PendingField(){

    }

    public PendingField(Owner owner, String hashcode, String description, String location, double area){
        this.owner = owner;
        this.hashcode = hashcode;
        this.description = description;
        this.location = location;
        this.area = area;
    }

    public String getHashcode() {
        return hashcode;
    }

    public void setHashcode(String hashcode) {
        this.hashcode = hashcode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}