package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Customer;
import com.example.demo.model.Registration;

@Repository
public interface CustomerDAO extends JpaRepository<Customer,Integer>{

	Customer findByRegistration(Registration user);

	List<Customer> findByRequestingPahal(boolean var);
	
	boolean findByRequestingPahal(String email);
	
	boolean findByIsGivingUpSubsidy(String email);

}
