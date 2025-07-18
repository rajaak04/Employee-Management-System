package com.example.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class EmailController {

    
	@Autowired
	private EmailService emailservice;
	
	@GetMapping("/")
	public String home() {
		
		
		return "emailForm";
		
	}
	
	@PostMapping("/email-form")
	public String Check(@RequestParam String Name ,@RequestParam String email,@RequestParam String message,@RequestParam String subject) {
		String mail="Message From:"+email+subject;
		String body="Name:"+Name+" "+message;
		emailservice.sendEmail("rajaakrajaak82@gmail.com", mail, body);
		
		return "emailForm";
		

}}