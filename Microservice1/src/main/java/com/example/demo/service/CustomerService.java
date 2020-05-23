package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;


import com.example.demo.model.Customer;
import com.example.demo.model.Order;
import com.example.demo.model.Product;

public interface CustomerService
{
	public List<Product> view();
	public Customer viewProfile(String email);
	public Order bookLPG(String email);
	public ResponseEntity<String> request(String email);
	public ResponseEntity<String> giveUp(String email);
	public List<Order> orders(String email);
	public ResponseEntity<Iterable<Order>> allorders();
	public List<Customer> listAllCustomers();
	public Optional<Customer> getById(Integer id);
	public Customer updateAll(Integer id,Customer customer);
	public Optional<Order> getOrderByid(Integer id);
	public Order updateAll(Integer id,Order order);
	int findByRequestingPahal(String email);
	int findByIsGivingUpSubsidy(String email);

}
