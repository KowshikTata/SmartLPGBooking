package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="gas")
public class Product {
	@Id
	private int id;
	private int price;
	@Column(name="units_in_stock")
	private int unitsInStock;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getUnitsInStock() {
		return unitsInStock;
	}
	public void setUnitsInStock(int unitsInStock) {
		this.unitsInStock = unitsInStock;
	}
	public Product(int price, int unitsInStock) {
		super();
		this.price = price;
		this.unitsInStock = unitsInStock;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", price=" + price + ", unitsInStock=" + unitsInStock + "]";
	}
	
}
