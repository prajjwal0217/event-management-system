package com.project.cognizant.eventmanagementsystem.Model;

import jakarta.persistence.*;
import lombok.Getter;
import java.util.List;

@Entity
@Getter
public class Decoration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int decorationId;
    private String decorationType;
    private double decorationPrice;
    @OneToMany(cascade = CascadeType.ALL)
    private  List<Event> eventList;

    public int getDecorationId() {
        return decorationId;
    }

    public void setDecorationId(int decorationId) {
        this.decorationId = decorationId;
    }

    public String getDecorationType() {
        return decorationType;
    }

    public void setDecorationType(String decorationType) {
        this.decorationType = decorationType;
    }

    public double getDecorationPrice() {
        return decorationPrice;
    }

    public void setDecorationPrice(double decorationPrice) {
        this.decorationPrice = decorationPrice;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }
}