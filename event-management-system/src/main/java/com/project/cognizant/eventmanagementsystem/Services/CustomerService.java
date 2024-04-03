package com.project.cognizant.eventmanagementsystem.Services;

import com.project.cognizant.eventmanagementsystem.Model.*;
import com.project.cognizant.eventmanagementsystem.Repository.*;
import com.project.cognizant.eventmanagementsystem.dto.BookEvent;
import com.project.cognizant.eventmanagementsystem.dto.BookPreDefineEvent;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService{

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
    @Transactional
    public String addAnEvent(BookEvent bookEvent){
        Event event = new Event();
        event.setCustomer(bookEvent.getCustomer());
        event.setEventManager(bookEvent.getEventManager());
        event.setCake(bookEvent.getCake());
        event.setDecoration(bookEvent.getDecoration());
        event.setEventDate(LocalDate.now());
        event.setEventTime(LocalTime.now());
        event.setVenue(bookEvent.getVenue());
        double totalPrice = bookEvent.getCake().getCakePrice()+bookEvent.getDecoration().getDecorationPrice()+bookEvent.getVenue().getVenuePrice()+bookEvent.getEventManager().getEventManagerPrice();
        event.setTotalPrice(totalPrice);
        List<Event> events= new ArrayList<>();
        events.add(event);
        bookEvent.getCake().setEvent(events);
        bookEvent.getEventManager().setEventList(events);
        bookEvent.getCustomer().setEvent(events);
        bookEvent.getDecoration().setEventList(events);
        bookEvent.getVenue().setEvent(events);
        eventRepository.save(event);
        eventManagerRepository.save(bookEvent.getEventManager());
        cakeRepository.save(bookEvent.getCake());
        customerRepository.save(bookEvent.getCustomer());
        decorationRepository.save(bookEvent.getDecoration());
        venueRepository.save(bookEvent.getVenue());
        //return eventRepository.save(event);
        return "Your event with event id :"+event.getEventId()+" is register successfully.";
    }

    // USI007 - view Pre-define event design
    public List<PreDefineEvents> viewPreDefineEvent(){
        return preDefineEventsRepository.findAll();
    }
    // USI007 -Pre-define event design
    @Transactional
    public String addPreDefineEvent(BookPreDefineEvent bookPreDefineEvent){
        Event event = new Event();
        event.setCustomer(bookPreDefineEvent.getCustomer());
        event.setEventManager(bookPreDefineEvent.getEventManager());
        event.setCake(bookPreDefineEvent.getPreDefineEvents().getCake());
        event.setDecoration(bookPreDefineEvent.getPreDefineEvents().getDecoration());
        event.setVenue(bookPreDefineEvent.getVenue());
        event.setEventTime(LocalTime.now());
        event.setEventDate(LocalDate.now());
        event.setStatus("Accepted");
        event.setEventMangerStatus("In process");
        double totalPrice = bookPreDefineEvent.getPreDefineEvents().getCake().getCakePrice()+bookPreDefineEvent.getEventManager().getEventManagerPrice()+bookPreDefineEvent.getPreDefineEvents().getDecoration().getDecorationPrice();
        event.setTotalPrice(totalPrice);
        List<Event> events= new ArrayList<>();
        events.add(event);
        bookPreDefineEvent.getPreDefineEvents().getCake().setEvent(events);
        bookPreDefineEvent.getPreDefineEvents().getDecoration().setEventList(events);
        bookPreDefineEvent.getCustomer().setEvent(events);
        bookPreDefineEvent.getEventManager().setEventList(events);
        bookPreDefineEvent.getVenue().setEvent(events);
        eventRepository.save(event);
        eventManagerRepository.save(bookPreDefineEvent.getEventManager());
        cakeRepository.save(bookPreDefineEvent.getPreDefineEvents().getCake());
        customerRepository.save(bookPreDefineEvent.getCustomer());
        decorationRepository.save(bookPreDefineEvent.getPreDefineEvents().getDecoration());
        venueRepository.save(bookPreDefineEvent.getVenue());
        return "Your event with event id :"+event.getEventId()+"is register successfully.";
    }

    //USI008-Customize the design
    // set venue other than home location
    public void changeVenue(int eventId,int venueId){
        Event event = eventRepository.findById(eventId).orElseThrow();
        Venue venue = venueRepository.findById(venueId).orElseThrow();
        event.setVenue(venue);
        double totalPrice = event.getTotalPrice()+venue.getVenuePrice();
        eventRepository.save(event);
    }

    //change decoration
    public void changeDecoration(int eventId,int decorationId){
        Event event = eventRepository.findById(eventId).orElseThrow();
        Decoration decoration = decorationRepository.findById(decorationId).orElseThrow();
        event.setDecoration(decoration);
        double totalPrice =event.getTotalPrice()-event.getDecoration().getDecorationPrice()+decoration.getDecorationPrice();
        event.setTotalPrice(totalPrice);
        eventRepository.save(event);
    }

    //change cake
    public void changeCake(int eventId,int cakeId){
        Event event = eventRepository.findById(eventId).orElseThrow();
        Cake cake = cakeRepository.findById(cakeId).orElseThrow();
        event.setCake(cake);
        double totalPrice =event.getTotalPrice()-event.getCake().getCakePrice()+cake.getCakePrice();
        event.setTotalPrice(totalPrice);
        eventRepository.save(event);
    }

    //USI005 - Cancelling an event (customer)
    public String cancelEvent(int eventId, String cancelDate){
        Event event = eventRepository.findById(eventId).orElseThrow();
        LocalDate eventDate = event.getEventDate();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        eventDate.format(df);
        LocalDate localCancelDate = LocalDate.parse(cancelDate,df);
        if(!eventDate.isEqual(localCancelDate)){
            //eventRepository.delete(event);
            event.setStatus("cancel");
            eventRepository.save(event);
            return "Your event with event id "+event.getEventId()+" is successfully canceled";
        }else{
            return "Your event can not be canceled";
        }
    }
}
