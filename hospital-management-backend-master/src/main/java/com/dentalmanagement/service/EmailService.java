package com.dentalmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service
public class EmailService {
	
	 @Autowired
	    private JavaMailSender mailSender;

	    public void sendRegistrationEmail(String toEmail, String password,int id) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(toEmail);
	        message.setSubject("Doctor Registration Confirmation");
	        message.setText("Your registration was successful!\n\nEmail ID: " + toEmail + "\nPassword: " + password +"\nId:" +id);
	        mailSender.send(message);
	    }
	    
}
