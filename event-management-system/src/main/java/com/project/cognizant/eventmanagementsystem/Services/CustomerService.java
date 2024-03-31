package com.project.cognizant.eventmanagementsystem.Services;

import com.project.cognizant.eventmanagementsystem.Model.*;
import com.project.cognizant.eventmanagementsystem.Repository.*;
import com.project.cognizant.eventmanagementsystem.dto.BookEvent;
import com.project.cognizant.eventmanagementsystem.dto.BookPreDefineEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    /* USI001,USI003,USI007,USI008,USI005*/
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    EventRepository eventRepository;

    @Autowired
    EventManagerRepository eventManagerRepository;

    @Autowired
    CakeRepository cakeRepository;

    @Autowired
    DecorationRepository decorationRepository;

    @Autowired
    VenueRepository venueRepository;

    @Autowired
    PreDefineEventsRepository preDefineEventsRepository;

    //USI001-add customer
    public Customer addAnCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    // USI003-Register a event

    //Step1.1 - view event Manager in the customer city.
    public List<EventManager> viewEventManager(int customerId){
        Customer customer = customerRepository.findById(customerId).orElseThrow();
        String city = customer.getCity();
        return eventManagerRepository.findByCity(city);
    }
    //Step 2.1 view cakes
    public List<Cake> viewCakes(){
        return cakeRepository.findAll();
    }
    //Step 3.1 view decoration for the event
    public List<Decoration> viewDecoration(){
        return decorationRepository.findAll();
    }
    //Step 4.1 view venues
    public List<Venue> viewVenue(int customerId){
        Customer customer = customerRepository.findById(customerId).orElseThrow();
        String city = customer.getCity();
        return venueRepository.findByCity(city);
    }
    //step 5 total price of the event
    public Event addAnEvent(BookEvent bookEvent){
        Event event = new Event();
        event.setCustomer(bookEvent.getCustomer());
        event.setEventManager(bookEvent.getEventManager());
        event.setCake(bookEvent.getCake());
        event.setDecoration(bookEvent.getDecoration());
        event.setEventDate(bookEvent.getEventDate());
        event.setEventTime(bookEvent.getEventTime());
        event.setVenue(bookEvent.getVenue());
        double totalPrice = bookEvent.getCake().getCakePrice()+bookEvent.getDecoration().getDecorationPrice()+bookEvent.getVenue().getVenuePrice()+bookEvent.getEventManager().getEventManagerPrice();
        event.setTotalPrice(totalPrice);
        return eventRepository.save(event);
    }

    // USI007 - view Pre-define event design
    public List<PreDefineEvents> viewPreDefineEvent(){
        return preDefineEventsRepository.findAll();
    }
    // USI007 -Pre-define event design
    public Event addPreDefineEvent(BookPreDefineEvent bookPreDefineEvent){
        Event event = new Event();
        event.setCustomer(bookPreDefineEvent.getCustomer());
        event.setEventManager(bookPreDefineEvent.getEventManager());
        event.setCake(bookPreDefineEvent.getPreDefineEvents().getCake());
        event.setDecoration(bookPreDefineEvent.getPreDefineEvents().getDecoration());
        event.setEventTime(bookPreDefineEvent.getEventTime());
        event.setEventDate(bookPreDefineEvent.getEventDate());
        double totalPrice = bookPreDefineEvent.getPreDefineEvents().getTotalPrice()+bookPreDefineEvent.getEventManager().getEventManagerPrice();
        event.setTotalPrice(totalPrice);
        return eventRepository.save(event);
    }

    //USI008-Customize the design
    // set venue other than home location
    public Event changeVenue(int eventId,Venue venue){
        Event event = eventRepository.findById(eventId).orElseThrow();
        event.setVenue(venue);
        double totalPrice = event.getTotalPrice()+venue.getVenuePrice();
        return  eventRepository.save(event);
    }

    //change decoration
    public Event changeDecoration(int eventId,Decoration decoration){
        Event event = eventRepository.findById(eventId).orElseThrow();
        event.setDecoration(decoration);
        double totalPrice =event.getTotalPrice()-event.getDecoration().getDecorationPrice()+decoration.getDecorationPrice();
        event.setTotalPrice(totalPrice);
        return eventRepository.save(event);
    }

    //change cake
    public Event changeCake(int eventId,Cake cake){
        Event event = eventRepository.findById(eventId).orElseThrow();
        event.setCake(cake);
        double totalPrice =event.getTotalPrice()-event.getCake().getCakePrice()+cake.getCakePrice();
        event.setTotalPrice(totalPrice);
        return eventRepository.save(event);
    }

    //USI005 - Cancelling an event (customer)
    public String cancelEvent(int eventId, LocalDate cancelDate){
        Event event = eventRepository.findById(eventId).orElseThrow();
        LocalDate eventDate = event.getEventDate();
        if(eventDate.compareTo(cancelDate) != 0){
            eventRepository.delete(event);
            return "Your event with event id "+event.getEventId()+" is successfully canceled";
        }else{
            return "Your event can not be canceled";
        }
    }
}
