package com.project.cognizant.eventmanagementsystem.Model;

import jakarta.persistence.*;
import lombok.Getter;
import java.util.List;

@Entity
@Getter
public class Venue {

    @Id
    @GeneratedValue
    private int venueId;
    private String venueName;
    private String ownerName;
    private long ownerNumber;
    private String venueType;
    private double venuePrice;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Event> event;
    public Venue() {
    }

    public Venue(String venueName, String ownerName, long ownerNumber, String venueType, double venuePrice,
            Address address) {
        this.venueName = venueName;
        this.ownerName = ownerName;
        this.ownerNumber = ownerNumber;
        this.venueType = venueType;
        this.venuePrice = venuePrice;
        this.address = address;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setOwnerNumber(long ownerNumber) {
        this.ownerNumber = ownerNumber;
    }

    public void setVenueType(String venueType) {
        this.venueType = venueType;
    }

    public void setVenuePrice(double venuePrice) {
        this.venuePrice = venuePrice;
    }

}