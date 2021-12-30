package com.greatlearning.employee.service;


import com.greatlearning.employee.entity.Role;

public interface RoleService {
	
	

	public Role findByRoleId(Long id);
	public Role addRole(Role theRole);
}
