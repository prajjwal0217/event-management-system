package com.project.cognizant.eventmanagementsystem.Repository;

import com.project.cognizant.eventmanagementsystem.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
