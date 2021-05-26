package com.app.demo.service;

import com.app.demo.dto.CheckReservationResponse;
import com.app.demo.dto.FlightReservationResponse;
import com.app.demo.dto.LoginRequest;
import com.app.demo.dto.SearchFlightRequest;
import com.app.demo.dto.SearchFlightResponse;
import com.app.demo.entities.Customer;
import com.app.demo.entities.FlightReservation;

public interface ICustomerService {
	
	Customer loginCustomer(LoginRequest loginRequest);
	
	Customer registerCustomer(Customer newCustomer);
	
	SearchFlightResponse searchFlights(SearchFlightRequest request);
	
	FlightReservationResponse reserveFlight(FlightReservation reservation); 
	
	CheckReservationResponse checkReservation(int resId);

}
