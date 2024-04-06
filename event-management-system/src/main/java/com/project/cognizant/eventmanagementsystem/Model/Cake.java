package com.project.cognizant.eventmanagementsystem.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Cake {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cakeId;
    private String cakeName;
    private double cakePrice;
    //private double weight
    @OneToMany(mappedBy = "cake")
    @JsonIgnore
    private List<Event> event;
    @OneToMany(mappedBy = "cake")
    @JsonIgnore
    private List<PreDefineEvents> preDefineEvents;

    public Cake(String cakeName, String cakeFlavour, double cakePrice) {
        this.cakeName = cakeName;
        this.cakePrice = cakePrice;
    }

}
