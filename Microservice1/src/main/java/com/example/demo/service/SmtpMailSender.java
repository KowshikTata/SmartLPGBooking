package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.model.ContactModel;

@Service("smtpMailSender")
public class SmtpMailSender
{
	 private JavaMailSender javaMailSender;
     @Autowired
     public SmtpMailSender(JavaMailSender javaMailSender) {
         this.javaMailSender = javaMailSender;
          
     }
    
     public void sendNotification(ContactModel usermodel) throws MailException{
          
         StringBuilder sb = new StringBuilder();
         sb.append("Name: " + usermodel.getName()).append(System.lineSeparator());
         sb.append("\n Message: " + usermodel.getMessage());
          
         SimpleMailMessage mail = new SimpleMailMessage();
          
         mail.setTo(usermodel.getEmail());
         mail.setFrom("rajesh.mp1998@gmail.com");
         mail.setSubject(usermodel.getMessage());
         mail.setText(sb.toString());
         javaMailSender.send(mail);
         }      

}
