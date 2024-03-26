package com.project.cognizant.eventmanagementsystem.Model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Event {

    @Id
    @GeneratedValue
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

    public Event() {
    }

    public Event(LocalDate eventDate, LocalTime eventTime, double totalPrice, EventManager eventManager,
            Customer customer, Cake cake, Venue venue, Decoration decoration) {
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.totalPrice = totalPrice;
        this.eventManager = eventManager;
        this.customer = customer;
//        this.cake = cake;
        this.venue = venue;
        this.decoration = decoration;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public void setEventTime(LocalTime eventTime) {
        this.eventTime = eventTime;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setEventManager(EventManager eventManager) {
        this.eventManager = eventManager;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

   /* public void setCake(Cake cake) {
        this.cake = cake;
    }*/

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public void setDecoration(Decoration decoration) {
        this.decoration = decoration;
    }

}
