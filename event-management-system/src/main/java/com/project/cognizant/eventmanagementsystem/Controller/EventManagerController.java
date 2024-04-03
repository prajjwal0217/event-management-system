package com.project.cognizant.eventmanagementsystem.Controller;

import com.project.cognizant.eventmanagementsystem.Model.Event;
import com.project.cognizant.eventmanagementsystem.Repository.EventManagerRepository;
import com.project.cognizant.eventmanagementsystem.Services.EventManagerServices;
import com.project.cognizant.eventmanagementsystem.dto.ShowBookEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/eventManger")
public class EventManagerController {

    @Autowired
    EventManagerServices eventManagerServices;

    @GetMapping("/view/events/{eventMangerId}")
    public List<ShowBookEvent> viewEvent(@PathVariable int eventMangerId){
            return eventManagerServices.getEventByEventManager(eventMangerId);
    }
    @GetMapping("/accept/{eventId}/{status}")
    public String acceptEvent(@PathVariable int eventId,@PathVariable String status){
        return eventManagerServices.acceptingEvent(eventId,status);
    }

    @GetMapping("/cancel/{eventId}/{currDate}")
    public String cancelEvent(@PathVariable int eventId, @PathVariable LocalDate currDate){
        return eventManagerServices.cancelEventByEventManager(eventId,currDate);
    }
}
