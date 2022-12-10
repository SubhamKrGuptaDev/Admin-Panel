package com.admin.panel.service;

import java.util.List;
import java.util.TreeMap;

import com.admin.panel.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;

public interface UserService {

//	Find Methods
	public List<User> findAllUser();

	public User findUserById(int id);

//	Custom Find Methods
	List<User> findByFirstName(String firstName);

	List<User> findByLastName(String lastName);

	List<User> findByMobileNumber(String mobileNumber);

	List<User> findByEmail(String email);

	List<User> findByCity(String city);

	List<User> findByPincode(String pincode);

//	Created Methods
	public User createUser(User user);

	public List<User> listUserCreate(List<User> listUser);

//	Update Methods
	public User updateUser(int id, User user);

//	Delete Methods
	public String deleteUsers();

	public String deleteUserById(int id);

	
//	Calculate Methods
	
	public TreeMap<String, Integer> getPincodeCalculate(); // Pincode
	
	public TreeMap<String, Integer> getCityCalculate();	// City
	
	public TreeMap<String, List<String>> getCityWithPincode();	// City With Pincode 
	
	
	
	
//	Comparator Class
	public List<User> getSortUserWithFirstName();
	
	public List<User> getSortUserWithLastName();
	
	public List<User> getSortUserWIthCity();
	
	public List<User> getDesendingUserPincode();
	public List<User> getSortUserPincode();
	
}










