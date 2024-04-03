package com.project.cognizant.eventmanagementsystem;

import com.project.cognizant.eventmanagementsystem.Model.*;
import com.project.cognizant.eventmanagementsystem.Repository.*;
import com.project.cognizant.eventmanagementsystem.Services.CustomerService;
import com.project.cognizant.eventmanagementsystem.Services.EventManagerServices;
import com.project.cognizant.eventmanagementsystem.Services.PreDefineEventService;
import com.project.cognizant.eventmanagementsystem.dto.BookEvent;
import com.project.cognizant.eventmanagementsystem.dto.BookPreDefineEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class EventManagementSystemApplication implements CommandLineRunner {

	@Autowired
	CustomerService customerService;

	@Autowired
	EventManagerServices eventManagerServices;

	@Autowired
	PreDefineEventService preDefineEventService;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	CakeRepository cakeRepository;
	@Autowired
	DecorationRepository decorationRepository;
	@Autowired
	VenueRepository venueRepository;
	@Autowired
	EventManagerRepository eventManagerRepository;


	public static void main(String[] args) {
		SpringApplication.run(EventManagementSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		List<Cake> cakes = new ArrayList<>();
//		cakes.add(new Cake("Sweet Red Velvet Cake","Red Velvet",500.00));
//		cakes.add(new Cake("Yummy Black-Forest Cake","Black Forest",600.00));
//		cakes.add(new Cake("Chocolate Cake with kitkat","Chocolate",700.00));
//		cakes.add(new Cake("Vanilla cake with chocolate icing","vanilla",350.00));
//		cakes.add(new Cake("Strawberry cake","Strawberry",650.00));
//		cakes.add(new Cake("Kitkat cake","Chocolate",400.00));
//		cakes.add(new Cake("Pineapple Cake","Pineapple",300.00));
//		preDefineEventService.addCakes(cakes);
//		List<Decoration> decorations = new ArrayList<>();
//		decorations.add(new Decoration("normal balloon decoration with birthday tags",600));
//		decorations.add(new Decoration("medium balloon decoration with birthday tags and decorative material",800));
//		decorations.add(new Decoration("large balloon decoration with birthday tags and different design",1000));
//		decorations.add(new Decoration("large balloon decoration with birthday tags and activities such as games etc",2500));
//		preDefineEventService.addDecorations(decorations);
//		List<Venue> venues = new ArrayList<>();
//		venues.add(new Venue("venueName1", "ownerName1",999999921,"venueType1",1200,"Indore"));
//		venues.add(new Venue("venueName2", "ownerName2",999999922,"venueType2",1500,"Chennai"));
//		venues.add(new Venue("venueName3", "ownerName3",999999923,"venueType3",1200,"Pune"));
//		venues.add(new Venue("venueName4", "ownerName4",999999924,"venueType4",1100,"Indore"));
//		venues.add(new Venue("venueName5", "ownerName5",999999925,"venueType5",1000,"Jaipur"));
//		venues.add(new Venue("venueName6", "ownerName6",999999926,"venueType6",1100,"Delhi"));
//		preDefineEventService.addVenues(venues);
//		eventManagerServices.getNewEventManger(new EventManager("eventName1", "eventManagerEmailId1@mail.com", 999888821,500,"Indore"));
//		eventManagerServices.getNewEventManger(new EventManager("eventName2", "eventManagerEmailId2@mail.com", 999888822,500,"Indore"));
//		eventManagerServices.getNewEventManger(new EventManager("eventName3", "eventManagerEmailId3@mail.com", 999888823,500,"Indore"));
//		eventManagerServices.getNewEventManger(new EventManager("eventName4", "eventManagerEmailId4@mail.com", 999888824,500,"Chennai"));
//		eventManagerServices.getNewEventManger(new EventManager("eventName5", "eventManagerEmailId5@mail.com", 999888825,500,"Chennai"));
//		eventManagerServices.getNewEventManger(new EventManager("eventName6", "eventManagerEmailId6@mail.com", 999888826,500,"Chennai"));
//		eventManagerServices.getNewEventManger(new EventManager("eventName7", "eventManagerEmailId7@mail.com", 999888827,500,"Pune"));
//		eventManagerServices.getNewEventManger(new EventManager("eventName8", "eventManagerEmailId8@mail.com", 999888828,500,"Pune"));
//		eventManagerServices.getNewEventManger(new EventManager("eventName9", "eventManagerEmailId9@mail.com", 999888829,500,"Jaipur"));
//		eventManagerServices.getNewEventManger(new EventManager("eventName10", "eventManagerEmailId10@mail.com", 999888831,500,"Jaipur"));
//		eventManagerServices.getNewEventManger(new EventManager("eventName11", "eventManagerEmailId111@mail.com", 999888832,500,"Delhi"));
//		eventManagerServices.getNewEventManger(new EventManager("eventName12", "eventManagerEmailId12@mail.com", 999888833,500,"Delhi"));
//		//USI001
//		customerService.addAnCustomer(new Customer("customerName1", "emailId1@mail.com",88888881,"Indore"));
//		customerService.addAnCustomer(new Customer("customerName2", "emailId2@mail.com",88888882,"Delhi"));
//		customerService.addAnCustomer(new Customer("customerName3", "emailId3@mail.com",88888883,"Jaipur"));
//		customerService.addAnCustomer(new Customer("customerName4", "emailId4@mail.com",88888884,"Indore"));
//		customerService.addAnCustomer(new Customer("customerName5", "emailId5@mail.com",88888885,"Chennai"));
//		customerService.addAnCustomer(new Customer("customerName6", "emailId6@mail.com",88888886,"Indore"));
//		customerService.addAnCustomer(new Customer("customerName7", "emailId7@mail.com",88888887,"Delhi"));
//		customerService.addAnCustomer(new Customer("customerName8", "emailId8@mail.com",88888888,"Indore"));
//
//		//preDefineEventsRepository.saveAll();
//
//		//USI003
//		List<EventManager> eventManagers =customerService.viewEventManager(1);
//		for(EventManager e: eventManagers){
//			System.out.println(e.toString());
//		}
//		Customer customer = customerRepository.findById(1).orElseThrow();
//		EventManager eventManager = eventManagerRepository.findById(1).orElseThrow();
//		Cake cake = cakeRepository.findById(1).orElseThrow();
//		Decoration decoration = decorationRepository.findById(1).orElseThrow();
//		Venue venue = venueRepository.findById(1).orElseThrow();
//		BookEvent bookEvent = new BookEvent(customer,eventManager,cake,decoration,venue);
//		customerService.addAnEvent(bookEvent);
//		Customer customer1 = customerRepository.findById(2).orElseThrow();
//		EventManager eventManager1 = eventManagerRepository.findById(2).orElseThrow();
//		Cake cake1 = cakeRepository.findById(2).orElseThrow();
//		Decoration decoration1 = decorationRepository.findById(2).orElseThrow();
//		Cake cake2 = cakeRepository.findById(2).orElseThrow();
//		Decoration decoration2 = decorationRepository.findById(2).orElseThrow();
//		Cake cake3 = cakeRepository.findById(2).orElseThrow();
//		Decoration decoration3 = decorationRepository.findById(2).orElseThrow();
//		Cake cake4 = cakeRepository.findById(2).orElseThrow();
//		Decoration decoration4 = decorationRepository.findById(2).orElseThrow();
//		Venue venue1 = venueRepository.findById(2).orElseThrow();
//		List<PreDefineEvents> preDefineEvents = new ArrayList<>();
//		preDefineEvents.add(new PreDefineEvents(cake1,decoration1));
//		preDefineEvents.add(new PreDefineEvents(cake1,decoration));
//		preDefineEvents.add(new PreDefineEvents(cake,decoration));
//		preDefineEvents.add(new PreDefineEvents(cake,decoration1));
//		preDefineEvents.add(new PreDefineEvents(cake2,decoration1));
//		preDefineEvents.add(new PreDefineEvents(cake2,decoration));
//		preDefineEvents.add(new PreDefineEvents(cake3,decoration3));
//		preDefineEvents.add(new PreDefineEvents(cake4,decoration4));
//		preDefineEventService.addToPreDefineEvents(preDefineEvents);
//		//BookPreDefineEvent bookPreDefineEvent = new BookPreDefineEvent(customer1,eventManager1,preDefineEvents,venue1);
//		//customerService.addPreDefineEvent(bookPreDefineEvent);
//		Customer customer =customerRepository.findById(1).orElseThrow();
//		System.out.println(customer.getEmailId());
	}
}
