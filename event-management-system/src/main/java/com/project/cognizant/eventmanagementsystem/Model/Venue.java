package com.project.cognizant.eventmanagementsystem.Model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Venue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int venueId;
    private String venueName;
    private String ownerName;
    private long ownerNumber;
    private String venueType;
    private double venuePrice;
    private String city;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Event> event;

    public int getVenueId() {
        return venueId;
    }

    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public long getOwnerNumber() {
        return ownerNumber;
    }

    public void setOwnerNumber(long ownerNumber) {
        this.ownerNumber = ownerNumber;
    }

    public String getVenueType() {
        return venueType;
    }

    public void setVenueType(String venueType) {
        this.venueType = venueType;
    }

    public double getVenuePrice() {
        return venuePrice;
    }

    public void setVenuePrice(double venuePrice) {
        this.venuePrice = venuePrice;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Event> getEvent() {
        return event;
    }

    public void setEvent(List<Event> event) {
        this.event = event;
    }
}