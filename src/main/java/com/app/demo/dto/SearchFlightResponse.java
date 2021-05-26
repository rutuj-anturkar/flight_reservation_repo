package com.app.demo.dto;

import java.util.List;

import com.app.demo.entities.FlightSchedule;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SearchFlightResponse {
	List<FlightSchedule> schedules;
}
