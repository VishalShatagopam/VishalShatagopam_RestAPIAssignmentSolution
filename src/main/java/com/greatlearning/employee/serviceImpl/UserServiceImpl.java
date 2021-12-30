package com.greatlearning.employee.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.greatlearning.employee.entity.User;
import com.greatlearning.employee.repository.UserRepository;
import com.greatlearning.employee.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepo;
	
	@Override
	public User getUser(Long theId) {
		return userRepo.findById(theId).get();
	}

	@Override
	public User addUser(User theUser) {
		 return userRepo.save(theUser);
	}
	
//	@Override
//	public User getUser(Integer id) {
//		
//		return userRepo.findById(id).get();
//	}


	
	
}
