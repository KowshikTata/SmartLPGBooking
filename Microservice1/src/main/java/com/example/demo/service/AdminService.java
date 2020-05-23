package com.example.demo.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Admin;
import com.example.demo.model.Customer;
import com.example.demo.model.Product;

public interface AdminService 
{
	public List<Product> view();
	public List<Customer> getCustomers();
	public List<Customer> requests();
	public Customer accept(Integer customerId);
	public Product updatePrice(Integer productId,Integer price);
	public Admin adminLogin(Admin admin);
	public Admin loginAdmin(String userName,String password);
}
