package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.model.Product;

@Repository
public interface ProductDAO extends JpaRepository<Product,Integer>{

}
