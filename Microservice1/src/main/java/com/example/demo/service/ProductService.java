package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Product;

public interface ProductService
{
	public List<Product> view();
	public Product add(Product product);
	public Product update(Integer id,Product product);
	public Optional<Product> getByid( Integer id);

}
