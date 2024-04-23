package com.project.cognizant.eventmanagementsystem.Controller;

import com.project.cognizant.eventmanagementsystem.IService.ICustomerService;
import com.project.cognizant.eventmanagementsystem.IService.IEventManagerService;
import com.project.cognizant.eventmanagementsystem.IService.IPreDefineEventService;
import com.project.cognizant.eventmanagementsystem.Model.*;
import com.project.cognizant.eventmanagementsystem.Services.CustomerService;
import com.project.cognizant.eventmanagementsystem.Services.EventManagerServices;
import com.project.cognizant.eventmanagementsystem.Services.PreDefineEventService;
import com.project.cognizant.eventmanagementsystem.dto.BookPreDefineEvent;
import com.project.cognizant.eventmanagementsystem.dto.EventBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;


    @PostMapping("/add")
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.addAnCustomer(customer);
    }

    @GetMapping("/view/eventManager/{id}")
    public ResponseEntity<List<EventManager>> getEventManager(@PathVariable("id") int customerId){
        return new ResponseEntity<>(customerService.viewEventManager(customerId), HttpStatus.OK);
    }

    @GetMapping("/view/cake")
    public ResponseEntity<List<Cake>> getCakes(){
        return new ResponseEntity<>(customerService.viewCakes(),HttpStatus.OK);
    }

    @GetMapping("/view/decoration")
    public ResponseEntity<List<Decoration>> getDecoration(){
        return new ResponseEntity<>(customerService.viewDecoration(),HttpStatus.OK);
    }

    @GetMapping("/view/venue/{id}")
    public ResponseEntity<List<Venue>> getVenue(@PathVariable("id") int customerId){
        return new ResponseEntity<>(customerService.viewVenue(customerId),HttpStatus.OK);
    }

    @GetMapping("/view/preDefineEvent")
    public ResponseEntity<List<PreDefineEvents>> getPreDefineEvents(){
        return new ResponseEntity<>(customerService.viewPreDefineEvent(),HttpStatus.OK);
    }

    @PostMapping("/add/event")
    public ResponseEntity<String> bookEvent(@RequestBody EventBooking eventBooking){
        return new ResponseEntity<>(customerService.addAnEvent(eventBooking),HttpStatus.OK);
    }

    @PostMapping("/add/preDefineEvent")
    public ResponseEntity<String> bookPredefineEvent(@RequestBody BookPreDefineEvent bookPreDefineEvent){
        return new ResponseEntity<>(customerService.addPreDefineEvent(bookPreDefineEvent),HttpStatus.OK);
    }

    @GetMapping("/change/cake/{eventId}/{cakeId}")
    public ResponseEntity<String> changeCake(@PathVariable int eventId,@PathVariable int cakeId){
        return new ResponseEntity<>(customerService.changeCake(eventId,cakeId),HttpStatus.OK);
    }

    @GetMapping("/change/decoration/{eventId}/{decorationId}")
    public ResponseEntity<String> changeDecoration(@PathVariable int eventId,@PathVariable int decorationId){
        return new ResponseEntity<>(customerService.changeDecoration(eventId,decorationId),HttpStatus.OK);
    }

    @GetMapping("/change/venue/{eventId}/{venueId}")
    public ResponseEntity<String> changeVenue(@PathVariable int eventId,@PathVariable int venueId){
        return new ResponseEntity<>(customerService.changeVenue(eventId,venueId),HttpStatus.OK);
    }

    @GetMapping("/cancel/{eventId}")
    public ResponseEntity<String> cancelEvent(@PathVariable int eventId){
        return  new ResponseEntity<>(customerService.cancelEvent(eventId),HttpStatus.OK);
    }

    @GetMapping("/rating/{eventManagerId}/{rating}")
    public ResponseEntity<String> takeRating(@PathVariable int eventManagerId,@PathVariable int rating){
        return new ResponseEntity<>(customerService.takeRating(eventManagerId,rating),HttpStatus.OK);
    }
}
