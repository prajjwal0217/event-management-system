package com.project.cognizant.eventmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventBooking {
    private int customerId;
    private int eventMangerId;
    private int venueId;
    private int cakeId;
    private int decorationId;
    private String eventDate;
    private String eventTime;

}
