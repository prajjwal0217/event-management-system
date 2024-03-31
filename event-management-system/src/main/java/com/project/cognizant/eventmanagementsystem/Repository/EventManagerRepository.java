package com.project.cognizant.eventmanagementsystem.Repository;

import com.project.cognizant.eventmanagementsystem.Model.EventManager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventManagerRepository extends JpaRepository<EventManager,Integer> {
    public List<EventManager> findByCity(String city);
}
