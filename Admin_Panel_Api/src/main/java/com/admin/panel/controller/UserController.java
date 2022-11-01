package com.admin.panel.controller;

import java.util.List;

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
	
//	Searching APIs
	
	
	
//	Calculate Data 
	
	
	
}







