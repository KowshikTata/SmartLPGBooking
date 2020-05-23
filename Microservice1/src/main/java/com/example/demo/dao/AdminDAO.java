package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Admin;

@Repository
public interface AdminDAO extends JpaRepository<Admin,String>{
	public Admin findByUserNameAndPassword(String userName, String password);
}
