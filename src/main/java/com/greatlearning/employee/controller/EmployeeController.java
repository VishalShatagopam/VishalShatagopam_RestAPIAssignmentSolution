package com.greatlearning.employee.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.employee.entity.Employee;
import com.greatlearning.employee.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	public EmployeeController() {
		System.out.println("In Employee Controller");
	}
	@GetMapping("/employees/{id}")
	public Optional<Employee> getEmployee(@PathVariable Integer id)
	{
		return employeeService.findById(id);
	}
	@PostMapping("/add")
	public Employee addEmployees(@RequestBody Employee theEmployee) {

		return employeeService.addEmployee(theEmployee);
	}

	@GetMapping("/list")
	public List<Employee> employeeList() {
		List<Employee> theEmployees = employeeService.findAll();
		// theModel.addAttribute("employees", theEmployees);
		return theEmployees;
	}

	@PostMapping("/save")
	public Employee save(@RequestBody Employee theEmployee) {
		employeeService.save(theEmployee);
		return theEmployee;
	}

	@PutMapping("/update")
	public Employee showFormForUpdate(@RequestBody Employee theEmployee) {

		return employeeService.update(theEmployee);
	}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		
	    employeeService.deleteById(id);
	    return "Deleted Employee with Id - "+id ;
	}
	@GetMapping("employees/search/{firstName}")
	public List<Employee> search(@PathVariable("firstName") String firstName) {
		if (firstName.trim().isEmpty())
			return employeeService.findAll();
		else
			// else, search by first name 

			return employeeService.searchBy(firstName);
	}
	
	@GetMapping("/customSortByFirstName")
	public List<Employee> sortByFirstName(Direction direction){
		return employeeService.sortByFirstName(direction);
	}
		
	

}
