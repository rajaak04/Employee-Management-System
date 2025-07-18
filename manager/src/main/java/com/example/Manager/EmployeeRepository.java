package com.example.Manager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employer, Long>{
	Employer findByUsername(String username);

}
