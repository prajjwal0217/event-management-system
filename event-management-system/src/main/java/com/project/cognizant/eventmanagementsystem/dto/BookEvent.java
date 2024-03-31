package com.project.cognizant.eventmanagementsystem.dto;

import com.project.cognizant.eventmanagementsystem.Model.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

public class BookEvent {
    private Customer customer;
    private EventManager eventManager;
    private Cake cake;
    private Decoration decoration;
    private Venue venue;
    private LocalTime eventTime;
    private LocalDate eventDate;
    //Step 1.2 add an event manager
    //Step 2.2 add a cake for the event
    //Step 3.2 add a decoration for the event
    //Step 4.2 add a venue for the event (if venue is home then keep it null)

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public EventManager getEventManager() {
        return eventManager;
    }

    public void setEventManager(EventManager eventManager) {
        this.eventManager = eventManager;
    }

    public Cake getCake() {
        return cake;
    }

    public void setCake(Cake cake) {
        this.cake = cake;
    }

    public Decoration getDecoration() {
        return decoration;
    }

    public void setDecoration(Decoration decoration) {
        this.decoration = decoration;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public LocalTime getEventTime() {
        return eventTime;
    }

    public void setEventTime(LocalTime eventTime) {
        this.eventTime = eventTime;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }
}
