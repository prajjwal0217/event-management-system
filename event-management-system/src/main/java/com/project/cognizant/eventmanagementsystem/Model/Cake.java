package com.project.cognizant.eventmanagementsystem.Model;

import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Cake {

    @Id
    @GeneratedValue
    private int cakeId;
    private String cakeName;
    private String cakeFlavour;
    private double weight;
    private double cakePrice;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Event> event;

    public Cake() {
    }

    public Cake(String cakeName, String cakeFlavour, double weight, double cakePrice) {
        this.cakeName = cakeName;
        this.cakeFlavour = cakeFlavour;
        this.weight = weight;
        this.cakePrice = cakePrice;
    }

    public void setCakeName(String cakeName) {
        this.cakeName = cakeName;
    }

    public void setCakeFlavour(String cakeFlavour) {
        this.cakeFlavour = cakeFlavour;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setCakePrice(double cakePrice) {
        this.cakePrice = cakePrice;
    }

}
