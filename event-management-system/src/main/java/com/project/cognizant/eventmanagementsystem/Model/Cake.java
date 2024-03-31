package com.project.cognizant.eventmanagementsystem.Model;

import java.util.List;
import jakarta.persistence.*;

@Entity
public class Cake {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cakeId;
    private String cakeName;
    private String cakeFlavour;
    private double cakePrice;
    //private double weight
    @OneToMany(cascade = CascadeType.ALL)
    private List<Event> event;
    @OneToMany(cascade = CascadeType.ALL)
    private List<PreDefineEvents> preDefineEvents;

    public int getCakeId() {
        return cakeId;
    }

    public void setCakeId(int cakeId) {
        this.cakeId = cakeId;
    }

    public String getCakeName() {
        return cakeName;
    }

    public void setCakeName(String cakeName) {
        this.cakeName = cakeName;
    }

    public String getCakeFlavour() {
        return cakeFlavour;
    }

    public void setCakeFlavour(String cakeFlavour) {
        this.cakeFlavour = cakeFlavour;
    }

    public double getCakePrice() {
        return cakePrice;
    }

    public void setCakePrice(double cakePrice) {
        this.cakePrice = cakePrice;
    }

    public List<Event> getEvent() {
        return event;
    }

    public void setEvent(List<Event> event) {
        this.event = event;
    }

    public List<PreDefineEvents> getPreDefineEvents() {
        return preDefineEvents;
    }

    public void setPreDefineEvents(List<PreDefineEvents> preDefineEvents) {
        this.preDefineEvents = preDefineEvents;
    }
}
