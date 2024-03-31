package com.project.cognizant.eventmanagementsystem.Repository;

import com.project.cognizant.eventmanagementsystem.Model.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VenueRepository extends JpaRepository<Venue,Integer>{
    public List<Venue> findByCity(String city);
}
