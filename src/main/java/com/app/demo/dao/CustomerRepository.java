package com.app.demo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.demo.entities.Customer;
import com.app.demo.entities.Flight;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	Optional<Customer> findByEmailAndPassword(String email, String pwd);
	
}
