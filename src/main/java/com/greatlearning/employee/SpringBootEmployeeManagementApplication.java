package com.greatlearning.employee;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.greatlearning.employee.entity.Employee;
import com.greatlearning.employee.entity.Role;
import com.greatlearning.employee.entity.User;
import com.greatlearning.employee.repository.EmployeeRepository;
import com.greatlearning.employee.repository.RoleRepository;
import com.greatlearning.employee.repository.UserRepository;




@SpringBootApplication
public class SpringBootEmployeeManagementApplication {
	
	@Autowired
	RoleRepository roleRepo;
	
	@Autowired
	EmployeeRepository employeeRepo;
	
	@Autowired
	UserRepository userRepo;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEmployeeManagementApplication.class, args);
	}
	@Bean
	public void createStudents() {
		
		Employee emp1 = new Employee();
		emp1.setFirstName("Vishal");
		emp1.setLastName("Shatagopam");
		emp1.setEmail("Vishal@gl.com");
		employeeRepo.save(emp1);
		Employee emp2 = new Employee();
		emp2.setFirstName("Nora");
		emp2.setLastName("Fatehi");
		emp2.setEmail("Nora@gmail.com");
		employeeRepo.save(emp2);
		
		Role role1 = new Role();
		role1.setName("ROLE_ADMIN");
		roleRepo.save(role1);

		Role role2 = new Role();
		role2.setName("ROLE_USER");
		roleRepo.save(role2);
		
		User user1 = new User();
		user1.setUsername("abc");
		user1.setPassword(encoder().encode("abc"));
		user1.setRoles(Arrays.asList(role1, role2));

		userRepo.save(user1);

		User user2 = new User();
		user2.setUsername("xyz");
		user2.setPassword(encoder().encode("xyz"));
		user2.setRoles(Arrays.asList(role2));
		userRepo.save(user2);

	}
	@Bean
	public PasswordEncoder encoder()
	{
		return new BCryptPasswordEncoder();
	}
	
}
