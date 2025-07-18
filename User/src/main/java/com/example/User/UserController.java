package com.example.User;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.User.Employee.EmployeeRepository;
import com.example.User.Employee.Employer;
import com.example.User.Salary.Salary;
import com.example.User.Salary.SalaryRepository;
import com.example.User.leave.Leave;
import com.example.User.leave.LeaveRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	EmployeeRepository repository;
	@Autowired
	SalaryRepository srepository;
	@GetMapping("/home")
	public String getEmployee(@RequestParam long id,HttpSession session) {
		session.setAttribute("num", id);
		return "User";
	}
	@GetMapping("/profile")
	public String getProfile(Model model,HttpSession session) {

Long mainid=(Long) session.getAttribute("num");



		System.out.println(mainid);
		Employer employer=repository.findById(mainid).get();
		byte[] file=employer.getFile();
		String base64=Base64.getEncoder().encodeToString(file);
		employer.setBase64(base64);
		System.out.println(base64);
		model.addAttribute("employee",employer);
		
		return "Profile";
		
	}
	
	@GetMapping("/salaryview")
	public String employeeSalary(Model model,HttpSession session) {
		Long mainid=(Long) session.getAttribute("num");
		String username=repository.findById(mainid).get().getUsername();
       List<Long> ids=srepository.findByIds(username);
        
       
        
        model.addAttribute("employees",srepository.findsByIdSalary(ids));
        
        return "salaryview";
 
		
	
}
	@Autowired
	LeaveRepository lrepository;
	
	@GetMapping("/leave")
	public String getleave(Leave lea,Model model) {
		
		List<Leave> leave=lrepository.findAll();
		model.addAttribute("leave", leave);
		return "newleave";
		
		
	}
	@GetMapping("/request")
	public String leaveform(Leave leave,Model model) {
		
		model.addAttribute("Leave", new Leave());
		
		return "leave";
	}
	
	@PostMapping("/requestleave")
	public String saveleave(Model model,HttpSession session,@RequestParam("name") String name,
			@RequestParam("empid") String empid,@RequestParam("reason")String reason,
			@RequestParam("fromdate") String fromdate,@RequestParam("todate")String todate,@RequestParam("days")int days) {
		
		Long mainid=(Long) session.getAttribute("num");
		 Employer employees=repository.findById(mainid).get();
		 
		 
		 
		
		Optional<Employer> employer=repository.findByUsername(empid);
		if(employer.isPresent()) {
			Leave leave=new Leave();
			leave.setContenttype(employees.getFilecontenttype());
			leave.setDays(days);
			leave.setFile(employees.getFile());
			leave.setName(name);
			leave.setDays(days);
			leave.setReason(reason);
			leave.setFromdate(fromdate);
			leave.setTodate(todate);
			leave.setStatus("Pending");
			lrepository.save(leave);
			
			return "redirect:http://localhost:8080/user/leave";
			
			}
		model.addAttribute("error", "Check Your Employee Id");
		return "leave";
	
	     
		
		
	}
	

	

}
