package com.project.cognizant.eventmanagementsystem.dto;

import com.project.cognizant.eventmanagementsystem.Model.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@ToString
public class ShowBookEvent {
    private int eventId;
    private int customerId;
    private int eventManagerId;
    private String cakeName;
    private String decorationName;
    private String venueName;
    private LocalDate eventDate;
    private LocalTime eventTime;
    private double totalPrice;
}
