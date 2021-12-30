package com.greatlearning.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.greatlearning.employee.entity.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
	@Query("SELECT e FROM Employee e WHERE e.firstName = ?1")
	List<Employee> findByFirstNameContainsAllIgnoreCases(String firstName);
	
}
