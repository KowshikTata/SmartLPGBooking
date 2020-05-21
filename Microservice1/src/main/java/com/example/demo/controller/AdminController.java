package com.example.demo.controller;

import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.client.CustomerClient;
import com.example.demo.dao.AdminDAO;
import com.example.demo.dao.CustomerDAO;
import com.example.demo.dao.ProductDAO;
import com.example.demo.model.Customer;
import com.example.demo.model.Product;
@CrossOrigin("*")
@RestController
@EnableAutoConfiguration
public class AdminController {
	
	private CustomerClient customerClient;
	private AdminDAO admindao;
	private CustomerDAO customerdao;
	private ProductDAO productdao;

	
	
	
	public AdminController(CustomerClient customerClient, AdminDAO admindao, CustomerDAO customerdao,
			ProductDAO productdao) {
		super();
		this.customerClient = customerClient;
		this.admindao = admindao;
		this.customerdao = customerdao;
		this.productdao = productdao;
	}
	@RequestMapping("/admin/product")
	public List<Product> view()
	{
		return customerClient.viewProduct();
	}
	@RequestMapping("/admin/getCustomers")
	public List<Customer> getCustomers()
	{
		return customerdao.findAll();
	}
	@RequestMapping("/admin/view/PahalRequests")
	public List<Customer> requests()
	{
		return customerdao.findByRequestingPahal(true);
	}
	@PutMapping("/admin/acceptPahalRequest/{customerId}")
	public Customer accept(@PathVariable Integer customerId)
	{
		Customer customer=customerdao.findById(customerId).get();
		customer.setJoinedPahal(true);
		return customerdao.save(customer);
	}
	@PutMapping("/admin/updatePrice/{productId}/{price}")
	public Product updatePrice(@PathVariable Integer productId,@PathVariable Integer price)
	{
		Product p=productdao.findById(productId).get();
		p.setPrice(price);
		return productdao.save(p);
	}
}
