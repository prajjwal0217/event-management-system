package com.project.cognizant.eventmanagementsystem.Model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventId;
    private LocalDate eventDate;
    private LocalTime eventTime;
    private double totalPrice;
    @ManyToOne(cascade = CascadeType.ALL)
    private EventManager eventManager;
    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;
    @ManyToOne(cascade = CascadeType.ALL)
    private Cake cake;
    @ManyToOne(cascade = CascadeType.ALL)
    private Venue venue;
    @ManyToOne(cascade = CascadeType.ALL)
    private Decoration decoration;

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public LocalTime getEventTime() {
        return eventTime;
    }

    public void setEventTime(LocalTime eventTime) {
        this.eventTime = eventTime;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public EventManager getEventManager() {
        return eventManager;
    }

    public void setEventManager(EventManager eventManager) {
        this.eventManager = eventManager;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Cake getCake() {
        return cake;
    }

    public void setCake(Cake cake) {
        this.cake = cake;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public Decoration getDecoration() {
        return decoration;
    }

    public void setDecoration(Decoration decoration) {
        this.decoration = decoration;
    }

}
