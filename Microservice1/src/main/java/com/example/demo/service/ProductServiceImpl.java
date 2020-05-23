package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dao.ProductDAO;
import com.example.demo.model.Product;
@Service
public class ProductServiceImpl implements ProductService 
{
	private ProductDAO productdao;
	
	public ProductServiceImpl(ProductDAO productdao) {
		super();
		this.productdao = productdao;
	}

	@Override
	public List<Product> view()
	{
		// TODO Auto-generated method stub
		return productdao.findAll();
	}

	@Override
	public Product add(Product product) 
	{
		// TODO Auto-generated method stub
		return productdao.save(product);
	}

	@Override
	public Product update(Integer id, Product product) 
	{
		if(productdao.findById(id)!=null)
		{
			return productdao.save(product);
		}
		return null;
	}
	public Optional<Product> getByid(Integer id)
	{
		return productdao.findById(id);
	}

}
