package com.example.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.ContactModel;
import com.example.demo.service.SmtpMailSender;

@Controller
@CrossOrigin("*")
public class ContactController 
{
	
    private SmtpMailSender smtpMailSender;
    
    @Autowired
   public ContactController(SmtpMailSender smtpMailSender) {
		super();
		this.smtpMailSender = smtpMailSender;
	}


@PostMapping("/api/contact")
   public ResponseEntity<ContactModel> request(@RequestBody ContactModel usermodel) {
        
//     ContactModel usermodel = new ContactModel();
////       usermodel.setSubject(subject);
//       usermodel.setMessage(message);
//       usermodel.setEmail("rajesh.mp1998@gmail.com");
//       usermodel.setName(name);
       try {
           smtpMailSender.sendNotification(usermodel);
           return new ResponseEntity<>(usermodel,  HttpStatus.OK);
           
       }catch(MailException e) 
       {
    	   return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
       }
        
        
       
   }

}
