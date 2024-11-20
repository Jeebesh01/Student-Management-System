package com.lms.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component//same as @Service
public class EmailService {
	
	@Autowired
	private JavaMailSender javaMailSender;

	public void sendEmail(
			String to,
			String sub,
			String msg) {
		
		SimpleMailMessage s = new SimpleMailMessage();
		s.setTo(to);
		s.setSubject(sub);
		s.setText(msg);
		javaMailSender.send(s);
	}
}
