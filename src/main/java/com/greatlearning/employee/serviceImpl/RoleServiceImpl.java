package com.greatlearning.employee.serviceImpl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.employee.entity.Role;
import com.greatlearning.employee.repository.RoleRepository;
import com.greatlearning.employee.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	RoleRepository roleRepo;
	
	@Override
	public Role findByRoleId(Long id) {
		return roleRepo.findById(id).get();
	}

	@Override
	public Role addRole(Role theRole) {
		
		return roleRepo.save(theRole);		
	}
		
	
}
