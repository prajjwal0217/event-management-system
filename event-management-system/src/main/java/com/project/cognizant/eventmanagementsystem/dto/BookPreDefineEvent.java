package com.project.cognizant.eventmanagementsystem.dto;

import com.project.cognizant.eventmanagementsystem.Model.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@RequiredArgsConstructor
public class BookPreDefineEvent {
    private Customer customer;
    private EventManager eventManager;
    private PreDefineEvents preDefineEvents;
    private Venue venue;
    public BookPreDefineEvent(Customer customer, EventManager eventManager, PreDefineEvents preDefineEvents, Venue venue) {
        this.customer = customer;
        this.eventManager = eventManager;
        this.preDefineEvents = preDefineEvents;
        this.venue = venue;
    }


}
