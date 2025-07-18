package com.example.Employee.Manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/employer")
public class ManagerController {
	

	@Autowired
	ManagerRepository repository;
	@GetMapping("/viewmanager")
	public String getManager(Manager manager,Model model) {
		List<Manager> managers=repository.findAll();
		
		
		
		for(Manager managering: managers) {
			String base64s=Base64.getEncoder().encodeToString(managering.getFile());
			managering.setBase64(base64s);
			
		}
		
		
		model.addAttribute("Manager", managers);
		return "Manager";
		
		
		
	}
	@GetMapping("/managerupdate/{id}")
	public String updatemanager(@PathVariable long id,Manager manager,Model model) {
		model.addAttribute("manager",repository.findById(id).get());
		return "UpdateManager";
	}
	@PostMapping("/updatem/{id}")
	public RedirectView getRegister(
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
			@PathVariable long id,
			Model model) throws IOException {
		Manager manager=repository.findById(id).get();
		manager.setName(name);
		manager.setDept(dept);
		manager.setUsername(username);
		manager.setPassword(password);
		manager.setGender(gender);
		manager.setExperience(experience);
		if(!file.getOriginalFilename().isEmpty()) {
		manager.setFile(file.getBytes());
		
		manager.setFilename(file.getOriginalFilename());
		manager.setFilecontenttype(file.getContentType());}
		manager.setAddress(address);
		manager.setCity(city);
		manager.setState(state);
		manager.setPincode(pincode);
		manager.setContactno(Contactno);
		repository.save(manager);
		model.addAttribute("message","Update Successfull");
		return new RedirectView( "http://localhost:8080/employer/viewmanager");
	}
	@GetMapping("/managerdelete/{id}")
	public RedirectView deleteManager(@PathVariable long id,Model model) {
		repository.deleteById(id);
		return new RedirectView("http://localhost:8080/employer/viewmanager");
		
	}

}
 