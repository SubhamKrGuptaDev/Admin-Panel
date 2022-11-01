package com.admin.panel.entity;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {
	
	@Id
	@GeneratedValue
	private int id;

	private String firstName;
	
	private String lastName;
	
	private String mobileNumber;
	
	private String email;
	
	private String password;
	
	private String adress;
	
	private String city;
	
	private String pincode;
}








