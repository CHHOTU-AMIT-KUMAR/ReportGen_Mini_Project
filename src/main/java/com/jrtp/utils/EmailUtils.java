package com.jrtp.utils;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtils {
	@Autowired
	private JavaMailSender mailSender;
	
	public boolean sendEmail(String subject,String body,String to,File f) {
		try {
			//for attachment we use MimeMessage
			
			MimeMessage mimeMsg=mailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(mimeMsg,true);
			
			helper.setSubject(subject);
			helper.setText(body,true);
			helper.setTo(to);
			
			//To Add Attachment
			helper.addAttachment("plans", f);
			
			
			mailSender.send(mimeMsg);
			f.delete();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return true;
	}
	
	
}
