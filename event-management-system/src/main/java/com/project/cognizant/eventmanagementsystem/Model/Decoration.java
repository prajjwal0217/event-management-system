package com.project.cognizant.eventmanagementsystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Decoration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int decorationId;
    private String decorationType;
    private double decorationPrice;
    @OneToMany
    @JsonIgnore
    private  List<Event> eventList;

    public Decoration(String decorationType, double decorationPrice) {
        this.decorationType = decorationType;
        this.decorationPrice = decorationPrice;
    }

}