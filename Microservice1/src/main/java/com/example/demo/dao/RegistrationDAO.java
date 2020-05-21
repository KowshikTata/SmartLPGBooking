package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.model.Registration;

@Repository
public interface RegistrationDAO extends JpaRepository<Registration,Integer>{

}
