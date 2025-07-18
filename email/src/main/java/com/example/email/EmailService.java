package com.example.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

   @Autowired
   private MailSender mailsender;
   
   public void sendEmail(String to,String subject,String body) {
         SimpleMailMessage message=new SimpleMailMessage();	   
	   message.setTo(to);
	   message.setFrom("rajaakrajaak82@gmail.com");
	   message.setSubject(subject);
	   message.setText(body);
	   mailsender.send(message);
   
   
    }
}
