package com.app.demo.dto;

import java.time.LocalDate;

import com.app.demo.entities.FlightReservation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CheckReservationResponse {
	
	private FlightReservation reservation;
	private String from;
	private String to;
	private LocalDate departureDate;

}
