package com.example.Manager;

import java.io.IOException;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import com.example.Manager.leave.Leave;
import com.example.Manager.leave.LeaveRepository;

@Controller
@RequestMapping("/managing")
public class ManagerController {
	
	@GetMapping("/home")
	public String getManager() {
		return "ManagerHome";
		
		
		
	}
	@Autowired
	EmployeeRepository repository;

	
	@GetMapping("/addemployee")
	public String addEmployee(Model model) {
		
		return "add";
		
	}
	
	@PostMapping("/employee")
	public String getEmployee(@RequestParam("name")String name,
			@RequestParam("dept")String dept,
			@RequestParam("username")String username,
			@RequestParam("password")String password,
			@RequestParam("gender")String gender,
			@RequestParam("experience")int experience,
			@RequestParam("file") MultipartFile file,
			@RequestParam("address")String address,
			@RequestParam("city")String city,
			@RequestParam("state")String state,
			@RequestParam("pincode")int pincode,
			@RequestParam("Contactno")String Contactno,
			@RequestParam("age") int age,
			Model model) throws IOException {
		
		Employer employer=new Employer();
		employer.setName(name);
		employer.setAge(age);
		employer.setDept(dept);
		employer.setCity(city);
		employer.setAddress(address);
		employer.setGender(gender);
		employer.setFile(file.getBytes());
		employer.setFilecontenttype(file.getContentType());
		employer.setFilename(file.getOriginalFilename());
		employer.setState(state);
		employer.setExperience(experience);
		
		employer.setUsername(username);
		employer.setPassword(password);
		employer.setContactno(Contactno);
		employer.setPincode(pincode);
		repository.save(employer);
		model.addAttribute("message", "saved Succesfully");
		
		
		return "ManagerHome";
				
			}
	
	@GetMapping("/viewemployee")
	public String viewEmployee(Model model) {
		List<Employer> employees=repository.findAll();
		
		
		for(Employer employ :employees) {
			
				String base64s=Base64.getEncoder().encodeToString(employ.getFile());
				employ.setBase64(base64s);
				System.out.println(base64s);
			
		}
		
		
		
		model.addAttribute("Employee",employees);
		return "view";
	}
	@GetMapping("/employeedelete/{id}")
	public String deleteEmployees(@PathVariable long id,Model model ) {
	     repository.deleteById(id);
	     return "ManagerHome";
	     
		
	}
	
	@GetMapping("/employeeupdate/{id}")
	public String updateemployee(@PathVariable long id,Model model) {
          model.addAttribute("update", repository.findById(id).get());
          return "UpdateEmployer";
		
	}
	@PostMapping("/Update/{id}")
	public String update(@PathVariable long id,Model model,@RequestParam("name")String name,
			@RequestParam("dept")String dept,
			@RequestParam("username")String username,
			@RequestParam("password")String password,
			@RequestParam("gender")String gender,
			@RequestParam("experience")int experience,
			@RequestParam("file")MultipartFile file,
			@RequestParam("address")String address,
			@RequestParam("city")String city,
			@RequestParam("state")String state,
			@RequestParam("pincode")int pincode,
			@RequestParam("Contactno")String Contactno,
			@RequestParam("age") int age
			) throws IOException{
		Employer employer=repository.findById(id).get();
		employer.setName(name);
		employer.setAge(age);
		employer.setDept(dept);
		employer.setCity(city);
		employer.setAddress(address);
		employer.setGender(gender);
		if(!file.getOriginalFilename().isEmpty()) {
		employer.setFile(file.getBytes());
		employer.setFilecontenttype(file.getContentType());
		employer.setFilename(file.getOriginalFilename());}
		employer.setState(state);
		
		employer.setExperience(experience);
		employer.setUsername(username);
		employer.setPassword(password);
		employer.setContactno(Contactno);
		employer.setPincode(pincode);
		repository.save(employer);
		
		
		return "redirect:http://localhost:8080/managing/viewemployee";
		
	}
	
	@Autowired
	LeaveRepository lrepository;
	
	@GetMapping("/approve")
	public String approval(Model model) {
		List<Leave> leaves =lrepository.findAll();
		
		
		for (Leave leave : leaves) {
	        byte[] file = leave.getFile();
	        if (file != null) {
	            String base64 = Base64.getEncoder().encodeToString(file);
	            leave.setBase64(base64);
	        } else {
	            leave.setBase64(""); // handle null safely
	        }
	        
	    }
		
		List<Leave> leaving=lrepository.getleaves("pending");
		model.addAttribute("leave", leaving);
		return "leave";
		
		
		
	}
	
	
	@PostMapping("/approval/{id}")
	public RedirectView getappprove(Model model ,@PathVariable Long id) {
		Leave leave=lrepository.findById(id).get();
		
		leave.setStatus("Approved");
		 lrepository.save(leave);
		            
		
		return new RedirectView("http://localhost:8080/managing/home");
		
		
	}
	@PostMapping("/rejection/{id}")
	public RedirectView getRejection(Model model,@PathVariable Long id) {
		Leave leave=lrepository.findById(id).get();
		leave.setStatus("Rejected");
		lrepository.save(leave);
		return new RedirectView("http://localhost:8080/managing/home");
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
