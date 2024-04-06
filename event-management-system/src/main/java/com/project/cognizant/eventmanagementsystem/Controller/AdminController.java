package com.project.cognizant.eventmanagementsystem.Controller;

import com.project.cognizant.eventmanagementsystem.Model.*;
import com.project.cognizant.eventmanagementsystem.Repository.CustomerRepository;
import com.project.cognizant.eventmanagementsystem.Services.CustomerService;
import com.project.cognizant.eventmanagementsystem.Services.PreDefineEventService;
import com.project.cognizant.eventmanagementsystem.dto.ShowBookEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    PreDefineEventService preDefineEventService;

    @GetMapping("/view/customer")
    public ResponseEntity<List<Customer>> viewCustomer() {
        return new ResponseEntity<>(preDefineEventService.viewCustomer(), HttpStatus.OK);
    }

    @GetMapping("view/events")
    public ResponseEntity<List<ShowBookEvent>> viewEvent() {
        return new ResponseEntity<>(preDefineEventService.viewEvents(),HttpStatus.OK);
    }

    @PostMapping("/add/cake")
    public ResponseEntity<Cake> addCake(@RequestBody Cake cake) {
        return new ResponseEntity<>(preDefineEventService.addCake(cake),HttpStatus.OK);
    }

    @PostMapping("/add/cakes")
    public ResponseEntity<List<Cake>> addCakes(@RequestBody List<Cake> cakes) {
        return new ResponseEntity<>(preDefineEventService.addCakes(cakes),HttpStatus.OK);
    }

    @PostMapping("/add/decoration")
    public ResponseEntity<Decoration> addDecoration(@RequestBody Decoration decoration) {
        return new ResponseEntity<>(preDefineEventService.addDecoration(decoration),HttpStatus.OK);
    }

    @PostMapping("/add/decorations")
    public ResponseEntity<List<Decoration>> addDecorations(@RequestBody List<Decoration> decorations) {
        return new ResponseEntity<>(preDefineEventService.addDecorations(decorations),HttpStatus.OK);
    }

    @PostMapping("/add/venue")
    public ResponseEntity<Venue> addVenue(@RequestBody Venue venue) {
        return new ResponseEntity<>(preDefineEventService.addVenue(venue),HttpStatus.OK);
    }

    @PostMapping("/add/venues")
    public ResponseEntity<List<Venue>> addVenue(@RequestBody List<Venue> venues) {
        return new ResponseEntity<>(preDefineEventService.addVenues(venues),HttpStatus.OK);
    }

    @PostMapping("/add/preDefineEvent")
    public ResponseEntity<PreDefineEvents> addPreDefineEvent(@RequestBody PreDefineEvents preDefineEvents) {
        return new ResponseEntity<>(preDefineEventService.addToPreDefineEvent(preDefineEvents),HttpStatus.OK);
    }

    @PostMapping("/add/preDefineEvents")
    public ResponseEntity<List<PreDefineEvents>> addPreDefineEvents(@RequestBody List<PreDefineEvents> preDefineEvents) {
        return new ResponseEntity<>(preDefineEventService.addToPreDefineEvents(preDefineEvents),HttpStatus.OK);
    }
}
