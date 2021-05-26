package com.app.demo.entities;


import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
id            | int(11)     | NO   | PRI | NULL    | auto_increment |
| from_location | varchar(45) | NO   |     | NULL    |                |
| to_location   | varchar(45) | NO   |     | NULL    |                |
| capacity      | int(11)     | NO   |     | NULL
*/

@Entity
@Table(name ="flight")
@Setter
@Getter
@ToString
public class Flight extends BaseEntity{
	
	private String fromLocation;
	private String toLocation;
	private int capacity;
	
	

}
