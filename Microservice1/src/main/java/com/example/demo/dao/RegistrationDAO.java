package com.example.demo.dao;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.model.Registration;

@Repository
public interface RegistrationDAO extends JpaRepository<Registration,Integer>{

	Registration  findByEmailAndPassword(String email,String password);

	Optional<Registration> findByPhone(String userPhone);

	Optional<Registration> findByEmail(String userEmail);
	
	Optional<Registration> findByUserName(String userName);

	
}
