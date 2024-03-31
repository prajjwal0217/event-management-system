package com.project.cognizant.eventmanagementsystem.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class EventManager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventManagerId;
    private String eventName;
    private String eventManagerEmailId;
    private long eventManagerPhoneNumber;
    private double eventManagerPrice;
    private int rating;
    private String city;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Event> eventList;

    public int getEventManagerId() {
        return eventManagerId;
    }

    public void setEventManagerId(int eventManagerId) {
        this.eventManagerId = eventManagerId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventManagerEmailId() {
        return eventManagerEmailId;
    }

    public void setEventManagerEmailId(String eventManagerEmailId) {
        this.eventManagerEmailId = eventManagerEmailId;
    }

    public long getEventManagerPhoneNumber() {
        return eventManagerPhoneNumber;
    }

    public void setEventManagerPhoneNumber(long eventManagerPhoneNumber) {
        this.eventManagerPhoneNumber = eventManagerPhoneNumber;
    }

    public double getEventManagerPrice() {
        return eventManagerPrice;
    }

    public void setEventManagerPrice(double eventManagerPrice) {
        this.eventManagerPrice = eventManagerPrice;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }
}
