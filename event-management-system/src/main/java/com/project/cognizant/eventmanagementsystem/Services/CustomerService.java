package com.project.cognizant.eventmanagementsystem.Services;

import com.project.cognizant.eventmanagementsystem.Model.*;
import com.project.cognizant.eventmanagementsystem.Repository.*;
import com.project.cognizant.eventmanagementsystem.UserDefineException.NotExistInDatabase;
import com.project.cognizant.eventmanagementsystem.dto.BookPreDefineEvent;
import com.project.cognizant.eventmanagementsystem.dto.EventBooking;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
    @Autowired
    EventManagerServices eventManagerServices;
    @Autowired
    PreDefineEventService preDefineEventService;
    public CustomerService(CustomerRepository customerRepository,EventManagerRepository eventManagerRepository,EventRepository eventRepository,EventManagerServices eventManagerServices,PreDefineEventService preDefineEventService) {
        this.customerRepository = customerRepository;
        this.eventManagerRepository =eventManagerRepository;
        this.eventRepository = eventRepository;
        this.eventManagerServices= eventManagerServices;
        this.preDefineEventService =preDefineEventService;
    }
    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");

    //USI001-add customer
    public Customer addAnCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer customerById(int customerId){
        return customerRepository.findById(customerId).orElseThrow(()->new NotExistInDatabase("Customer id is not in database.Please register as a user"));
    }
    // USI003-Register a event

    //Step1.1 - view event Manager in the customer city.
    public List<EventManager> viewEventManager(int customerId) throws NotExistInDatabase{
        Customer customer = customerRepository.findById(customerId).orElseThrow(() ->new NotExistInDatabase("Customer with this ID is not in our database"));
        String city = customer.getCity();
        if(city == null){
            throw new NotExistInDatabase("No event manger in your city available. Will try to register event manger in our city");
        }else {
            return eventManagerRepository.findByCity(city);
        }
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
        Customer customer = customerById(customerId);
        String city = customer.getCity();
        if(city == null){
            throw new NotExistInDatabase("No venue in your city exist in database");
        }else {
            return venueRepository.findByCity(city);
        }
    }
    //step 5 total price of the event
    @Transactional
    public String addAnEvent(EventBooking eventBooking){
        Customer customer = customerById(eventBooking.getCustomerId());
        EventManager eventManager = eventManagerServices.getEventMangerById(eventBooking.getEventMangerId());
        Decoration decoration = preDefineEventService.findDecorationById(eventBooking.getDecorationId());
        Cake cake = preDefineEventService.findCakeById(eventBooking.getCakeId());
        Venue venue = preDefineEventService.findVenueById(eventBooking.getVenueId());
        Event event = new Event();
        event.setCustomer(customer);
        event.setEventManager(eventManager);
        event.setCake(cake);
        event.setDecoration(decoration);
        event.setEventDate(LocalDate.parse(eventBooking.getEventDate(),dateFormat));
        event.setEventTime(LocalTime.parse(eventBooking.getEventTime(),timeFormat));
        event.setVenue(venue);
        event.setStatus("Accepted");
        event.setEventMangerStatus("In process");
        double totalPrice = cake.getCakePrice()+decoration.getDecorationPrice()+venue.getVenuePrice()+eventManager.getEventManagerPrice();
        event.setTotalPrice(totalPrice);
        eventRepository.save(event);
        return "Your event with event id "+event.getEventId()+" is register successfully.";
    }

    // USI007 - view Pre-define event design
    public List<PreDefineEvents> viewPreDefineEvent(){
        return preDefineEventsRepository.findAll();
    }
    // USI007 -Pre-define event design by default the venue will be home
    @Transactional
    public String addPreDefineEvent(BookPreDefineEvent bookPreDefineEvent){
        Customer customer = customerById(bookPreDefineEvent.getCustomerId());
        EventManager eventManager = eventManagerServices.getEventMangerById(bookPreDefineEvent.getEventManagerId());
        PreDefineEvents preDefineEvents = preDefineEventService.findPreDefineEventsById(bookPreDefineEvent.getPreDefineEventId());
        Event event = new Event();
        event.setCustomer(customer);
        event.setEventManager(eventManager);
        event.setCake(preDefineEvents.getCake());
        event.setDecoration(preDefineEvents.getDecoration());
        event.setEventDate(LocalDate.parse(bookPreDefineEvent.getEventDate(),dateFormat));
        event.setEventTime(LocalTime.parse(bookPreDefineEvent.getEventTime(),timeFormat));
        event.setStatus("Accepted");
        event.setEventMangerStatus("In process");
        double totalPrice = preDefineEvents.getCake().getCakePrice()+eventManager.getEventManagerPrice()+preDefineEvents.getDecoration().getDecorationPrice();
        event.setTotalPrice(totalPrice);
        eventRepository.save(event);
        return "Your event with event id "+event.getEventId()+" is register successfully. By default the venue is set as your home address";
    }

    //USI008-Customize the design
    // set venue other than home location
    public String changeVenue(int eventId,int venueId){
        Event event = eventRepository.findById(eventId).orElseThrow();
        Venue venue = venueRepository.findById(venueId).orElseThrow();
        event.setVenue(venue);
        double totalPrice = event.getTotalPrice()+venue.getVenuePrice();
        event.setTotalPrice(totalPrice);
        eventRepository.save(event);
        return "Your venue has been changed successfully";
    }

    //change decoration
    public String changeDecoration(int eventId,int decorationId){
        Event event = eventRepository.findById(eventId).orElseThrow();
        Decoration decoration = decorationRepository.findById(decorationId).orElseThrow();
        event.setDecoration(decoration);
        double totalPrice =event.getTotalPrice()-event.getDecoration().getDecorationPrice()+decoration.getDecorationPrice();
        event.setTotalPrice(totalPrice);
        eventRepository.save(event);
        return "Your decoration themes has been changed successfully";
    }

    //change cake
    public String changeCake(int eventId,int cakeId){
        Event event = eventRepository.findById(eventId).orElseThrow();
        Cake cake = cakeRepository.findById(cakeId).orElseThrow();
        event.setCake(cake);
        double totalPrice =event.getTotalPrice()-event.getCake().getCakePrice()+cake.getCakePrice();
        event.setTotalPrice(totalPrice);
        eventRepository.save(event);
        return "Your cake has been changed successfully";
    }

    //USI005 - Cancelling an event (customer)
    public String cancelEvent(int eventId){
        Event event = eventRepository.findById(eventId).orElseThrow();
        LocalDate eventDate = event.getEventDate();
        LocalDate currDate = LocalDate.now();
        currDate.format(dateFormat);
        if(!eventDate.isEqual(currDate)){
            event.setStatus("cancel");
            eventRepository.save(event);
            return "Your event with event id "+event.getEventId()+" is successfully canceled";
        }else{
            return "Your event can not be canceled";
        }
    }

    // give rating to event manager
    public String takeRating(int eventManagerId,int rating){
        EventManager eventManager = eventManagerServices.getEventMangerById(eventManagerId);
        int currRating = eventManager.getRating();
        eventManager.setRating((currRating+rating)/2);
        eventManagerRepository.save(eventManager);
        return "Thank you for giving rating";
    }
}
