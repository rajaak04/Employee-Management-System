package com.example.Employee.Manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {
    @Autowired
	ManagerRepository repository;
	
    
    public Manager findByUsername(String username) {
    	return repository.findByUsername(username);
    }
		
	
	
}
