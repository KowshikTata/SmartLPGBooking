/*
 * package com.example.demo.controller;
 * 
 * import java.sql.Date; import java.util.List;
 * 
 * import org.springframework.boot.autoconfigure.EnableAutoConfiguration; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.CrossOrigin; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.PutMapping; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.example.demo.client.CustomerClient;
 * 
 * import com.example.demo.dao.CustomerDAO; import
 * com.example.demo.dao.OrderDAO; import com.example.demo.dao.ProductDAO; import
 * com.example.demo.dao.RegistrationDAO; import com.example.demo.model.Customer;
 * import com.example.demo.model.Order; import com.example.demo.model.Product;
 * import com.example.demo.model.Registration;
 * 
 * @CrossOrigin("*")
 * 
 * @EnableAutoConfiguration
 * 
 * @RestController public class CustomerController {
 * 
 * private CustomerClient customerClient; private CustomerDAO customerdao;
 * private RegistrationDAO registerdao; private OrderDAO orderdao; private
 * ProductDAO productdao;
 * 
 * 
 * public CustomerController(CustomerClient customerClient, CustomerDAO
 * customerdao, RegistrationDAO registerdao, OrderDAO orderdao, ProductDAO
 * productdao) { super(); this.customerClient = customerClient; this.customerdao
 * = customerdao; this.registerdao = registerdao; this.orderdao = orderdao;
 * this.productdao = productdao;
 * 
 * }
 * 
 * @RequestMapping("/api/customers/products") public List<Product> view() {
 * return customerClient.viewProduct(); }
 * 
 * @RequestMapping("/api/viewProfile/{userId}") public Customer
 * viewProfile(@PathVariable Integer userId) { Registration
 * user=registerdao.findById(userId).get(); return
 * customerdao.findByRegistration(user); }
 * 
 * @PostMapping("/api/customer/bookLPG/{email}") public Order
 * bookLPG(@PathVariable String email) { Registration
 * user=registerdao.findByEmail(email).get(); Customer
 * customer=customerdao.findByRegistration(user); Product
 * p=productdao.findById(1).get(); if(customer!=null) { Order order = new
 * Order();
 * 
 * 
 * order.setCustomer(customer); order.setPrice(p.getPrice()); order.setDate(new
 * Date(System.currentTimeMillis()));
 * 
 * p.setUnitsInStock(p.getUnitsInStock()-1); productdao.save(p); return
 * orderdao.save(order); } return null; }
 * 
 * @PutMapping("/api/customer/requestPahal/{userId}") public
 * ResponseEntity<String> request(@PathVariable Integer userId) { Registration
 * user=registerdao.findById(userId).get(); Customer
 * customer=customerdao.findByRegistration(user); if(customer!=null) {
 * customer.setRequestingPahal(true); customerdao.save(customer); return
 * ResponseEntity.status(HttpStatus.OK).body("Request Processed!!");
 * 
 * } return ResponseEntity.status(HttpStatus.NOT_FOUND).
 * body("Please provide Valid Details!!"); }
 * 
 * @PutMapping("/api/customer/giveUpSubsidy/{userId}") public
 * ResponseEntity<String> giveUp(@PathVariable Integer userId) {
 * 
 * Registration user=registerdao.findById(userId).get(); Customer
 * customer=customerdao.findByRegistration(user); if(customer!=null) {
 * if(customer.isJoinedPahal()==true) { customer.setGivingUpSubsidy(true);
 * customerdao.save(customer); return
 * ResponseEntity.status(HttpStatus.OK).body("GivedUp Subsidy!!"); } else {
 * return
 * ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Joined PAHAL!!"); } }
 * else { return ResponseEntity.status(HttpStatus.NOT_FOUND).
 * body("Please provide Valid Details!!"); } }
 * 
 * @RequestMapping("/api/customer/orders/{userEmail}") public List<Order>
 * orders(@PathVariable String userEmail) { Registration
 * user=registerdao.findByEmail(userEmail).get(); Customer
 * customer=customerdao.findByRegistration(user); return (List<Order>)
 * orderdao.findByCustomer(customer);
 * 
 * }
 * 
 * @RequestMapping("/api/customer/order") public ResponseEntity<Iterable<Order>>
 * allorders() {
 * 
 * return ResponseEntity.ok().body(orderdao.findAll());
 * 
 * } }
 * 
 */
package com.example.demo.controller;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.Customer;
import com.example.demo.model.Order;
import com.example.demo.model.Product;

import com.example.demo.service.CustomerService;
@CrossOrigin("*")
@EnableAutoConfiguration
@RestController
public class CustomerController {

	private CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	@RequestMapping("/api/customers/products")
	public List<Product> view()
	{
		return customerService.view();
	}
	@RequestMapping("/api/viewProfile/{email}")
	public Customer viewProfile(@PathVariable String email)
	{
		return customerService.viewProfile(email);
	}
	@PostMapping("/api/customer/bookLPG/{email}")
	public Order bookLPG(@PathVariable String email)
	{
		return customerService.bookLPG(email);
	}
	@PutMapping("/api/customer/requestPahal/{email}")
	public ResponseEntity<String> request(@PathVariable String email)
	{
		return customerService.request(email);
	}
	@PutMapping("/api/customer/giveUpSubsidy/{email}")
	public ResponseEntity<String> giveUp(@PathVariable String email)
	{
		return customerService.giveUp(email);
	}
	@RequestMapping("/api/customer/orders/{email}")
	public List<Order> orders(@PathVariable String email)
	{
		return customerService.orders(email);
		
	}
	
	 @GetMapping("/api/v1/customers")
		public List<Customer> listAllCustomers()
		{
			return customerService.listAllCustomers();
		}
		@GetMapping("/api/v1/customers/{id}")
		public Optional<Customer> getById(@PathVariable Integer id)
		{
			return customerService.getById(id);
		}
		@PutMapping("/api/v1/customers/{id}")
		public Customer updateAll(@PathVariable Integer id, @RequestBody Customer customer)
		{
			return customerService.updateAll(id,customer);
		}
		@RequestMapping("/api/v1/orders")
		public ResponseEntity<Iterable<Order>> allorders()
		{
			return customerService.allorders();
			
		}
		@GetMapping("/api/v1/orders/{id}")
		public Optional<Order> getOrderByid(@PathVariable Integer id)
		{
			return customerService.getOrderByid(id);
		}
		@PutMapping("/api/v1/orders/{id}")
		public Order updateAll(@PathVariable Integer id, @RequestBody Order order)
		{
			return customerService.updateAll(id,order);
		}
		@GetMapping("/api/customer/requsetPahal/{email}")
		public int requestPahalSubsidy(@PathVariable String email)
		{
			return customerService.findByRequestingPahal(email);
			
		}
		@GetMapping("/api/customer/giveUpPahal/{email}")
		public int giveUpPahalSubsidy(@PathVariable String email)
		{
			return customerService.findByIsGivingUpSubsidy(email);
			
		}
}

