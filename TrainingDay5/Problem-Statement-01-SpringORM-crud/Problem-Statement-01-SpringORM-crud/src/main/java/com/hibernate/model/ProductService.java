package com.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class ProductService implements ProductServiceImpl {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "price")
	private double Price;
	
	@Column(name = "quantity")
	private int Quantity;
	
	
	public ProductService() {
		super();
		
	}
	public ProductService(String name, double price, int quantity) {
		super();
		this.id = id;
		this.name = name;
		Price = price;
		Quantity = quantity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	@Override
	public String toString() {
		return "ProductService [id=" + id + ", name=" + name + ", Price=" + Price + ", Quantity=" + Quantity + "]";
	}
	@Override
	public void setPrice(String price) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setQuantity(String quantity) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
