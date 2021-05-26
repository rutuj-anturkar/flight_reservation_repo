package com.app.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.demo.dto.LoginRequest;
import com.app.demo.dto.SearchFlightRequest;
import com.app.demo.entities.Customer;
import com.app.demo.entities.FlightReservation;
import com.app.demo.service.ICustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	
	@Autowired
	private ICustomerService custService;
	
	@PostMapping("/auth")
	private ResponseEntity<?> loginCustomer(@RequestBody LoginRequest request) {
		return new ResponseEntity<>(custService.loginCustomer(request), HttpStatus.OK);
	}
	
	@PostMapping("/register")
	private ResponseEntity<?> registerCustomer(@RequestBody Customer newCustomer){
		return new ResponseEntity<>(custService.registerCustomer(newCustomer), HttpStatus.OK);
	}
	
	@PostMapping("/searchFlights")
	private ResponseEntity<?> searchFlights(@RequestBody SearchFlightRequest request)
	{
		return new ResponseEntity<>(custService.searchFlights(request), HttpStatus.OK);
	}
	
	@PostMapping("/reserve")
	private ResponseEntity<?> reserveFlight(@RequestBody FlightReservation reservation){
		return new ResponseEntity<>(custService.reserveFlight(reservation), HttpStatus.OK);
	}
	
	@GetMapping("/checkReservation/{id}")
	private ResponseEntity<?> checkReservation(@PathVariable int id){
		return new ResponseEntity<>(custService.checkReservation(id), HttpStatus.OK);
	}
}
