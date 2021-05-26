package com.app.demo;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.demo.dao.ScheduleRepository;
import com.app.demo.service.CustomerServiceImpl;
import com.app.demo.service.ICustomerService;

@SpringBootTest
class SpringBootRestDemo1ApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private ScheduleRepository schRepo;
	
	@Autowired 
	private ICustomerService service;
	

	@Test
	void TestScheduleDao() {
		schRepo.findByFlightFromLocationAndFlightToLocationAndDepartureDate("Mumbai", "New York", LocalDate.parse("2021-05-18"))
				.forEach(s -> System.out.println(s));
	}
	

	@Test
	void TestCustService() {
		service.checkReservation(3);
	}
	

}
