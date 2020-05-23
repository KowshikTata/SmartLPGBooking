/*
 * package com.example.demo.controller;
 * 
 * import java.util.List;
 * 
 * import org.springframework.web.bind.annotation.CrossOrigin; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.PutMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.example.demo.dao.ProductDAO; import
 * com.example.demo.model.Product;
 * 
 * @CrossOrigin("*")
 * 
 * @RestController public class ProductController {
 * 
 * private ProductDAO productdao;
 * 
 * public ProductController(ProductDAO productdao) { super(); this.productdao =
 * productdao; }
 * 
 * @RequestMapping("/api/products") public List<Product> view() { return
 * productdao.findAll(); }
 * 
 * @PostMapping("/api/addProduct") public Product add(@RequestBody Product
 * product) { return productdao.save(product); }
 * 
 * @PutMapping("/api/updateProduct/{id}") public Product update(@PathVariable
 * Integer id,@RequestBody Product product) { if(productdao.findById(id)!=null)
 * { return productdao.save(product); } return null; }
 * 
 * }
 */
package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ProductDAO;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
@CrossOrigin("*")
@RestController
public class ProductController {

	private ProductService productService;
	
	public ProductController(ProductService productService) 
	{
		super();
		this.productService = productService;
	}
	
	@RequestMapping("/api/products")
	public List<Product> view()
	{
		return productService.view();
	}
	@PostMapping("/api/addProduct")
	public Product add(@RequestBody Product product)
	{
		return productService.add(product);
	}
	@PutMapping("/api/v1/products/{id}")
	public Product update(@PathVariable Integer id,@RequestBody Product product)
	{
		return productService.update(id, product);
	}
	 @RequestMapping("/products/{id}")
		public Optional<Product> getByid(@PathVariable Integer id)
		{
			return productService.getByid(id);
		}
	 @RequestMapping("/api/v1/products")
		public List<Product> viewProducts()
		{
			return productService.view();
		}
	 @RequestMapping("/api/v1/products/{id}")
		public Optional<Product> getProductByid(@PathVariable Integer id)
		{
			return productService.getByid(id);
		}
}
