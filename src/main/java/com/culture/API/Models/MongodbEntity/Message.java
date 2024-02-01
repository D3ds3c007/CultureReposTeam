package com.culture.API.Models.MongodbEntity;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Basic;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Document(collection="Messages")
public class Message {
    @Basic
    private int idSender;

    @Basic
    private int idReceiver;

    @Basic
    private String body;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;


    
    public Message(int idSender, int idReceiver, String body, Date date) {
        this.idSender = idSender;
        this.idReceiver = idReceiver;
        this.body = body;
        this.date = date;
    }

    public int getIdSender() {
        return idSender;
    }

    public void setIdSender(int idSender) {
        this.idSender = idSender;
    }

    public int getIdReceiver() {
        return idReceiver;
    }

    public void setIdReceiver(int idReceiver) {
        this.idReceiver = idReceiver;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    

    
}
