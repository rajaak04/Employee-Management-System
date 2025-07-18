package com.example.Employee.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

	@Autowired
	AdminRepository repository;
	public Admin findByUsername(String username) {
		return repository.findByUsername(username);
	}
	
}
