package com.quitq.ECom.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; 
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private double price;
	@Column(nullable = false)
	private double discount;
	@Column(nullable = false)
	private String status="active";
	private boolean isOutOfStock=false;
	@ManyToOne
	private Vendor v;
	@ManyToOne
	private Category c;
	@ManyToOne
	private Warehouse warehouse;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public boolean isOutOfStock() {
		return isOutOfStock;
	}
	public void setOutOfStock(boolean isOutOfStock) {
		this.isOutOfStock = isOutOfStock;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	public Warehouse getWarehouse() {
		return warehouse;
	}
	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public Vendor getV() {
		return v;
	}
	public void setV(Vendor v) {
		this.v = v;
	}
	public Category getC() {
		return c;
	}
	public void setC(Category c) {
		this.c = c;
	}
	

}
