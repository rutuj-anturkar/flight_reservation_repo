package com.app.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.demo.entities.*;

public interface ReservationRepository extends JpaRepository<FlightReservation, Integer> {

}
