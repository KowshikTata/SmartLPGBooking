/*
 * package com.example.demo.controller;
 * 
 * import org.springframework.boot.autoconfigure.EnableAutoConfiguration; import
 * org.springframework.web.bind.annotation.CrossOrigin; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.example.demo.dao.CustomerDAO; import
 * com.example.demo.dao.RegistrationDAO; import com.example.demo.model.Customer;
 * import com.example.demo.model.Registration;
 * 
 * @EnableAutoConfiguration
 * 
 * @RestController
 * 
 * @CrossOrigin("*") public class RegistrationController {
 * 
 * private RegistrationDAO registerdao;
 * 
 * private CustomerDAO customerdao;
 * 
 * 
 * 
 * public RegistrationController(RegistrationDAO registerdao, CustomerDAO
 * customerdao) { super(); this.registerdao = registerdao; this.customerdao =
 * customerdao; }
 * 
 * @PostMapping("/api/newLPG/{email}") public Customer registerLPG(@PathVariable
 * String email,@RequestBody Customer customer) {
 * 
 * Registration user=registerdao.findByEmail(email).get(); if(user!=null) {
 * customer.setRegistration(user);
 * 
 * return customerdao.save(customer);
 * 
 * 
 * } return null; }
 * 
 * @PostMapping("/api/register") public Registration register(@RequestBody
 * Registration reg) { return registerdao.save(reg); }
 * 
 * @GetMapping("/api/login/{email}/{password}") public Registration
 * logIn(@PathVariable String email,@PathVariable String password) {
 * Registration reg=registerdao.findByEmailAndPassword(email,password);
 * if(reg!=null) { return reg; } else { return null; }
 * 
 * } }
 */
package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.dao.RegistrationDAO;
import com.example.demo.model.Customer;
import com.example.demo.model.Registration;
import com.example.demo.service.RegistrationService;
@EnableAutoConfiguration
@RestController
@CrossOrigin("*")
public class RegistrationController 
{
    private RegistrationService registrationService;
    
    @Autowired
	public RegistrationController(RegistrationService registrationService) {
		super();
		this.registrationService = registrationService;
	}
	@PostMapping("/api/newLPG/{email}")
	public Customer registerLPG(@PathVariable String email,@RequestBody Customer customer)
	{
		return registrationService.registerLPG(email, customer);
		
	}
	@PostMapping("/api/register")
	public Registration register(@RequestBody Registration reg)
	{
		return registrationService.register(reg);
	}
	 @GetMapping("/api/login/{email}/{password}") 
	 public Registration logIn(@PathVariable String email,@PathVariable String password) 
	 {
	  Registration reg=registrationService.findByEmailAndPassword(email,password);
	  if(reg!=null)
	  { return reg; } 
	  else 
	  { return null; 
	  }
}
@GetMapping("/api/login/checkEmail/{email}") 
public Registration check(@PathVariable String email)
{
	return registrationService.findByEmail(email).get();
}

@GetMapping("/api/login/checkPhone/{phone}") 
public Registration checkPhone(@PathVariable String phone)
{
	return registrationService.findByPhone(phone).get();
}

@GetMapping("/api/login/checkName/{userName}") 
public Registration checkUserName(@PathVariable String userName)
{
	return registrationService.findByUserName(userName).get();
}
@GetMapping("/api/customer/newLPGCheck/{email}")
public Customer checkLPG(@PathVariable String email)
{
	return registrationService.findByEmailLPG(email);
}
}

