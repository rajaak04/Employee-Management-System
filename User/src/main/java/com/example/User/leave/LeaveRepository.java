package com.example.User.leave;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface LeaveRepository extends JpaRepository<Leave,Long>{
	

}
