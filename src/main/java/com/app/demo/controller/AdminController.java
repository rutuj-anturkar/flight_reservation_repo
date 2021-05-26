package com.app.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.demo.dto.LoginRequest;
import com.app.demo.entities.Flight;
import com.app.demo.entities.FlightSchedule;
import com.app.demo.service.IAdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	
	@Autowired
	private IAdminService adminService;
	
	@PostMapping("/auth")
	 public ResponseEntity<?> AuthenticateAdmin(@RequestBody LoginRequest loginRequest) {
		System.out.println("Login Request"+ loginRequest.getEmail() +" "+ loginRequest.getPassword());
		return new ResponseEntity<>(adminService.authenticateAdmin(loginRequest), HttpStatus.OK);
		
	}
	
	@PostMapping("/addFlight")
	public ResponseEntity<?> addFlight(@RequestBody Flight newFlight) {
		return new ResponseEntity<>(adminService.addFlight(newFlight), HttpStatus.OK);
	}
	
	@PostMapping("/addSchedule")
	public ResponseEntity<?> addSchedule(@RequestBody FlightSchedule newSchedule){
		return new ResponseEntity<>(adminService.addSchedule(newSchedule), HttpStatus.OK);
		
	}
}
