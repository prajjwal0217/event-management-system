package com.project.cognizant.eventmanagementsystem;

import com.project.cognizant.eventmanagementsystem.Model.Customer;
import com.project.cognizant.eventmanagementsystem.Model.Event;
import com.project.cognizant.eventmanagementsystem.Model.EventManager;
import com.project.cognizant.eventmanagementsystem.Repository.EventManagerRepository;
import com.project.cognizant.eventmanagementsystem.Repository.EventRepository;
import com.project.cognizant.eventmanagementsystem.Services.EventManagerServices;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EventManagerServicesTest{

    @InjectMocks
    EventManagerServices eventManagerServices;

    @Mock
    EventManagerRepository eventManagerRepository;

    @Mock
    EventRepository eventRepository;

    @BeforeEach
    public void setUp() {
        eventManagerRepository = mock(EventManagerRepository.class);
        eventRepository = mock(EventRepository.class);
        eventManagerServices = new EventManagerServices(eventManagerRepository,eventRepository);
    }

    @Test
    public void testGetEventMangerById() {
        EventManager eventManager = new EventManager("abcd1","eventManagerEmailId",3455643435L,1500,"Indore");
        eventManager.setEventManagerId(1);
        when(eventManagerRepository.findById(1)).thenReturn(Optional.of(eventManager));

        EventManager result = eventManagerServices.getEventMangerById(1);
        assertEquals(1, result.getEventManagerId());
    }

    @Test
    public void testGetDiscount() {
        // Arrange
        Event event = new Event();
        event.setTotalPrice(3000);
        EventManager eventManager = new EventManager();
        eventManager.setEventManagerId(1);
        Customer customer = new Customer();
        customer.setEvent(new ArrayList<>());
        event.setCustomer(customer);

        when(eventRepository.findById(1)).thenReturn(Optional.of(event));
        when(eventManagerRepository.findById(1)).thenReturn(Optional.of(eventManager));

        // Act
        String result = eventManagerServices.getDiscount(1, 1);

        // Assert
        assertEquals("The total price of event before discount was 3000.0 after discount is 2700.0", result);
    }
}
