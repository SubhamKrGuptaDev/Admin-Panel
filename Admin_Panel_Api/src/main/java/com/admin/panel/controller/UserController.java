package com.admin.panel.controller;

import java.util.List;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admin.panel.entity.User;
import com.admin.panel.service.UserService;
import com.admin.panel.service.UserServiceImpl;
import com.twilio.http.Response;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
//	Get APIs
	
	@GetMapping("/get") 
	@Operation(summary = "Get All User", tags = "Admin Operation")
	public ResponseEntity<?> getAllUser() {
		logger.info("inside getAllUser() -> ");
		return ResponseEntity.ok(service.findAllUser());
	}
	
	@GetMapping("/get/{id}")
	@Operation(summary = "Get User By Id", tags = "Admin Operation")
	public ResponseEntity<?> getUserById(@PathVariable int id) {
		logger.info("inside getUserById() -> id : {}",id);		
		return ResponseEntity.ok(service.findUserById(id));
	}
	
//	Create APIs 
	
	@PostMapping("/add")
	@Operation(summary = "Create User", tags = "Admin Operation")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		logger.info("inside createUser() -> User : {}",user);
		return ResponseEntity.ok(service.createUser(user));
	}
	
	@PostMapping("/addlist")
	@Operation(summary = "Create User List",tags = "Admin Operation")
	public ResponseEntity<?> createUserList(@RequestBody List<User> user) {
		logger.info("inside createUserList() -> List of User : {}",user);
		return ResponseEntity.ok(service.listUserCreate(user));
	}
	
	
//	Update APIs
	
	@PutMapping("/update/{id}")
	@Operation(summary = "Update User", tags = "Admin Operation")
	public ResponseEntity<?> updateUser(@PathVariable("id") int id, @RequestBody User user) {
		logger.info("inside updateUser() -> id : {} | User : {}",id,user);
		return ResponseEntity.ok(service.updateUser(id,user));
	}
	
//	Delete APIs
	
	@DeleteMapping("/deleteAll")
	@Operation(summary = "Delete All Users", tags = "Admin Operation")
	public ResponseEntity<?> deleteAll() {
		logger.warn("inside deleteAll() -> ");
		return ResponseEntity.ok(service.deleteUsers());
	}
	
	@DeleteMapping("/delete/{id}")
	@Operation(summary = "Delete User By Id", tags = "Admin Operation")
	public ResponseEntity<?> deleteUserById(@PathVariable("id") int id) {
		return ResponseEntity.ok(service.deleteUserById(id));
	}
	
//	User Searching APIs
	
	@GetMapping("/firstname/{firstName}")
	@Operation(summary = "Find User By First Name", tags = "Admin Operation") 
	public ResponseEntity<?> findUserByFirstName(@PathVariable("firstName") String firstName) {
		logger.info("========== Find By First Name Method Start ==========");
		logger.info("inside findUserByFirstName() -> First Name : {}", firstName);
		
		List<User> list = service.findByFirstName(firstName);
		
		logger.info("========== Find By First Name Method End ==========");
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/lastname/{lastName}")
	@Operation(summary = "Find User By Last Name", tags = "Admin Operation")
	public ResponseEntity<?> findUserByLastName(@PathVariable("lastName") String lastName) {
		
		List<User> list = service.findByLastName(lastName);
		
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/mobilenumber/{mobileNumber}")
	@Operation(summary = "Find User By Mobile Number",tags = "Admin Operation")
	public ResponseEntity<?> findUserByMobileNumber(@PathVariable("mobileNumber") String mobileNumber) {
		return ResponseEntity.ok(service.findByMobileNumber(mobileNumber));
	}
	
	
	@GetMapping("/email/{email}")
	@Operation(summary = "Find User By Email", tags = "Admin Operation")
	public ResponseEntity<?> findUserByEmail(@PathVariable("email") String email) {
		
		List<User> list = service.findByEmail(email);
		
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/city/{city}")
	@Operation(summary = "Find User By City",tags = "Admin Operaton")
	public ResponseEntity<?> findUserByCity(@PathVariable("city") String city) {
		
		List<User> list = service.findByCity(city);
		
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/pincode/{pincode}")
	@Operation(summary = "Find User By Pincode", tags = "Admin Operation")
	public ResponseEntity<?> findUserByPincode(@PathVariable("pincode") String pincode) {
		
		List<User> list = service.findByPincode(pincode);
		
		return ResponseEntity.ok(list);
	}
	
	
//	Calculate Data
//	Pincode Calculate
	@GetMapping("/pincode/cal")
	@Operation(summary = "find all pincode and count", tags = "User Calculate")
	public ResponseEntity<Object> getPincodeCalculate() {
		return ResponseEntity.ok(service.getPincodeCalculate());
	}
	
	@GetMapping("/city/cal")
	@Operation(summary = "find all city and count", tags = "User Calculate")
	public ResponseEntity<Object> getCityCalculate() {
		return ResponseEntity.ok(service.getCityCalculate());
	}
	
	@GetMapping("/citywithpincode/cal")
	@Operation(summary = "find all city and list of pincode", tags = "User Calculate")
	public ResponseEntity<Object> getCityWithPincode() {
		return ResponseEntity.ok(service.getCityWithPincode());
	}
	
//	Comparator Methods
	
	@GetMapping("/getFirstNameSort")
	@Operation(summary = "Sort Users with First Name", tags = "Sort Methods")
	public ResponseEntity<List<User>> getAllUserWithFirstSort() {
		return ResponseEntity.ok(service.getSortUserWithFirstName());
	}
	
	@GetMapping("/getLastNameSort")
	@Operation(summary = "Sort Users with Last Name", tags = "Sort Methods")
	public ResponseEntity<List<User>> getAllUserWithLastSort() {
		return ResponseEntity.ok(service.getSortUserWithLastName());
	}
	
	@GetMapping("/getCitySort")
	@Operation(summary = "Sort Users with City", tags = "Sort Methods")
	public ResponseEntity<List<User>> getAllUserWithCity() {
		return ResponseEntity.ok(service.getSortUserWIthCity());
	}
	
	@GetMapping("/getPincodeDeSort")
	@Operation(summary = "Desending Order Users with Pincode", tags = "Sort Methods")
	public ResponseEntity<List<User>> getDesendingUserPincode() {
		return ResponseEntity.ok(service.getDesendingUserPincode());
	}
	
	@GetMapping("/getPincodeSort")
	@Operation(summary = "Asending Order Users with Pincode", tags = "Sort Methods")
	public ResponseEntity<List<User>> getSortUserPincode() {
		return ResponseEntity.ok(service.getSortUserPincode());
	}
	
}









