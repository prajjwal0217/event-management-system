package com.project.cognizant.eventmanagementsystem.dto;

import com.project.cognizant.eventmanagementsystem.Model.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookEvent {
    private Customer customer;
    private EventManager eventManager;
    private Cake cake;
    private Decoration decoration;
    private Venue venue;
    //Step 1.2 add an event manager
    //Step 2.2 add a cake for the event
    //Step 3.2 add a decoration for the event
    //Step 4.2 add a venue for the event (if venue is home then keep it null)
}
