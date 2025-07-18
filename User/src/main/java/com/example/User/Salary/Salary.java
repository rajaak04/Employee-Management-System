package com.example.User.Salary;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Salary {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;


public String username;
String bankname;
String accountno;
String type;
String ifsc_code;
int salary;
String fromdate;
String todate;
public String getUserid() {
	return username;
}
public void setUserid(String username) {
	this.username = username;
}
public String getBankname() {
	return bankname;
}
public void setBankname(String bankname) {
	this.bankname = bankname;
}
public String getAccountno() {
	return accountno;
}
public void setAccountno(String accountno) {
	this.accountno = accountno;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getIfsc_code() {
	return ifsc_code;
}
public void setIfsc_code(String ifsc_code) {
	this.ifsc_code = ifsc_code;
}
public int getSalary() {
	return salary;
}
public void setSalary(int salary) {
	this.salary = salary;
}
public String getFromdate() {
	return fromdate;
}
public void setFromdate(String fromdate) {
	this.fromdate = fromdate;
}
public String getTodate() {
	return todate;
}
public void setTodate(String todate) {
	this.todate = todate;
}
}
