package com.lpu.entities;

import java.util.List;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
@Cacheable
@Entity
public class Orders {
	@Id
	private int order_id;
	private String order_date;
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
	private Customer c;
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "delivery_id")
	private Delivery d;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "order_product")
	private List<Products> products;
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public Customer getC() {
		return c;
	}
	public void setC(Customer c) {
		this.c = c;
	}
	public Delivery getD() {
		return d;
	}
	public void setD(Delivery d) {
		this.d = d;
	}
	public List<Products> getProducts() {
		return products;
	}
	public void setProducts(List<Products> products) {
		this.products = products;
	}
	
	
	
}
