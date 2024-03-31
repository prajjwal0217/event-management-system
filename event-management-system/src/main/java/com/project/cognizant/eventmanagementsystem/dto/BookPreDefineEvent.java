package com.project.cognizant.eventmanagementsystem.dto;

import com.project.cognizant.eventmanagementsystem.Model.*;

import java.time.LocalDate;
import java.time.LocalTime;

public class BookPreDefineEvent {
    private Customer customer;
    private EventManager eventManager;
    private PreDefineEvents preDefineEvents;
    private Venue venue;
    private LocalTime eventTime;
    private LocalDate eventDate;

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

    public PreDefineEvents getPreDefineEvents() {
        return preDefineEvents;
    }

    public void setPreDefineEvents(PreDefineEvents preDefineEvents) {
        this.preDefineEvents = preDefineEvents;
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
