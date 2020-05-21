package com.example.demo.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Customer;
import com.example.demo.model.Order;


@Repository
public interface OrderDAO extends JpaRepository<Order,Integer>{

	Iterable<Order> findByCustomer(Customer customer);

}
