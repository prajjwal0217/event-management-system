package com.project.cognizant.eventmanagementsystem.Model;

import jakarta.persistence.*;

@Entity
public class PreDefineEvents {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int preEventId;
    private double totalPrice;
    @ManyToOne(cascade = CascadeType.ALL)
    private Cake cake;
    @ManyToOne(cascade = CascadeType.ALL)
    private Decoration decoration;

    public int getPreEventId() {
        return preEventId;
    }

    public void setPreEventId(int preEventId) {
        this.preEventId = preEventId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Cake getCake() {
        return cake;
    }

    public void setCake(Cake cake) {
        this.cake = cake;
    }

    public Decoration getDecoration() {
        return decoration;
    }

    public void setDecoration(Decoration decoration) {
        this.decoration = decoration;
    }

}
