package com.project.cognizant.eventmanagementsystem.Repository;

import com.project.cognizant.eventmanagementsystem.Model.Decoration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DecorationRepository extends JpaRepository<Decoration,Integer>{
}
