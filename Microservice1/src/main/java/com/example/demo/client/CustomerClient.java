package com.example.demo.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Product;



@FeignClient(value="service")
public interface CustomerClient {

	@RequestMapping("/api/products")
	public List<Product> viewProduct();
	
}
