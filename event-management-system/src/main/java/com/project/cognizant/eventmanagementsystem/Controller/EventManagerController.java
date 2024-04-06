package com.project.cognizant.eventmanagementsystem.Controller;

import com.project.cognizant.eventmanagementsystem.Model.Event;
import com.project.cognizant.eventmanagementsystem.Repository.EventManagerRepository;
import com.project.cognizant.eventmanagementsystem.Services.EventManagerServices;
import com.project.cognizant.eventmanagementsystem.dto.ShowBookEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<ShowBookEvent>> viewEvent(@PathVariable int eventMangerId){
            return new ResponseEntity<>(eventManagerServices.getEventByEventManager(eventMangerId), HttpStatus.OK);
    }
    @GetMapping("/accept/{eventId}/{status}")
    public ResponseEntity<String> acceptEvent(@PathVariable int eventId,@PathVariable String status){
        return new ResponseEntity<>(eventManagerServices.acceptingEvent(eventId,status),HttpStatus.OK);
    }

    @GetMapping("/cancel/{eventId}")
    public ResponseEntity<String> cancelEvent(@PathVariable int eventId){
        return new ResponseEntity<>(eventManagerServices.cancelEventByEventManager(eventId),HttpStatus.OK);
    }
}
