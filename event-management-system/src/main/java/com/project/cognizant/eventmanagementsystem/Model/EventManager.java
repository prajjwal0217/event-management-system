package com.project.cognizant.eventmanagementsystem.Model;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
public class EventManager {

    @Id
    @GeneratedValue
    private int eventManagerId;
    private String eventName;
    private String eventManagerEmailId;
    private long eventManagerPhoneNumber;
    private int rating;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="addressId")
    private Address address;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Event> eventList;

    public EventManager() {
        super();
    }

    public EventManager(String eventName, String eventManagerEmailId, long eventManagerPhoneNumber, int rating,
            Address address) {
        this.eventName = eventName;
        this.eventManagerEmailId = eventManagerEmailId;
        this.eventManagerPhoneNumber = eventManagerPhoneNumber;
        this.rating = rating;
        this.address = address;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventManagerEmailId(String eventManagerEmailId) {
        this.eventManagerEmailId = eventManagerEmailId;
    }

    public void setEventManagerPhoneNumber(long eventManagerPhoneNumber) {
        this.eventManagerPhoneNumber = eventManagerPhoneNumber;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

}
