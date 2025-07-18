package com.example.Manager;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Transient;

@Entity
public class Employer{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	String username;
@Transient
String base64;
	public String getBase64() {
	return base64;
}

public void setBase64(String base64) {
	this.base64 = base64;
}

	String password;
    int age;
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	String name;
	String dept;
	String gender;
	int experience;
	String address;
	String city;
	String state;
	int pincode;
	@Lob
	 byte[] file;

	String filename;
	String filecontenttype;
	public String getFilename() {
		return filename;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFilecontenttype() {
		return filecontenttype;
	}

	public void setFilecontenttype(String filecontenttype) {
		this.filecontenttype = filecontenttype;
	}

	String Contactno;




	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public String getContactno() {
		return Contactno;
	}

	public void setContactno(String contactno) {
		Contactno = contactno;
	}

	public  String getUsername() {
		return username;
	}

	public void setUsername( String username) {
		this.username = username;
	}

	public   String getPassword() {
		return password;
	}

	public void setPassword( String password) {
		this.password = password;
	}

	}

		



