package com.app.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlightReservationResponse {
	
	private int ReservationId;
	private int noOfPassengers;
	private int totalFare;

}
