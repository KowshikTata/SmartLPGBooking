package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.dao.RegistrationDAO;
import com.example.demo.model.Customer;
import com.example.demo.model.Registration;
@Service
public class RegistrationServiceImpl implements RegistrationService 
{
    private RegistrationDAO registerdao;
	private CustomerDAO customerdao;
	
    @Autowired
	public RegistrationServiceImpl(RegistrationDAO registerdao, CustomerDAO customerdao) {
		super();
		this.registerdao = registerdao;
		this.customerdao = customerdao;
	}

	@Override
	public Customer registerLPG(String email, Customer customer) {
		Registration user=registerdao.findByEmail(email).get();
		if(user!=null)
		{
				customer.setRegistration(user);
				return customerdao.save(customer);
			
			
		}
		return null;
	}

	@Override
	public Registration register(Registration reg) {
		// TODO Auto-generated method stub
		return registerdao.save(reg);
	}

	@Override
	public Registration findByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		return registerdao.findByEmailAndPassword(email,password);
	}

	@Override
	public Optional<Registration> findByEmail(String userEmail) {
		// TODO Auto-generated method stub
		return registerdao.findByEmail(userEmail);
	}

	@Override
	public Optional<Registration> findByPhone(String userPhone) {
		// TODO Auto-generated method stub
		return registerdao.findByPhone(userPhone);
	}

	@Override
	public Optional<Registration> findByUserName(String userName) {
		// TODO Auto-generated method stub
		return registerdao.findByUserName(userName);
	}

	@Override
	public Customer findByEmailLPG(String email) {
		Registration user=registerdao.findByEmail(email).get();
		Customer customer=customerdao.findByRegistration(user);
		return customer;
	}
	

}
