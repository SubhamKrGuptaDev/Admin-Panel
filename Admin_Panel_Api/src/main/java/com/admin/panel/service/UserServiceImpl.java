package com.admin.panel.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.panel.dao.UserDao;
import com.admin.panel.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

//	Find Methods

	@Override
	public List<User> findAllUser() {
		logger.info("inside getAllUser() -> ");
		return dao.findAllUser();
	}

	@Override
	public User findUserById(int id) {
		logger.info("inside findUserById() -> id : {}", id);

		return dao.findUserById(id);
	}

//	Created Methods

	@Override
	public User createUser(User user) {
		logger.info("inside createUser() -> User : {}", user);

		return dao.createUser(user);
	}

//	Delete Methods

	@Override
	public String deleteUsers() {
		logger.warn("inside deleteAll() -> ");
		return dao.deleteUsers();
	}

	@Override
	public String deleteUserById(int id) {

		return dao.deleteUserById(id);
	}

//	Update Methods

	@Override
	public User updateUser(int id, User user) {
		logger.info("inside updateUser() -> id : {} | User : {}", id, user);

		User getUser = dao.findUserById(id);

		if (getUser != null) {
			getUser.setFirstName(user.getFirstName());
			getUser.setLastName(user.getLastName());
			getUser.setMobileNumber(user.getMobileNumber());
			getUser.setEmail(user.getEmail());
			getUser.setPassword(user.getPassword());
			getUser.setAdress(user.getAdress());
			getUser.setCity(user.getCity());
			getUser.setPincode(user.getPincode());

			return dao.updateUser(getUser);

		}

		return null;
	}

	@Override
	public List<User> listUserCreate(List<User> listUser) {

		return dao.listUserCreate(listUser);
	}

//	Custom Find Methods

	@Override
	public List<User> findByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return dao.findByFirstName(firstName);
	}

	@Override
	public List<User> findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return dao.findByLastName(lastName);
	}

	@Override
	public List<User> findByMobileNumber(String mobileNumber) {
		// TODO Auto-generated method stub
		return dao.findByMobileNumber(mobileNumber);
	}

	@Override
	public List<User> findByEmail(String email) {
		// TODO Auto-generated method stub
		return dao.findByEmail(email);
	}

	@Override
	public List<User> findByCity(String city) {
		// TODO Auto-generated method stub
		return dao.findByCity(city);
	}

	@Override
	public List<User> findByPincode(String pincode) {
		// TODO Auto-generated method stub
		return dao.findByPincode(pincode);
	}

//	Calculate methods 
//	Pincode Calculate
	@Override
	public TreeMap<String, Integer> getPincodeCalculate() {

		List<User> listOfUser = findAllUser();

		TreeMap<String, Integer> tm = new TreeMap<>();

		listOfUser.forEach((user) -> {

			tm.put(user.getPincode(), tm.getOrDefault(user.getPincode(), 0) + 1);

		});

		return tm;
	}

//	City Calculate
	@Override
	public TreeMap<String, Integer> getCityCalculate() {

		List<User> listOfUser = findAllUser();

		TreeMap<String, Integer> tm = new TreeMap<>();

		listOfUser.forEach((user) -> {

			tm.put(user.getCity(), tm.getOrDefault(user.getCity(), 0) + 1);

		});

		return tm;
	}

//	City With Pincode
	@Override
	public TreeMap<String, List<String>> getCityWithPincode() {
		List<User> listOfUser = findAllUser();

		TreeMap<String, List<String>> tm = new TreeMap<>();

		for (User user : listOfUser) {

			if (tm.isEmpty()) {
				tm.put(user.getCity(), Arrays.asList(user.getPincode()));
			} else {

				if (tm.containsKey(user.getCity())) {
					List<String> list = tm.get(user.getCity());

					list.add(user.getPincode());

					tm.put(user.getCity(), list);
				} else {
					tm.put(user.getCity(), Arrays.asList(user.getPincode()));
				}

			}

		}

		return tm;
	}

//	Comparator Methods

	@Override
	public List<User> getSortUserWithFirstName() {
		List<User> list = dao.findAllUser();

		Collections.sort(list, new Comparator<User>() {

			@Override
			public int compare(User o1, User o2) {

				return o1.getFirstName().compareTo(o2.getFirstName());
			}
		});
		return list;
	}

	@Override
	public List<User> getSortUserWithLastName() {
		List<User> list = dao.findAllUser();

		Collections.sort(list, new Comparator<User>() {

			@Override
			public int compare(User o1, User o2) {

				return o1.getLastName().compareTo(o2.getLastName());
			}

		});

		return list;
	}

	@Override
	public List<User> getSortUserWIthCity() {
		List<User> list = dao.findAllUser();

		Collections.sort(list, new Comparator<User>() {

			@Override
			public int compare(User o1, User o2) {

				return o1.getCity().compareTo(o2.getCity());
			}

		});

		return list;
	}

	@Override
	public List<User> getDesendingUserPincode() {
		
		List<User> list = dao.findAllUser();
		
		Collections.sort(list, new Comparator<User>() {

			@Override
			public int compare(User o1, User o2) {
				return o2.getPincode().compareTo(o1.getPincode());
			}
			
			
			
		});
		
		
		return list;
	}

	@Override
	public List<User> getSortUserPincode() {
		
		List<User> list = dao.findAllUser();
		
		Collections.sort(list, new Comparator<User>() {

			@Override
			public int compare(User o1, User o2) {
				
				return o1.getPincode().compareTo(o2.getPincode());
			}
			
		});
		
		return list;
	}
	
	

}
