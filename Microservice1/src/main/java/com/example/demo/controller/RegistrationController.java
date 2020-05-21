package com.example.demo.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.dao.RegistrationDAO;
import com.example.demo.model.Customer;
import com.example.demo.model.Registration;
@EnableAutoConfiguration
@RestController
@CrossOrigin("*")
public class RegistrationController {

	private RegistrationDAO registerdao;
	
	private CustomerDAO customerdao;
	
	

	public RegistrationController(RegistrationDAO registerdao, CustomerDAO customerdao) {
		super();
		this.registerdao = registerdao;
		this.customerdao = customerdao;
	}

	@PostMapping("/api/newLPG/{userId}")
	public Customer registerLPG(@PathVariable Integer userId,@RequestBody Customer customer)
	{
		
		Registration user=registerdao.findById(userId).get();
		if(user!=null)
		{
				customer.setRegistration(user);
				customer.setId(456);
				return customerdao.save(customer);
			
			
		}
		return null;
	}
	@PostMapping("/api/register")
	public Registration register(@RequestBody Registration reg)
	{
		return registerdao.save(reg);
	}
	
}
