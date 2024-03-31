package com.project.cognizant.eventmanagementsystem.Services;

import com.project.cognizant.eventmanagementsystem.Model.Customer;
import com.project.cognizant.eventmanagementsystem.Model.Event;
import com.project.cognizant.eventmanagementsystem.Model.EventManager;
import com.project.cognizant.eventmanagementsystem.Repository.EventManagerRepository;
import com.project.cognizant.eventmanagementsystem.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class EventManagerServices {

    /*USI002,USI004,USI005,USI009*/
    @Autowired
    EventManagerRepository eventManagerRepository;

    @Autowired
    EventRepository eventRepository;

    // USI002- Event manager Login
    public EventManager getNewEventManger(EventManager eventManager){
        return eventManagerRepository.save(eventManager);
    }

    // USI004-Accepting an event

    // Step 1 view all the events
    public  List<Event> getEventByEventManager(int eventManagerId){
        EventManager eventManager = eventManagerRepository.findById(eventManagerId).orElseThrow();
        return eventManager.getEventList();
    }
    public String acceptingEvent(int eventId,String status){
        Event event = eventRepository.findById(eventId).orElseThrow();
        EventManager eventManager = event.getEventManager();
        if(status.equalsIgnoreCase("Accept")){
            return "Thank you for accepting the event with event id "+event.getEventId();
        }else{
            eventRepository.delete(event);
            return "The event has been canceled";
        }
    }

    //USI005 - Cancelling an event (Event manager)
    public String cancelEventByEventManager(int eventId, LocalDate currDate){
        Event event = eventRepository.findById(eventId).orElseThrow();
        if(event.getEventDate().compareTo(currDate)==0){
            return "The event cannot be cancel now";
        }else{
            eventRepository.delete(event);
            return "The event has been canceled";
        }
    }

    //USI009 - Discount and offers
    public Event getDiscount(int eventId,int eventManagerId){
        Event event = eventRepository.findById(eventId).orElseThrow();
        EventManager eventManager = eventManagerRepository.findById(eventManagerId).orElseThrow();
        Customer customer = event.getCustomer();
        int count =0;
        for(Event e: customer.getEvent()){
            if(e.getEventManager().getEventManagerId() == eventManager.getEventManagerId()){
                count++;
            }
        }
        double totalPrice=0;
        if( event.getTotalPrice() >= 2000 && count>=3){
            totalPrice = event.getTotalPrice()*(1-0.3);
        }else if(event.getTotalPrice() >= 2000){
            totalPrice= event.getTotalPrice()*(1-0.1);
        }else if(count >=3){
            totalPrice = event.getTotalPrice()*(1-0.2);
        }else{
            totalPrice = event.getTotalPrice();
        }
        event.setTotalPrice(totalPrice);
        return eventRepository.save(event);
    }
}