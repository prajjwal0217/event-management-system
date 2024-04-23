package com.project.cognizant.eventmanagementsystem.Controller;

import com.project.cognizant.eventmanagementsystem.IService.IEventManagerService;
import com.project.cognizant.eventmanagementsystem.Model.EventManager;
import com.project.cognizant.eventmanagementsystem.dto.ShowBookEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventManger")
public class EventManagerController {

    @Autowired
    IEventManagerService eventManagerServices;

    @PostMapping("/add")
    public ResponseEntity<EventManager> addEventManager(@RequestBody EventManager eventManager){
        return new ResponseEntity<>(eventManagerServices.getNewEventManger(eventManager),HttpStatus.OK);
    }

    @GetMapping("/view/events/{eventMangerId}")
    public ResponseEntity<List<ShowBookEvent>> viewEvent(@PathVariable int eventMangerId){
            return new ResponseEntity<>(eventManagerServices.getEventByEventManager(eventMangerId), HttpStatus.OK);
    }

    @GetMapping("/accept/{eventId}/{status}")
    public ResponseEntity<String> acceptEvent(@PathVariable int eventId,@PathVariable String status){
        return new ResponseEntity<>(eventManagerServices.acceptingEvent(eventId,status),HttpStatus.OK);
    }

    @GetMapping("/discount/{eventId}/{eventMangerId}")
    public ResponseEntity<String> getDiscount(@PathVariable int eventId,@PathVariable int eventMangerId){
        return new ResponseEntity<>(eventManagerServices.getDiscount(eventId,eventMangerId),HttpStatus.OK);
    }

    @GetMapping("/cancel/{eventId}")
    public ResponseEntity<String> cancelEvent(@PathVariable int eventId){
        return new ResponseEntity<>(eventManagerServices.cancelEventByEventManager(eventId),HttpStatus.OK);
    }

}
