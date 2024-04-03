package com.project.cognizant.eventmanagementsystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
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
    @JsonIgnore
    private List<Event> event;

    public Venue(String venueName, String ownerName, long ownerNumber, String venueType, double venuePrice, String city) {
        this.venueName = venueName;
        this.ownerName = ownerName;
        this.ownerNumber = ownerNumber;
        this.venueType = venueType;
        this.venuePrice = venuePrice;
        this.city = city;
    }

}