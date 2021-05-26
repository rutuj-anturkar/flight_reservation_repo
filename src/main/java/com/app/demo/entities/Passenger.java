package com.app.demo.entities;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/*
 * ---------------+-------------+------+-----+---------+----------------+
| id             | int(11)     | NO   | PRI | NULL    | auto_increment |
| reservation_id | int(11)     | NO   | MUL | NULL    |                |
| first_name     | varchar(45) | YES  |     | NULL    |                |
| last_name      | varchar(45) | YES  |     | NULL    |
 */

@Entity
@Table(name ="passenger")
@Setter
@Getter
@ToString
public class Passenger extends BaseEntity {
	
	@JsonIgnoreProperties("passengers")
	@ManyToOne
	@JoinColumn(name="reservation_id")
	private FlightReservation reservation;
	
	private String firstName;
	private String lastName;
	
	

}
