package com.example.Manager.salary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public interface SalaryRepository extends JpaRepository<Salary, Long>{
	

	@Query(value = "select * from Salary where id In(:ids)",nativeQuery = true)
	List<Salary> findsByIdSalary(@Param("ids") List<Long> ids);
	
	
	@Query(value = "SELECT id FROM salary WHERE username = :username", nativeQuery = true)
	List<Long> findIdsByUsername(@Param("username") String username);


}
