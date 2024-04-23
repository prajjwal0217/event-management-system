package com.project.cognizant.eventmanagementsystem.IService;

import com.project.cognizant.eventmanagementsystem.Model.EventManager;
import com.project.cognizant.eventmanagementsystem.dto.ShowBookEvent;

import java.util.List;

public interface IEventManagerService {
    public EventManager getEventMangerById(int eventMangerId);
    public EventManager getNewEventManger(EventManager eventManager);
    public List<ShowBookEvent> getEventByEventManager(int eventManagerId);
    public String acceptingEvent(int eventId,String status);
    public String cancelEventByEventManager(int eventId);
    public String getDiscount(int eventId,int eventManagerId);
}
