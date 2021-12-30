package com.greatlearning.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.employee.entity.User;
import com.greatlearning.employee.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/addUser")
	public User adduser(@RequestBody User theUser ) {
		return userService.addUser(theUser);
	}
	
	@GetMapping("/getUser")
	public User getuser(@RequestParam Long id) {
		return userService.getUser(id);
	}
	
}
