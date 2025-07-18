package com.example.Employee.admin.dept;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="dept")
public class Dept {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	String deptname;
	String description;
	String deptManager;
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDeptManager() {
		return deptManager;
	}
	public void setDeptManager(String deptManager) {
		this.deptManager = deptManager;
	}

	
}
