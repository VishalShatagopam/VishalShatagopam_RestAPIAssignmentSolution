package com.greatlearning.employee.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.greatlearning.employee.entity.Employee;
import com.greatlearning.employee.repository.EmployeeRepository;
import com.greatlearning.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee theEmployee) {
		
		return employeeRepository.save(theEmployee);
	}

	@Override
	public List<Employee> findAll() {

		return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> findById(Integer theId) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(theId);
	}

	@Override
	public Employee save(Employee theEmployee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(theEmployee);
	}
	
	@Override
	public void deleteById(Integer theId) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(theId);
	}

	@Override
	public List<Employee> searchBy(String firstName) {
		// TODO Auto-generated method stub
		return employeeRepository.findByFirstNameContainsAllIgnoreCases(firstName);
	}

	@Override
	public Employee update(Employee theEmployee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(theEmployee);
	}
	@Override
	public List<Employee> sortByFirstName(Direction direction){
		return employeeRepository.findAll(Sort.by(direction, "firstName"));
	}

}
