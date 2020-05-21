package com.example.demo.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.client.CustomerClient;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.dao.OrderDAO;
import com.example.demo.dao.ProductDAO;
import com.example.demo.dao.RegistrationDAO;
import com.example.demo.model.Customer;
import com.example.demo.model.Order;
import com.example.demo.model.Product;
import com.example.demo.model.Registration;
@CrossOrigin("*")
@EnableAutoConfiguration
@RestController
public class CustomerController {

	private CustomerClient customerClient;
	private CustomerDAO customerdao;
	private RegistrationDAO registerdao;
	private OrderDAO orderdao;
	private ProductDAO productdao;

	
	public CustomerController(CustomerClient customerClient, CustomerDAO customerdao, RegistrationDAO registerdao,
			OrderDAO orderdao, ProductDAO productdao) {
		super();
		this.customerClient = customerClient;
		this.customerdao = customerdao;
		this.registerdao = registerdao;
		this.orderdao = orderdao;
		this.productdao = productdao;
	
	}
	
	@RequestMapping("/api/customers/products")
	public List<Product> view()
	{
		return customerClient.viewProduct();
	}
	@RequestMapping("/api/viewProfile/{userId}")
	public Customer viewProfile(@PathVariable Integer userId)
	{
		Registration user=registerdao.findById(userId).get();
		return customerdao.findByRegistration(user);
	}
	@PostMapping("/api/customer/bookLPG/{customerId}")
	public Order bookLPG(@PathVariable Integer customerId)
	{
		Customer customer=customerdao.findById(customerId).get();
		Product p=productdao.findById(1).get();
		if(customer!=null)
		{
			Order order = new Order();
			
			
			order.setCustomer(customer);
			order.setPrice(p.getPrice());
			order.setDate(new Date(System.currentTimeMillis()));
			
			p.setUnitsInStock(p.getUnitsInStock()-1);
			productdao.save(p);
			return orderdao.save(order);
		}
		return null;
	}
	@PutMapping("/api/customer/requestPahal/{customerId}")
	public ResponseEntity<String> request(@PathVariable Integer customerId)
	{
		Customer customer=customerdao.findById(customerId).get();
		if(customer!=null)
		{
		customer.setRequestingPahal(true);
		customerdao.save(customer);
		return ResponseEntity.status(HttpStatus.OK).body("Request Processed!!");
		 
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Please provide Valid Details!!");
	}
	@PutMapping("/api/customer/giveUpSubsidy/{customerId}")
	public ResponseEntity<String> giveUp(@PathVariable Integer customerId)
	{
		Customer customer=customerdao.findById(customerId).get();
		if(customer!=null)
		{
			if(customer.isJoinedPahal()==true)
			{
		customer.setGivingUpSubsidy(true);
		customerdao.save(customer);
		return ResponseEntity.status(HttpStatus.OK).body("GivedUp Subsidy!!");
			}
			else
			{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Joined PAHAL!!");
			}
		}
		else
		{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Please provide Valid Details!!");
		}
	}
	@RequestMapping("/api/customer/orders/{customerId}")
	public List<Order> orders(@PathVariable int customerId)
	{
		Customer customer=customerdao.findById(customerId).get();
		return (List<Order>) orderdao.findByCustomer(customer);
		
	}
	@RequestMapping("/api/customer/order")
	public ResponseEntity<Iterable<Order>> allorders()
	{
		
		return ResponseEntity.ok().body(orderdao.findAll());
		
	}
}

