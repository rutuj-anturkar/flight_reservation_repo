package com.app.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.demo.custom_exception.AuthenticationFailedException;
import com.app.demo.dao.AdminRepository;
import com.app.demo.dao.FlightRepository;
import com.app.demo.dao.ScheduleRepository;
import com.app.demo.dto.AdminAuthenticationResponse;
import com.app.demo.dto.LoginRequest;
import com.app.demo.entities.Flight;
import com.app.demo.entities.FlightSchedule;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService {
	
	@Autowired
	private FlightRepository flightRepo;
	
	@Autowired
	private ScheduleRepository scheduleRepo;
	
	@Autowired
	private AdminRepository adminRepo;
	
	
		
	@Override
	public Flight addFlight(Flight newFlight) {
		return flightRepo.save(newFlight);
	}

	@Override
	public FlightSchedule addSchedule(FlightSchedule newschedule) {
		Flight flight = flightRepo.findById(newschedule.getFlight().getId()).get();
		newschedule.setAvailableSeats(flight.getCapacity());
		return scheduleRepo.save(newschedule);
	}

	@Override
	public AdminAuthenticationResponse authenticateAdmin(LoginRequest loginRequest) {
		
		adminRepo.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword()).
		orElseThrow(() -> new AuthenticationFailedException("Admin Authentication Failed.."));
		
		return new AdminAuthenticationResponse("Admin Authenticated");
	}

}
