package com.project.cognizant.eventmanagementsystem.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class PreDefineEvents {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int preEventId;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Cake cake;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Decoration decoration;

    public PreDefineEvents(Cake cake, Decoration decoration) {
        this.cake = cake;
        this.decoration = decoration;
    }

}
