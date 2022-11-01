package com.admin.panel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.panel.entity.User;


public interface UserRepository extends JpaRepository<User, Integer>{

}
