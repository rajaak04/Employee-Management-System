package com.example.Manager.leave;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public interface LeaveRepository extends JpaRepository<Leave,Long>{
	
	@Query(value = "select * from param where status = :status",nativeQuery = true)
	List<Leave> getleaves (@Param("status") String status);
	

}
