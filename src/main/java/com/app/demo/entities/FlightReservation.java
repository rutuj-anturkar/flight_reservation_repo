package com.app.demo.entities;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/*
 *  id                | int(11) | NO   | PRI | NULL    |                |
| customer_id       | int(11) | NO   | MUL | NULL    | auto_increment |
| schedule_id       | int(11) | NO   | MUL | NULL    |                |
| num_of_passengers | int(11) | NO   |     | NULL    |                |
| reservation_date  | date    | NO   |     | NULL    |                |
| total_fare        | int(11) | YES  |     | NULL    |
 */

@Entity
@Table(name ="reservation")
@Setter
@Getter
@ToString
public class FlightReservation extends BaseEntity {

	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name="schedule_id")
	private FlightSchedule schedule;
	
	//bidirectional association between reservation-one side and passenger-many side
	//under single reservation , there can be multiple passengers travelling
	//bi dir association between Reservation 1 <----->* Passenger
	//mappedBy : to tell Hibernate about the owner of the association
	//it's value should be name of the property as it appears in the owning side
	//--------------------------
	// orphanRemoval = true => if the passenger is removed form the relationship i.e
		// list , hibernate should auto fire a delete query on passengers (child) table
	// , deleting the orphan record
	
	//to avoid cyclic dependency during ser and d-ser
	@JsonIgnoreProperties("reservation")
	@OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Passenger> passengers = new ArrayList<>();
	
	private int numOfPassengers;
	private LocalDate reservationDate;
	private int totalFare;
}
