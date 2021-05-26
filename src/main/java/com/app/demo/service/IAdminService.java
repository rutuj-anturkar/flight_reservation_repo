package com.app.demo.service;

import com.app.demo.dto.AdminAuthenticationResponse;
import com.app.demo.dto.LoginRequest;
import com.app.demo.entities.Flight;
import com.app.demo.entities.FlightSchedule;



public interface IAdminService {
	
	AdminAuthenticationResponse authenticateAdmin(LoginRequest loginRequest);
	
	Flight addFlight(Flight flight);
	
	FlightSchedule addSchedule(FlightSchedule schedule);
	

}
