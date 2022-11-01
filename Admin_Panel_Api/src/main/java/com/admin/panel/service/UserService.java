package com.admin.panel.service;

import java.util.List;

import com.admin.panel.entity.User;

public interface UserService {

//	Find Methods
	public List<User> findAllUser();
	public User findUserById(int id);
	
//	Created Methods
	public User createUser(User user);
	
	public List<User> listUserCreate(List<User> listUser);
	
//	Update Methods
	public User updateUser(int id,User user);
	
//	Delete Methods
	public String deleteUsers();
	
	public String deleteUserById(int id);
	
}





