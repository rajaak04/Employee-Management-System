package com.example.Employee;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Employee.Manager.Manager;
import com.example.Employee.Manager.ManagerService;

import com.example.Employee.admin.Admin;
import com.example.Employee.admin.AdminService;


@Controller
@RequestMapping("/employer")
public class EmployeeController {
	
	
	@Autowired
	EmployeeService eservicer;
	
	@Autowired
	AdminService aservicer;
	@Autowired
   ManagerService mservicer;
	
	@Autowired
	EmployeeRepository repository;
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/signin")
	public String login(Employer employer,Model model) {
		model.addAttribute("employer", employer);

		return "signin";
	}
	
	
	
	@PostMapping("/check")
	public String getLogin( @ModelAttribute("employer") Employer employer,
			 Manager manager,Admin admin,@RequestParam("type") String type,
			BindingResult result,Model model) {
		
		
		
	
		Employer eexistingUsername=eservicer.findsByUsername(employer.getUsername());
		Admin aexistingUsername=aservicer.findByUsername(admin.getUsername());
		Manager mexistingUsername=mservicer.findByUsername(employer.getUsername());
		if(type.equals("User") && eexistingUsername!=null && eexistingUsername.getPassword().equals(employer.getPassword())) {
			  long id=eexistingUsername.getId();
		   model.addAttribute("login","Login Successull");
			return "redirect:http://localhost:8080/user/home?id="+id;
		}
		else if(type.equals("Admin") && aexistingUsername!=null && aexistingUsername.getPassword().equals(admin.getPassword())) {
			   model.addAttribute("login","Login Successull");
			   System.out.println("Admin");
				return "admin";
			}
		else if(type.equals("Manager") && mexistingUsername!=null && mexistingUsername.getPassword().equals(manager.getPassword())) {
			
			   System.out.println("Manager");
				return "redirect:http://localhost:8080/managing/home";
				
			}
		model.addAttribute("error","Invalid Username or Password");
		
			return "signin";
		}
		
			
	@GetMapping("/viewemployee")
	public String viewemployee(Model model) {
		
		List<Employer> employee=repository.findAll();
		
		for(Employer employ :employee) {
			
			String base64s=Base64.getEncoder().encodeToString(employ.getFile());
			employ.setBase64(base64s);
			System.out.println(base64s);
		
	}
	
		model.addAttribute("Employee", employee);
		return "employerview";
		
		
		
	}

		
	

}

