package com.project.cognizant.eventmanagementsystem.IService;

import com.project.cognizant.eventmanagementsystem.Model.*;
import com.project.cognizant.eventmanagementsystem.dto.PreDefineEventDto;
import com.project.cognizant.eventmanagementsystem.dto.ShowBookEvent;

import java.util.List;

public interface IPreDefineEventService {
    public Cake findCakeById(int cakeId);
    public Cake addCake(Cake cake);
    public List<Cake> addCakes(List<Cake> cakes);
    public Decoration findDecorationById(int decorationId);
    public Decoration addDecoration(Decoration decoration);
    public List<Decoration> addDecorations(List<Decoration> decorations);
    public Venue findVenueById(int venueId);
    public Venue addVenue(Venue venue);
    public List<Venue> addVenues(List<Venue> venues);
    public PreDefineEvents findPreDefineEventsById(int preDefineEventId);
    public PreDefineEvents addToPreDefineEvent(PreDefineEventDto preDefineEvent);
    public List<PreDefineEvents> addToPreDefineEvents(List<PreDefineEvents> preDefineEvents);
    public List<Customer> viewCustomer();
    public List<ShowBookEvent> viewEvents();
}
