package com.example.Manager.salary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import java.util.stream.Collectors;

import com.example.Manager.EmployeeRepository;
import com.example.Manager.Employer;

@Controller
@RequestMapping("/managing")
public class SalaryController {
	
	@Autowired
	EmployeeRepository erepository;
	@Autowired
	SalaryRepository repository;

	@GetMapping("/salary")
	public String setSalary(Salary salary,Model model) {
		model.addAttribute("salary",new Salary());
		return "salary";
		
	}
	@PostMapping("/setSalary")
   public String getSalary(@ModelAttribute("salary") Salary salary,Model model) {
		
		repository.save(salary);
		return "redirect:http://localhost:8080/managing/home";
	   
   }
	@GetMapping("/salary/{id}")
	public String employeeSalary(@PathVariable long id,Model model) {
		
        
        
        	String username=erepository.findById(id).get().getUsername();
        	List<Long> ids = repository.findIdsByUsername(username);


        	System.out.println(username);
          System.out.println(ids);	
        	
        
        
        model.addAttribute("employees",repository.findsByIdSalary(ids));
        
        return "salaryview";
 
		
	}
}
