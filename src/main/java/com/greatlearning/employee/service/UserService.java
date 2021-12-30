package com.greatlearning.employee.service;

import java.util.Optional;

import com.greatlearning.employee.entity.User;

public interface UserService {
	public User addUser(User theUser);
	public User getUser(Long id);
	
}
