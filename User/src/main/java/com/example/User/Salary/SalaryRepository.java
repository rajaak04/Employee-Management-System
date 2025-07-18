package com.example.User.Salary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public interface SalaryRepository extends JpaRepository<Salary, Long>{

	@Query(value = "select * from Salary where id In(:ids)",nativeQuery = true)
	List<Salary> findsByIdSalary(@Param("ids") List<Long> ids);
	
	@Query(value = "select id from Salary where username= :username",nativeQuery = true)
	List<Long> findByIds(@Param("username") String username);
}
