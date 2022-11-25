package com.admin.panel.dao;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.admin.panel.entity.User;
import com.admin.panel.repository.UserRepository;

@Component
public class UserDaoImpl implements UserDao{

	@Autowired
	private UserRepository repository;
	
	Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	
//	Get User Methods
	
	@Override
	public List<User> findAllUser() {
		logger.info("inside getAllUser() -> ");
		return repository.findAll();
	}
	
	@Override
	public User findUserById(int id) {
		
		Optional<User> optional = repository.findById(id);
		
		return optional.get();
	}
	
//	Create User Methods
	
	@Override
	public User createUser(User user) {
		logger.info("inside createUser() -> User : {}",user);
		return repository.save(user);
	}

	@Override
	public List<User> listUserCreate(List<User> listUser) {
		
		return repository.saveAll(listUser);
	}

//	Delete User Methods
	
	@Override
	public String deleteUsers() {
		logger.warn("inside deleteAll() -> ");
		repository.deleteAll();
		
		return "deleted...";
	}
	
	@Override
	public String deleteUserById(int id) {
		
		repository.deleteById(id);
		
		return "deleted...";
	}

//	Update User Methods
	@Override
	public User updateUser(User user) {
		
		return repository.save(user);
	}

//	Custom Find Methods
	
	@Override
	public List<User> findByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return repository.findByFirstName(firstName);
	}

	@Override
	public List<User> findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return repository.findByLastName(lastName);
	}

	@Override
	public List<User> findByMobileNumber(String mobileNumber) {
		// TODO Auto-generated method stub
		return repository.findByMobileNumber(mobileNumber);
	}

	@Override
	public List<User> findByEmail(String email) {
		// TODO Auto-generated method stub
		return repository.findByEmail(email);
	}

	@Override
	public List<User> findByCity(String city) {
		// TODO Auto-generated method stub
		return repository.findByCity(city);
	}

	@Override
	public List<User> findByPincode(String pincode) {
		// TODO Auto-generated method stub
		return repository.findByPincode(pincode);
	}

	


	

}






