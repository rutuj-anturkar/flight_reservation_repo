package com.app.demo.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.demo.entities.FlightSchedule;

public interface ScheduleRepository extends JpaRepository<FlightSchedule, Integer> {
	List<FlightSchedule> findByFlightFromLocationAndFlightToLocationAndDepartureDate
					(String from,String to, LocalDate departureDate);
}
