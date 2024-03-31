package com.project.cognizant.eventmanagementsystem.Repository;

import com.project.cognizant.eventmanagementsystem.Model.Cake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CakeRepository extends JpaRepository<Cake,Integer>{
}
