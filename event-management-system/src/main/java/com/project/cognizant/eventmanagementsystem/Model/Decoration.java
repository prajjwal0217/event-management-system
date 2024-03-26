package com.project.cognizant.eventmanagementsystem.Model;

import jakarta.persistence.*;
import lombok.Getter;
import java.util.List;

@Entity
@Getter
public class Decoration {

    @Id
    @GeneratedValue
    private int decorationId;
    private String decorationType;
    private double decorationPrice;

    @OneToMany(cascade = CascadeType.ALL)
    private  List<Event> eventList;
    public Decoration() {
    }

    public Decoration(String decorationType, double decorationPrice) {
        this.decorationType = decorationType;
        this.decorationPrice = decorationPrice;
    }

    public void setDecorationType(String decorationType) {
        this.decorationType = decorationType;
    }

    public void setPrice(double decorationPrice) {
        this.decorationPrice = decorationPrice;
    }

}