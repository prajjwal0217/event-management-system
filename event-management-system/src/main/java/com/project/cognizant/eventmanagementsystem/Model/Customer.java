package com.project.cognizant.eventmanagementsystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    private String customerName;
    private String emailId;
    private long PhoneNumber;
    private String city;
    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Event> event;

    public Customer(String customerName, String emailId, long phoneNumber, String city) {
        this.customerName = customerName;
        this.emailId = emailId;
        PhoneNumber = phoneNumber;
        this.city = city;
    }
}
