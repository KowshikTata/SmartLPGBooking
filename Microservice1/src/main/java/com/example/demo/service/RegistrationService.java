package com.example.demo.service;



import java.util.Optional;

import com.example.demo.model.Customer;
import com.example.demo.model.Registration;

public interface RegistrationService 
{
	public Customer registerLPG(String email,Customer customer);
	public Registration register(Registration reg);
	public Registration findByEmailAndPassword(String email, String password);
	Optional<Registration> findByPhone(String userPhone);

	Optional<Registration> findByEmail(String userEmail);
	
	Optional<Registration> findByUserName(String userName);
	
	Customer findByEmailLPG(String email);
}
