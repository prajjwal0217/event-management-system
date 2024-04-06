package com.project.cognizant.eventmanagementsystem.Services;

import com.project.cognizant.eventmanagementsystem.Model.Customer;
import com.project.cognizant.eventmanagementsystem.Model.Event;
import com.project.cognizant.eventmanagementsystem.Model.EventManager;
import com.project.cognizant.eventmanagementsystem.Repository.EventManagerRepository;
import com.project.cognizant.eventmanagementsystem.Repository.EventRepository;
import com.project.cognizant.eventmanagementsystem.UserDefineException.NotExistInDatabase;
import com.project.cognizant.eventmanagementsystem.dto.ShowBookEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
@Service
public class EventManagerServices{

    /*USI002,USI004,USI005,USI009*/
    @Autowired
    EventManagerRepository eventManagerRepository;

    @Autowired
    EventRepository eventRepository;

    private static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public EventManager getEventMangerById(int eventMangerId){
        return eventManagerRepository.findById(eventMangerId).orElseThrow(()-> new NotExistInDatabase("The event manager with the given id does not exist"));
    }

    // USI002- Event manager Login
    public EventManager getNewEventManger(EventManager eventManager){
        return eventManagerRepository.save(eventManager);
    }

    // USI004-Accepting an event

    // Step 1 view all the events
    public  List<ShowBookEvent> getEventByEventManager(int eventManagerId){
        EventManager eventManager = eventManagerRepository.findById(eventManagerId).orElseThrow(()-> new NotExistInDatabase("The event manager with the given id does not exist"));
        List<Event> eventList = eventRepository.findAll();
        List<ShowBookEvent> showEvent = new ArrayList<>();
        for(Event e: eventList){
            if(eventManager.getEventManagerId() == e.getEventManager().getEventManagerId()) {
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
                showEvent.add(obj);
            }
        }
        return showEvent;
    }
    public String acceptingEvent(int eventId,String status){
        Event event = eventRepository.findById(eventId).orElseThrow(()-> new NotExistInDatabase("The event with the given id does not exist"));
        EventManager eventManager = event.getEventManager();
        if(status.equalsIgnoreCase("Accept")){
            event.setEventMangerStatus("Accepted");
            eventRepository.save(event);
            return "Thank you for accepting the event with event id "+event.getEventId();
        }else{
            event.setEventMangerStatus("canceled");
            return "The event has been canceled";
        }
    }

    //USI005 - Cancelling an event (Event manager)
    public String cancelEventByEventManager(int eventId){
        Event event = eventRepository.findById(eventId).orElseThrow(()-> new NotExistInDatabase("The event with the given id does not exist"));
        LocalDate eventDate = event.getEventDate();
        LocalDate currDate = LocalDate.now();
        currDate.format(dateFormat);
        if(event.getEventDate().isEqual(currDate)){
            return "The event cannot be cancel now";
        }else{
            event.setStatus("canceled");
            eventRepository.save(event);
            return "The event has been canceled";
        }
    }

    //USI009 - Discount and offers
    public String getDiscount(int eventId,int eventManagerId){
        Event event = eventRepository.findById(eventId).orElseThrow(()-> new NotExistInDatabase("The event with the given id does not exist"));
        EventManager eventManager = eventManagerRepository.findById(eventManagerId).orElseThrow(()-> new NotExistInDatabase("The event manager with the given id does not exist"));
        Customer customer = event.getCustomer();
        double beforeDiscount = event.getTotalPrice();
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
        eventRepository.save(event);
        return  "The total price of event before discount was "+beforeDiscount+" after discount is "+event.getTotalPrice();
    }
}
