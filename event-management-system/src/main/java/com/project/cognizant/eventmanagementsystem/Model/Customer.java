package com.project.cognizant.eventmanagementsystem.Model;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
public class Customer {

    @Id
    @GeneratedValue
    private int customerId;
    private String customerName;
    private String emailId;
    private long PhoneNumber;
    @OneToOne
    private Address address;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Event> event;
    public Customer() {
    }

    public Customer(String customerName, String emailId, long phoneNumber, Address address) {
        this.customerName = customerName;
        this.emailId = emailId;
        PhoneNumber = phoneNumber;
        this.address = address;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setPhoneNumber(long phoneNumber) {
        PhoneNumber = phoneNumber;
    }

}
