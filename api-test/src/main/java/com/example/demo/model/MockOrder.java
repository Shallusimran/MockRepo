package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Orders object is saved in the embedded database H2
 * Some testing data is inserted by means of /src/main/resources/DB.sql 
 * */

@Entity
@Table(name="Mockorder")
public class MockOrder {
	
	@Id
	@Column(name="id")
	private String id;
	
	@Column(name="status")
	private String status;
	
	@Column(name="order_type")
	private String order_type;
	
	@Column(name="price")
	private double price;

	@Column(name="security")
	private String security;
	
	
	public MockOrder() {
		super();
	}

	public MockOrder(String id, String status, String order_type, String security) {
		super();
		this.id = id;
		this.status = status;
		this.order_type = order_type;
		this.security = security;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOrder_type() {
		return order_type;
	}

	public void setOrder_type(String order_type) {
		this.order_type = order_type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSecurity() {
		return security;
	}

	public void setSecurity(String security) {
		this.security = security;
	}
	
}
