package com.example.demo.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.client.CustomerClient;
import com.example.demo.dao.CustomerDAO;
import com.example.demo.dao.OrderDAO;
import com.example.demo.dao.ProductDAO;
import com.example.demo.dao.RegistrationDAO;
import com.example.demo.model.Customer;
import com.example.demo.model.Order;
import com.example.demo.model.Product;
import com.example.demo.model.Registration;

@Service
public class CustomerServiceImpl implements CustomerService
{
	private CustomerClient customerClient;
	private CustomerDAO customerdao;
	private RegistrationDAO registerdao;
	private OrderDAO orderdao;
	private ProductDAO productdao;


	public CustomerServiceImpl(CustomerClient customerClient, CustomerDAO customerdao, RegistrationDAO registerdao,
			OrderDAO orderdao, ProductDAO productdao) {
		super();
		this.customerClient = customerClient;
		this.customerdao = customerdao;
		this.registerdao = registerdao;
		this.orderdao = orderdao;
		this.productdao = productdao;
	}

	@Override
	public List<Product> view() {
		// TODO Auto-generated method stub
		return customerClient.viewProduct();
	}

	@Override
	public Customer viewProfile(String email) {
		Registration user=registerdao.findByEmail(email).get();
		return customerdao.findByRegistration(user);
	}

	@Override
	public Order bookLPG(String email) {
		Registration user=registerdao.findByEmail(email).get();
		Customer customer=customerdao.findByRegistration(user);
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

	@Override
	public ResponseEntity<String> request(String email) {
		Registration user=registerdao.findByEmail(email).get();
		Customer customer=customerdao.findByRegistration(user);
		if(customer!=null)
		{
			if(customer.isRequestingPahal()==true)
			{
				return ResponseEntity.status(HttpStatus.OK).body("Already Requested!!");
			}
			else
			{
		customer.setRequestingPahal(true);
		customerdao.save(customer);
		return ResponseEntity.status(HttpStatus.OK).body("Request Processed!!");
			}
		}else
		{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Please apply for LPG Connection!!");
		}
	}

	@Override
	public ResponseEntity<String> giveUp(String email) {
		Registration user=registerdao.findByEmail(email).get();
		Customer customer=customerdao.findByRegistration(user);
		if(customer!=null)
		{
			if(customer.isJoinedPahal()==true)
			{
				if(customer.isGivingUpSubsidy()==false)
				{
					customer.setGivingUpSubsidy(true);
					customerdao.save(customer);
					return ResponseEntity.status(HttpStatus.OK).body("GivedUp Subsidy!!");
				}
				else
				{
					return ResponseEntity.status(HttpStatus.OK).body("Already GivedUp Subsidy!!");
				}
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

	@Override
	public List<Order> orders(String email) {
		
		Registration user=registerdao.findByEmail(email).get();
		Customer customer=customerdao.findByRegistration(user);
		return (List<Order>) orderdao.findByCustomer(customer);
	}

	@Override
	public ResponseEntity<Iterable<Order>> allorders() 
	{
		return ResponseEntity.ok().body(orderdao.findAll());
	}
	public List<Customer> listAllCustomers()
	{
		return customerdao.findAll();
	}
	
	public Optional<Customer> getById(Integer id)
	{
		return customerdao.findById(id);
	}
	public Customer updateAll(Integer id, Customer customer)
	{
		if(customerdao.findById(id)!=null)
		{
			return customerdao.save(customer);
		}
		return null;
	}
	
	
	public Optional<Order> getOrderByid(Integer id)
	{
		return orderdao.findById(id);
	}
	
	public Order updateAll(Integer id, Order order)
	{
		if(orderdao.findById(id)!=null)
		{
			return orderdao.save(order);
		}
		return null;
	}

	@Override
	public int findByRequestingPahal(String email) {
		Registration user=registerdao.findByEmail(email).get();
		Customer cust=customerdao.findByRegistration(user);
		if(cust!=null)
		{
			if(cust.isGivingUpSubsidy())
			{
				return 2;//you already givedUp subsidy can't request another
			}
		else if(cust.isRequestingPahal()==true)
			{
				return 0;//already requseted!!
			}
			else
			{
				cust.setRequestingPahal(true);
				customerdao.save(cust);
				return 1;//requset processed!!
			}
			
		}
		return  -1;//no LPG connec found!!
	}

	@Override
	public int findByIsGivingUpSubsidy(String email) {
		Registration user=registerdao.findByEmail(email).get();
		Customer cust=customerdao.findByRegistration(user);
		//0-regsiter for connection
				//1-givedUp
				//2-already givedUp sub
		if(cust!=null)
		{
		
		if(cust.isJoinedPahal()==true && cust.isGivingUpSubsidy()==false)
			{
			cust.setGivingUpSubsidy(true);
			customerdao.save(cust);
				return 1;// givedUp
			}
			else if(cust.isJoinedPahal()==true && cust.isGivingUpSubsidy()==true)
			{
				return 2;//already gived Up
			}
			else if(cust.isJoinedPahal()==false)
			{
				return 3;//aply for pahal
			}
		}
		
		return 0;//apply connection
	}

	
}
