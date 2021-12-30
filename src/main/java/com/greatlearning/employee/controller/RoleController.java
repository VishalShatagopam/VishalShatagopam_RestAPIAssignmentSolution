package com.greatlearning.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.employee.entity.Role;
import com.greatlearning.employee.service.RoleService;

@RestController
public class RoleController {

	@Autowired
	RoleService roleService;

//	@RequestMapping("/addRoles")
//	public Role addRoles(Role theRole) {
//
//		Role theRole = roleService.
//		
//
//	}

	@PostMapping("/addRole")
	public Role addRole(@RequestBody Role theRole) {

		return roleService.addRole(theRole);
	}

}
