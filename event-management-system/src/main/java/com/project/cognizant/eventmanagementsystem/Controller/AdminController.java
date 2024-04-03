package com.project.cognizant.eventmanagementsystem.Controller;

import com.project.cognizant.eventmanagementsystem.Model.*;
import com.project.cognizant.eventmanagementsystem.Services.PreDefineEventService;
import com.project.cognizant.eventmanagementsystem.dto.ShowBookEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    PreDefineEventService preDefineEventService;
    @GetMapping("view/events")
    public List<ShowBookEvent> viewEvent(){
        return preDefineEventService.viewEvents();
    }

    @PostMapping("/add/cake")
    public Cake addCake(@RequestBody Cake cake){
        return preDefineEventService.addCake(cake);
    }

    @PostMapping("/add/cakes")
    public List<Cake> addCakes(@RequestBody List<Cake> cakes){
        return preDefineEventService.addCakes(cakes);
    }

    @PostMapping("/add/decoration")
    public Decoration addDecoration(@RequestBody Decoration decoration){
        return preDefineEventService.addDecoration(decoration);
    }

    @PostMapping("/add/decorations")
    public List<Decoration> addDecorations(@RequestBody List<Decoration> decorations){
        return preDefineEventService.addDecorations(decorations);
    }

    @PostMapping("/add/venue")
    public Venue addVenue(@RequestBody Venue venue){
        return preDefineEventService.addVenue(venue);
    }

    @PostMapping("/add/venues")
    public List<Venue> addVences(@RequestBody List<Venue> venues){
        return preDefineEventService.addVenues(venues);
    }

    @PostMapping("/add/preDefineEvent")
    public PreDefineEvents addPreDefineEvent(@RequestBody PreDefineEvents preDefineEvents){
        return preDefineEventService.addToPreDefineEvent(preDefineEvents);
    }

    @PostMapping("/add/preDefineEvents")
    public List<PreDefineEvents> addPreDefineEvents(@RequestBody List<PreDefineEvents> preDefineEvents){
        return preDefineEventService.addToPreDefineEvents(preDefineEvents);
    }
}
