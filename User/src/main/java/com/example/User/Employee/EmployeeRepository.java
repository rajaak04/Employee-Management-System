package com.example.User.Employee;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employer, Long>{
	Optional<Employer> findByUsername(String username);

}
