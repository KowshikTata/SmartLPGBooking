/*
 * package com.example.demo.controller;
 * 
 * import java.util.List;
 * 
 * import org.springframework.boot.autoconfigure.EnableAutoConfiguration; import
 * org.springframework.web.bind.annotation.CrossOrigin; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.PutMapping; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.example.demo.client.CustomerClient; import
 * com.example.demo.dao.AdminDAO; import com.example.demo.dao.CustomerDAO;
 * import com.example.demo.dao.ProductDAO; import
 * com.example.demo.model.Customer; import com.example.demo.model.Product;
 * 
 * @CrossOrigin("*")
 * 
 * @RestController
 * 
 * @EnableAutoConfiguration public class AdminController {
 * 
 * private CustomerClient customerClient; private AdminDAO admindao; private
 * CustomerDAO customerdao; private ProductDAO productdao;
 * 
 * 
 * 
 * 
 * public AdminController(CustomerClient customerClient, AdminDAO admindao,
 * CustomerDAO customerdao, ProductDAO productdao) { super();
 * this.customerClient = customerClient; this.admindao = admindao;
 * this.customerdao = customerdao; this.productdao = productdao; }
 * 
 * @RequestMapping("/admin/product") public List<Product> view() { return
 * customerClient.viewProduct(); }
 * 
 * @RequestMapping("/admin/getCustomers") public List<Customer> getCustomers() {
 * return customerdao.findAll(); }
 * 
 * @RequestMapping("/admin/view/PahalRequests") public List<Customer> requests()
 * { return customerdao.findByRequestingPahal(true); }
 * 
 * @PutMapping("/admin/acceptPahalRequest/{customerId}") public Customer
 * accept(@PathVariable Integer customerId) { Customer
 * customer=customerdao.findById(customerId).get();
 * customer.setJoinedPahal(true); return customerdao.save(customer); }
 * 
 * @PutMapping("/admin/updatePrice/{productId}/{price}") public Product
 * updatePrice(@PathVariable Integer productId,@PathVariable Integer price) {
 * Product p=productdao.findById(productId).get(); p.setPrice(price); return
 * productdao.save(p); } }
 */
package com.example.demo.controller;

import java.util.List;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.client.CustomerClient;
import com.example.demo.dao.AdminDAO;
import com.example.demo.dao.CustomerDAO;
import com.example.demo.dao.ProductDAO;
import com.example.demo.model.Admin;
import com.example.demo.model.Customer;
import com.example.demo.model.Product;
import com.example.demo.service.AdminService;
@CrossOrigin("*")
@RestController
@EnableAutoConfiguration
public class AdminController
{
	private AdminService adminService;
	
	
    public AdminController(AdminService adminService) {
		super();
		this.adminService = adminService;
	}

	@RequestMapping("/admin/product")
	public List<Product> view()
	{
		return adminService.view();
	}
	@RequestMapping("/admin/getCustomers")
	public List<Customer> getCustomers()
	{
		return adminService.getCustomers();
	}
	@RequestMapping("/admin/view/PahalRequests")
	public List<Customer> requests()
	{
		return adminService.requests();
	}
	@PutMapping("/admin/acceptPahalRequest/{customerId}")
	public Customer accept(@PathVariable Integer customerId)
	{
		return adminService.accept(customerId);
	}
	@PutMapping("/admin/updatePrice/{productId}/{price}")
	public Product updatePrice(@PathVariable Integer productId,@PathVariable Integer price)
	{
		return adminService.updatePrice(productId, price);
	}
	@PostMapping("/api/v1/login")
	public ResponseEntity<Admin> loginUser(@RequestBody Admin admin) 
	{
		Admin admin1=adminService.adminLogin(admin);
		return new ResponseEntity<Admin>(admin1,HttpStatus.OK);
	}
	@GetMapping("/api/v1/loginAdmin/{userName}/{password}")
	public ResponseEntity<Admin> loginAdmin(@PathVariable String userName,String password) 
	{
		Admin admin1=adminService.loginAdmin(userName,password);
		return new ResponseEntity<Admin>(admin1,HttpStatus.OK);
	}
}
