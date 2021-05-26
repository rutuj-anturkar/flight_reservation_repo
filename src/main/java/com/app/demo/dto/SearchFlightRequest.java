package com.app.demo.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchFlightRequest {

		private String departureCity;
		private String arrivalCity;
		private LocalDate departureDate;
		
}
