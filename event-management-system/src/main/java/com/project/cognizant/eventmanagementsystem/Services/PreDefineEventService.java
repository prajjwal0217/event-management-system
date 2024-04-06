package com.project.cognizant.eventmanagementsystem.Services;

import com.project.cognizant.eventmanagementsystem.Model.*;
import com.project.cognizant.eventmanagementsystem.Repository.*;
import com.project.cognizant.eventmanagementsystem.UserDefineException.NotExistInDatabase;
import com.project.cognizant.eventmanagementsystem.dto.ShowBookEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PreDefineEventService{

    @Autowired
    CakeRepository cakeRepository;
    @Autowired
    DecorationRepository decorationRepository;
    @Autowired
    VenueRepository venueRepository;
    @Autowired
    PreDefineEventsRepository preDefineEventsRepository;
    // add predefine events
    @Autowired
    EventRepository eventRepository;
    @Autowired
    CustomerRepository customerRepository;

    public Cake findCakeById(int cakeId){
        return cakeRepository.findById(cakeId).orElseThrow(()->new NotExistInDatabase("The cake id is not in the database"));
    }
    public Decoration findDecorationById(int decorationId){
        return decorationRepository.findById(decorationId).orElseThrow(()-> new NotExistInDatabase("The decoration id is not in the database"));
    }
    public Venue findVenueById(int venueId){
        return venueRepository.findById(venueId).orElseThrow(()-> new NotExistInDatabase("Venue Id is not in the database"));
    }
    public PreDefineEvents findPreDefineEventsById(int preDefineEventId){
        return preDefineEventsRepository.findById(preDefineEventId).orElseThrow(()-> new NotExistInDatabase("This pre define event is not in the database"));
    }
    public List<Customer> viewCustomer(){
        return customerRepository.findAll();
    }
    public Cake addCake(Cake cake) {
        return cakeRepository.save(cake);
    }

    public List<Cake> addCakes(List<Cake> cakes) {
        return cakeRepository.saveAll(cakes);
    }

    public Decoration addDecoration(Decoration decoration) {
        return decorationRepository.save(decoration);
    }

    public List<Decoration> addDecorations(List<Decoration> decorations) {
        return decorationRepository.saveAll(decorations);
    }
    public Venue addVenue(Venue venue) {
        return venueRepository.save(venue);
    }

    public List<Venue> addVenues(List<Venue> venues) {
        return venueRepository.saveAll(venues);
    }

    public PreDefineEvents addToPreDefineEvent(PreDefineEvents preDefineEvents){
        return preDefineEventsRepository.save(preDefineEvents);
    }

    public List<PreDefineEvents> addToPreDefineEvents(List<PreDefineEvents> preDefineEvents){
        return  preDefineEventsRepository.saveAll(preDefineEvents);
    }

    public List<ShowBookEvent> viewEvents(){
        List<Event> eventList= eventRepository.findAll();
        List<ShowBookEvent> showEventclass = new ArrayList<>();
        for(Event e: eventList){
            ShowBookEvent obj = new ShowBookEvent();
            obj.setCustomerId(e.getCustomer().getCustomerId());
            obj.setEventId(e.getEventId());
            obj.setEventManagerId(e.getEventManager().getEventManagerId());
            obj.setCakeName(e.getCake().getCakeName());
            obj.setDecorationName(e.getDecoration().getDecorationType());
            obj.setVenueName(e.getVenue().getVenueName());
            obj.setEventDate(e.getEventDate());
            obj.setEventTime(e.getEventTime());
            obj.setTotalPrice(e.getTotalPrice());
            showEventclass.add(obj);
        }
        return showEventclass;
    }

    //view event details by customer id
}
