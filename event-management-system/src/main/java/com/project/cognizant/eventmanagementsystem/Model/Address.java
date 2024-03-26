package com.project.cognizant.eventmanagementsystem.Model;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Address {
    
    @Id
    @GeneratedValue
    private int addressId;
    private String addressLine;
    private String city;
    private String state;
    private String addressType;
    private int zipcode;

    @OneToOne(cascade = CascadeType.ALL)
    private Customer customer;
    @OneToOne(cascade = CascadeType.ALL)
    private EventManager eventManager;
    @OneToOne(cascade = CascadeType.ALL)
    private  Venue venue;

    public Address() {
        super();
    }

    public Address(String addressLine, String city, String state, String addressType, int zipcode) {
        super();
        this.addressLine = addressLine;
        this.city = city;
        this.state = state;
        this.addressType = addressType;
        this.zipcode = zipcode;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }
}
