package com.project.cognizant.eventmanagementsystem.Repository;

import com.project.cognizant.eventmanagementsystem.Model.EventManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventManagerRepository extends JpaRepository<EventManager,Integer> {
    public List<EventManager> findByCity(String city);
}
