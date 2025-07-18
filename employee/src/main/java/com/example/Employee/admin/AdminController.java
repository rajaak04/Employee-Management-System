package com.example.Employee.admin;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.Employee.Manager.Manager;
import com.example.Employee.Manager.ManagerRepository;
import com.example.Employee.admin.dept.Dept;
import com.example.Employee.admin.dept.DeptRepository;

@Controller
@RequestMapping("/employer")
public class AdminController {
	
	
	@Autowired
	DeptRepository repository;
	@GetMapping("/deptadd")
	public String savedepartment(Dept dept,Model model) {
		model.addAttribute("Dept",new Dept());
		return "dept";
	}
	@PostMapping("/dept")
	public String storeDepartment(@ModelAttribute("Dept") Dept dept,Model model) {
		
		repository.save(dept);
		model.addAttribute("message","Added Successfully");
		return "dept";
	}
	@Autowired
	ManagerRepository mrepository;
	
	@GetMapping("/managerregister")
	public String setRegister(Manager manager,Model model) {
		model.addAttribute("Manager", new Manager());
		return "register";
	}
	
	@PostMapping("/register")
	public String getRegister(
			@RequestParam("name")String name,
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
			
			Model model) throws IOException {
		Manager manager=new Manager();
		manager.setName(name);
		manager.setDept(dept);
		manager.setUsername(username);
		manager.setPassword(password);
		manager.setGender(gender);
		manager.setExperience(experience);
	
		manager.setFile(file.getBytes());
		
		manager.setFilename(file.getOriginalFilename());
		manager.setFilecontenttype(file.getContentType());
		
		manager.setAddress(address);
		manager.setCity(city);
		manager.setState(state);
		manager.setPincode(pincode);
		manager.setContactno(Contactno);
		mrepository.save(manager);
		
		return "admin";
		
	}
	
@GetMapping("/deptview")
public String viewdepartment(Model model) {
	List<Dept> dept=repository.findAll();
	model.addAttribute("Dept",dept);
	return "view";
}

}