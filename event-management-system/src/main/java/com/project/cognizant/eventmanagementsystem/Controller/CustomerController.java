package com.project.cognizant.eventmanagementsystem.Controller;

import com.project.cognizant.eventmanagementsystem.Model.*;
import com.project.cognizant.eventmanagementsystem.Repository.*;
import com.project.cognizant.eventmanagementsystem.Services.CustomerService;
import com.project.cognizant.eventmanagementsystem.Services.EventManagerServices;
import com.project.cognizant.eventmanagementsystem.dto.BookEvent;
import com.project.cognizant.eventmanagementsystem.dto.BookPreDefineEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    EventManagerRepository eventManagerRepository;
    @Autowired
    CakeRepository cakeRepository;
    @Autowired
    VenueRepository venueRepository;
    @Autowired
    DecorationRepository decorationRepository;

    @Autowired
    PreDefineEventsRepository preDefineEventsRepository;
    @Autowired
    EventManagerServices eventManagerServices;
    @GetMapping("/view")
    public List<Customer> viewCustomer(){
        return customerRepository.findAll();
    }
    @PostMapping("/add")
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.addAnCustomer(customer);
    }

    @GetMapping("/view/eventManager/{id}")
    public List<EventManager> getEventManager(@PathVariable("id") int customerId){
        return customerService.viewEventManager(customerId);
    }

    @GetMapping("/view/cake")
    public List<Cake> getCakes(){
        return customerService.viewCakes();
    }

    @GetMapping("/view/decoration")
    public List<Decoration> getDecroation(){
        return customerService.viewDecoration();
    }

    @GetMapping("/view/venue/{id}")
    public List<Venue> getVenue(@PathVariable("id") int customerId){
        return customerService.viewVenue(customerId);
    }

    @GetMapping("/view/preDefineEvent")
    public List<PreDefineEvents> getPreDefineEvents(){
        return customerService.viewPreDefineEvent();
    }

    @GetMapping("/add/event/{cid}/{eid}/{did}/{caid}/{vid}")
    public String bookEvent(@PathVariable("cid") int customerId,@PathVariable("eid") int eventmangerId,@PathVariable("did") int decarationId,@PathVariable("caid") int cakeId,@PathVariable("vid") int venueId){
        Customer customer = customerRepository.findById(customerId).orElseThrow();
        EventManager eventManager = eventManagerRepository.findById(eventmangerId).orElseThrow();
        Decoration decoration = decorationRepository.findById(decarationId).orElseThrow();
        Cake cake = cakeRepository.findById(cakeId).orElseThrow();
        Venue venue = venueRepository.findById(venueId).orElseThrow();
        BookEvent obj = new BookEvent(customer,eventManager,cake,decoration,venue);
        return customerService.addAnEvent(obj);
    }

    @GetMapping("/add/preDefineEvent/{cid}/{eid}/{pid}/{vid}")
    public String bookPredefineEvent(@PathVariable("cid") int customerId,@PathVariable("eid") int eventmangerId,@PathVariable("pid") int preDefineEventId,@PathVariable("vid") int venueId){
        Customer customer = customerRepository.findById(customerId).orElseThrow();
        EventManager eventManager = eventManagerRepository.findById(eventmangerId).orElseThrow();
        PreDefineEvents preDefineEvents = preDefineEventsRepository.findById(preDefineEventId).orElseThrow();
        Venue venue = venueRepository.findById(venueId).orElseThrow();
        BookPreDefineEvent bookPreDefineEvent = new BookPreDefineEvent(customer,eventManager,preDefineEvents,venue);
        return customerService.addPreDefineEvent(bookPreDefineEvent);
    }

    @GetMapping("/discount/{eventId}/{eventMangerId}")
    public String getDiscount(@PathVariable int eventId,@PathVariable int eventMangerId){
        return eventManagerServices.getDiscount(eventId,eventMangerId);
    }

    @GetMapping("/change/cake/{eventId}/{cakeId}")
    public void changeCake(@PathVariable int eventId,@PathVariable int cakeId){
        customerService.changeCake(eventId,cakeId);
    }

    @GetMapping("/change/decoration/{eventId}/{decorationId}")
    public void changeDecoration(@PathVariable int eventId,@PathVariable int decorationId){
        customerService.changeDecoration(eventId,decorationId);
    }

    @GetMapping("/change/venue/{eventId}/{venueId}")
    public void changeVenue(@PathVariable int eventId,@PathVariable int venueId){
        customerService.changeVenue(eventId,venueId);
    }

    @GetMapping("/cancel/{eventId}/{cancelDate}")
    public String cancelEvent(@PathVariable int eventId,@PathVariable String cancelDate){
        return  customerService.cancelEvent(eventId,cancelDate);
    }

}
