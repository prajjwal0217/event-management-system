package com.project.cognizant.eventmanagementsystem.Repository;

import com.project.cognizant.eventmanagementsystem.Model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Integer> {
}
