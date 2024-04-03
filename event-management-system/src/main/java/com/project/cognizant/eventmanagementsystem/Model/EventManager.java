package com.project.cognizant.eventmanagementsystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class EventManager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventManagerId;
    private String eventName;
    private String eventManagerEmailId;
    private long eventManagerPhoneNumber;
    private double eventManagerPrice;
    private int rating;
    private String city;
    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Event> eventList;

    public EventManager(String eventName, String eventManagerEmailId, long eventManagerPhoneNumber, double eventManagerPrice,String city) {
        this.eventName = eventName;
        this.eventManagerEmailId = eventManagerEmailId;
        this.eventManagerPhoneNumber = eventManagerPhoneNumber;
        this.eventManagerPrice = eventManagerPrice;
        this.city = city;
    }

    @Override
    public String toString() {
        return "EventManager{" +
                "eventManagerId=" + eventManagerId +
                ", eventName='" + eventName + '\'' +
                ", eventManagerEmailId='" + eventManagerEmailId + '\'' +
                ", eventManagerPhoneNumber=" + eventManagerPhoneNumber +
                ", eventManagerPrice=" + eventManagerPrice +
                ", rating=" + rating +
                ", city='" + city + '\'' +
                '}';
    }
}
