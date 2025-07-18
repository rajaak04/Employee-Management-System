package com.example.Employee.admin.dept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employer")
public class DeptController {
	@Autowired
	DeptRepository deptrepository;
	
	
	
@GetMapping("/deptupdate/{id}")
public String getUpdate(@PathVariable Long id,Dept dept,Model model) {
	model.addAttribute("dept",deptrepository.findById(id).get());
	
	return "update";
	
	
	
}

@PostMapping("/update/{id}")
public String setUpdate(@ModelAttribute("dept") Dept dept,Model model, @PathVariable Long id) {

	Dept dept1=deptrepository.findById(id).get();
	dept1.setDeptname(dept.getDeptname());
	dept1.setDeptManager(dept.getDeptManager());
	dept1.setDescription(dept.getDescription());
	deptrepository.save(dept1);
	model.addAttribute("update","Update Successfull");
	return "update";
	
	
}

@GetMapping("/deptdelete/{id}")
public String setDelete(@PathVariable Long id,Model model,Dept dept) {
	deptrepository.deleteById(id);
	return "admin";
	
	
}

}
