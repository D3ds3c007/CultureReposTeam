package com.culture.API.Models;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.JoinColumnOrFormula;

import java.sql.Timestamp;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Simulation implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSimulation;

    @ManyToOne
    @JoinColumn(name="idPlot")
    private Plot plot;

    @ManyToOne
    @JoinColumn(name="idCulture")
    private Culture culture;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable=false)
    private Date dateSimulation;

    public int getIdSimulation() {
        return idSimulation;
    }

    public void setIdSimulation(int idSimulation) {
        this.idSimulation = idSimulation;
    }

    public Plot getPlot() {
        return plot;
    }

    public void setPlot(Plot plot) {
        this.plot = plot;
    }

    public Culture getCulture() {
        return this.culture;
    }

    public void setCulture(Culture culture) {
        this.culture = culture;
    }

    public Date getDateSimulation() {
        return dateSimulation;
    }

    public void setDateSimulation(Date dateSimulation) {
        this.dateSimulation = dateSimulation;
    }

    public Simulation(int idSimulation, Plot plot, Culture culture, Timestamp dateSimulation) {
        this.idSimulation = idSimulation;
        this.plot = plot;
        this.culture = culture;
        this.dateSimulation = dateSimulation;
    }

    public Simulation()
    {
        
    }
    
}
