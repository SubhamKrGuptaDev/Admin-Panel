package com.admin.panel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.panel.entity.User;


public interface UserRepository extends JpaRepository<User, Integer>{

	List<User> findByFirstName(String firstName);
	
	List<User> findByLastName(String lastName);
	
	List<User> findByMobileNumber(String mobileNumber);
	
	List<User> findByEmail(String email);
	
	List<User> findByCity(String city);
	
	List<User> findByPincode(String pincode);
	
}







