package com.example.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	
	@Autowired
	EmployeeRepository repository;
	
	public Employer findsByUsername(String username) {
		
		return repository.findByUsername(username);
	}
}
