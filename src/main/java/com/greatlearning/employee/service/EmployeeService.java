package com.greatlearning.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort.Direction;

import com.greatlearning.employee.entity.Employee;


public interface EmployeeService {
	public List<Employee> findAll();
	public Optional<Employee> findById(Integer id);
	public Employee save(Employee theEmployee);
	public void deleteById(Integer id);	
	public List<Employee> searchBy(String firstName);
	public Employee addEmployee(Employee theEmployee);
	public Employee update(Employee theEmployee);
	public List<Employee> sortByFirstName(Direction direction);
}
