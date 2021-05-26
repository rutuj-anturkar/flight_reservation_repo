package com.app.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/*
 *  id         | int(11)     | NO   | PRI | NULL    | auto_increment |
| first_name | varchar(45) | NO   |     | NULL    |                |
| last_name  | varchar(45) | NO   |     | NULL    |                |
| email      | varchar(45) | NO   | UNI | NULL    |                |
| password   | varchar(45) | NO   |     | NULL
 */
@Entity
@Table(name ="customer")
@Setter
@Getter
@ToString
public class Customer extends BaseEntity {
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
}
