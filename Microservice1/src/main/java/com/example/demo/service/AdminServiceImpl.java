package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.client.CustomerClient;
import com.example.demo.dao.AdminDAO;
import com.example.demo.dao.CustomerDAO;
import com.example.demo.dao.ProductDAO;
import com.example.demo.model.Admin;
import com.example.demo.model.Customer;
import com.example.demo.model.Product;

@Service
public class AdminServiceImpl implements AdminService
{
	private CustomerClient customerClient;
	private AdminDAO admindao;
	private CustomerDAO customerdao;
	private ProductDAO productdao;


	public AdminServiceImpl(CustomerClient customerClient, AdminDAO admindao, CustomerDAO customerdao,
			ProductDAO productdao) {
		super();
		this.customerClient = customerClient;
		this.admindao = admindao;
		this.customerdao = customerdao;
		this.productdao = productdao;
	}

	@Override
	public List<Product> view() 
	{
		// TODO Auto-generated method stub
		return customerClient.viewProduct();
	}

	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerdao.findAll();
	}

	@Override
	public List<Customer> requests() {
		// TODO Auto-generated method stub
		return customerdao.findByRequestingPahal(true);
	}

	@Override
	public Customer accept(Integer customerId) {
		// TODO Auto-generated method stub
		Customer customer=customerdao.findById(customerId).get();
		customer.setJoinedPahal(true);
		return customerdao.save(customer);
	}

	@Override
	public Product updatePrice(Integer productId, Integer price)
	{
		Product p=productdao.findById(productId).get();
		p.setPrice(price);
		return productdao.save(p);

	}
	@Override
	public Admin adminLogin(Admin admin) 
	{
		String tempUserId=admin.getUserName();
		String tempPass=admin.getPassword();
		Admin adminObj=null;
		if(tempUserId!=null && tempPass!=null) 
		{
		   adminObj= admindao.findByUserNameAndPassword(tempUserId,tempPass);
	     }
		if(adminObj==null) {
			throw new AdminNotFoundException("user does not exists");
		}
	     return adminObj;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Admin loginAdmin(String userName, String password) {
		return admindao.findByUserNameAndPassword(userName,password);
		
	}
}
