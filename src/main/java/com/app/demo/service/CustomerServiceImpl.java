package com.app.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.demo.custom_exception.AuthenticationFailedException;
import com.app.demo.dao.CustomerRepository;
import com.app.demo.dao.ReservationRepository;
import com.app.demo.dao.ScheduleRepository;
import com.app.demo.dto.CheckReservationResponse;
import com.app.demo.dto.FlightReservationResponse;
import com.app.demo.dto.LoginRequest;
import com.app.demo.dto.SearchFlightRequest;
import com.app.demo.dto.SearchFlightResponse;
import com.app.demo.entities.Customer;
import com.app.demo.entities.Flight;
import com.app.demo.entities.FlightReservation;
import com.app.demo.entities.FlightSchedule;

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	CustomerRepository custRepo;
	
	@Autowired
	ScheduleRepository schRepo;
	
	@Autowired
	ReservationRepository reservationRepo;
	
	
	@Override
	public Customer loginCustomer(LoginRequest loginRequest) {
		
		return custRepo.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword()).
														orElseThrow(()-> new AuthenticationFailedException("Customer Login Failed.."));
	}

	@Override
	public Customer registerCustomer(Customer newCustomer) {
		return custRepo.save(newCustomer);
	}

	@Override
	public SearchFlightResponse searchFlights(SearchFlightRequest request) {
	
		List<FlightSchedule> flights= schRepo.findByFlightFromLocationAndFlightToLocationAndDepartureDate
				(request.getDepartureCity(), request.getArrivalCity(), request.getDepartureDate());
	
		return new SearchFlightResponse(flights);
	}

	@Override
	public FlightReservationResponse reserveFlight(FlightReservation reservation) {
		//get schedule from reservation
		FlightSchedule schedule = schRepo.findById(reservation.getSchedule().getId()).get();
		reservation.setTotalFare(schedule.getFare()*reservation.getNumOfPassengers());
		reservation.setReservationDate(LocalDate.now());
		int available = reservation.getSchedule().getAvailableSeats();
		reservation.getSchedule().setAvailableSeats(available-reservation.getNumOfPassengers());
		//set the inverse relationship from passenger->reservation
		reservation.getPassengers().forEach(p->p.setReservation(reservation));
		reservationRepo.save(reservation);
		return new FlightReservationResponse(reservation.getId(),reservation.getNumOfPassengers(),reservation.getTotalFare());
	}

	@Override
	public CheckReservationResponse checkReservation(int resId) {
		FlightReservation reservation = reservationRepo.findById(resId).
				orElseThrow(()->new RuntimeException("Reservation ID invalid"));
		
		FlightSchedule schedule = reservation.getSchedule();
		Flight flight = schedule.getFlight();
		System.out.println(schedule);
		System.out.println(flight);
		return new CheckReservationResponse(reservation, flight.getFromLocation(), flight.getToLocation(), schedule.getDepartureDate());
	}
	

}
