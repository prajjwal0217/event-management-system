package com.project.cognizant.eventmanagementsystem.IService;

import com.project.cognizant.eventmanagementsystem.Model.*;
import com.project.cognizant.eventmanagementsystem.dto.BookPreDefineEvent;
import com.project.cognizant.eventmanagementsystem.dto.EventBooking;

import java.util.List;

public interface ICustomerService {
    /* Add a customer to the table */
    public Customer addAnCustomer(Customer customer);
    public Customer customerById(int customerId);
    public List<EventManager> viewEventManager(int customerId);
    public List<Cake> viewCakes();
    public List<Decoration> viewDecoration();
    public List<Venue> viewVenue(int customerId);
    public String addAnEvent(EventBooking eventBooking);
    public List<PreDefineEvents> viewPreDefineEvent();
    public String addPreDefineEvent(BookPreDefineEvent bookPreDefineEvent);
    public String changeVenue(int eventId,int venueId);
    public String changeDecoration(int eventId,int decorationId);
    public String changeCake(int eventId,int cakeId);
    public String cancelEvent(int eventId);
    public String takeRating(int eventManagerId,int rating);
}
