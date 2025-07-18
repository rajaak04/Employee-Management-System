package com.example.Manager.leave;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "param")
public class Leave {
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
public Long id;

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getBase64() {
	return base64;
}
public void setBase64(String base64) {
	this.base64 = base64;
}
String name;
String empid;
int days;
String reason;
String fromdate;
String Contenttype;
@Transient
String base64;

public String getContenttype() {
	return Contenttype;
}
public void setContenttype(String contenttype) {
	Contenttype = contenttype;
}
public byte[] getFile() {
	return file;
}
public void setFile(byte[] file) {
	this.file = file;
}
String todate;
@Lob
@Column(columnDefinition = "LONGBLOB")
byte[] file;
String status;
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmpid() {
	return empid;
}
public void setEmpid(String empid) {
	this.empid = empid;
}
public int getDays() {
	return days;
}
public void setDays(int days) {
	this.days = days;
}
public String getReason() {
	return reason;
}
public void setReason(String reason) {
	this.reason = reason;
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