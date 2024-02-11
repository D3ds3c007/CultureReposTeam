package com.culture.API.Models.Request;


public class AddFieldRequest {
    private int idOwner;
    private double area;
    private String description;
    private String location;
    private int plotsNumber;
    private int groundType;
    private String[] pictures;
    private Location[] localisation;

    
    public AddFieldRequest() {
    }

    
    public int getIdOwner() {
        return idOwner;
    }


    public void setIdOwner(int idOwner) {
        this.idOwner = idOwner;
    }


    public AddFieldRequest(double area, String description, String location, int plotsNumber, int groundType,
            String[] pictures, Location[] localisation) {
        this.area = area;
        this.description = description;
        this.location = location;
        this.plotsNumber = plotsNumber;
        this.groundType = groundType;
        this.pictures = pictures;
        this.localisation = localisation;
    }
    public double getArea() {
        return area;
    }
    public void setArea(double area) {
        this.area = area;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public int getPlotsNumber() {
        return plotsNumber;
    }
    public void setPlotsNumber(int plotsNumber) {
        this.plotsNumber = plotsNumber;
    }
    public int getGroundType() {
        return groundType;
    }
    public void setGroundType(int groundType) {
        this.groundType = groundType;
    }
    public String[] getPictures() {
        return pictures;
    }
    public void setPictures(String[] pictures) {
        this.pictures = pictures;
    }
    public Location[] getLocalisation() {
        return localisation;
    }
    public void setLocalisation(Location[] localisation) {
        this.localisation = localisation;
    }

    
}
