package com.project.cognizant.eventmanagementsystem.Model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@ToString
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventId;
    private LocalDate eventDate;
    private LocalTime eventTime;
    private String status;
    private String eventMangerStatus;
    private double totalPrice;
    @ManyToOne(cascade = CascadeType.MERGE)
    private EventManager eventManager;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Customer customer;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Cake cake;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Venue venue;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Decoration decoration;

}
