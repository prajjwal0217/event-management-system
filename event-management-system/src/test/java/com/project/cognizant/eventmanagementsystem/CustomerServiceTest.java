package com.project.cognizant.eventmanagementsystem;

import com.project.cognizant.eventmanagementsystem.Model.*;
import com.project.cognizant.eventmanagementsystem.Repository.CustomerRepository;
import com.project.cognizant.eventmanagementsystem.Repository.EventManagerRepository;
import com.project.cognizant.eventmanagementsystem.Repository.EventRepository;
import com.project.cognizant.eventmanagementsystem.Services.CustomerService;
import com.project.cognizant.eventmanagementsystem.Services.EventManagerServices;
import com.project.cognizant.eventmanagementsystem.Services.PreDefineEventService;
import com.project.cognizant.eventmanagementsystem.UserDefineException.NotExistInDatabase;
import com.project.cognizant.eventmanagementsystem.dto.EventBooking;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

    @InjectMocks
    CustomerService customerService;
    @Mock
    CustomerRepository customerRepository;
    @Mock
    EventManagerRepository eventManagerRepository;
    @Mock
    EventManagerServices eventManagerServices;
    @Mock
    EventRepository eventRepository;
    @Mock
    PreDefineEventService preDefineEventService;

    @Before
    public void setUp() {
        customerRepository = mock(CustomerRepository.class);
        eventManagerRepository = mock(EventManagerRepository.class);
        eventRepository = mock(EventRepository.class);
        eventManagerServices = mock(EventManagerServices.class);
        preDefineEventService = mock(PreDefineEventService.class);
        customerService = new CustomerService(customerRepository,eventManagerRepository,eventRepository,eventManagerServices,preDefineEventService);
    }

    @Test
    public void testCustomerById_CustomerFound() {
        int customerId = 1;
        Customer expectedCustomer = new Customer("John Doe", "john@example.com",893278957345L,"Indore");
        when(customerRepository.findById(customerId)).thenReturn(Optional.of(expectedCustomer));
        Customer actualCustomer = customerService.customerById(customerId);
        assertEquals(expectedCustomer, actualCustomer);
        verify(customerRepository).findById(customerId);
    }

    @Test
    public void testCustomerById_CustomerNotFound() {
        int customerId = 1;
        when(customerRepository.findById(customerId)).thenReturn(Optional.empty());
        assertThrows(NotExistInDatabase.class, () -> customerService.customerById(customerId));
        verify(customerRepository).findById(customerId);
    }

    @Test
    public void testAddAnCustomer() {

        // Created a Customer
        Customer customer = new Customer("John Doe", "john@example.com", 893278957345L, "Indore");

        // Stub the customerRepository.save() method to return the same Customer instance
        when(customerRepository.save(customer)).thenReturn(customer);

        // Call the method under test
        Customer result = customerService.addAnCustomer(customer);

        // Verifying that customerRepository.save() was called with the correct Customer object
        verify(customerRepository).save(customer);

        // Check if the returned result matches the expected Customer
        assertEquals(customer, result);
    }

    @Test
    public void testViewEventManager_CustomerCityNotNull() {
        int customerId = 1;
        String customerCity = "Indore";
        Customer customer = new Customer();
        customer.setCity(customerCity);
        List<EventManager> expectedEventManagers = new ArrayList<>();
        expectedEventManagers.add(new EventManager());
        when(customerRepository.findById(customerId)).thenReturn(Optional.of(customer));
        when(eventManagerRepository.findByCity(customerCity)).thenReturn(expectedEventManagers);
        List<EventManager> actualEventManagers = customerService.viewEventManager(customerId);
        assertEquals(expectedEventManagers, actualEventManagers);

    }

    @Test
    public void testAddAnEvent() {
        // Create a sample EventBooking
        EventBooking eventBooking = new EventBooking();
        eventBooking.setCustomerId(1);
        eventBooking.setEventMangerId(1);
        eventBooking.setDecorationId(1);
        eventBooking.setCakeId(1);
        eventBooking.setVenueId(1);
        eventBooking.setEventDate("2023-12-31");
        eventBooking.setEventTime("18:00:00");

        // Create mock objects for related entities
        Customer customer = new Customer();
        EventManager eventManager = new EventManager();
        Decoration decoration = new Decoration();
        Cake cake = new Cake();
        Venue venue = new Venue();

        //mock
        when(customerRepository.findById(1)).thenReturn(Optional.of(customer));
        when(eventManagerServices.getEventMangerById(1)).thenReturn(eventManager);
        when(preDefineEventService.findDecorationById(1)).thenReturn(decoration);
        when(preDefineEventService.findCakeById(1)).thenReturn(cake);
        when(preDefineEventService.findVenueById(1)).thenReturn(venue);

        String result = customerService.addAnEvent(eventBooking);
        verify(eventRepository).save(any(Event.class));
        assertTrue(result.contains("Your event with event id"));

    }

}
