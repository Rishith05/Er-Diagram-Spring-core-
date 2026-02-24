package com.lpu.entities;

import java.util.List;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
@Cacheable
@Entity
public class Products {
	@Id
	private int product_id;
	private String product_name;
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
	private Categories categories;
	@ManyToMany(mappedBy = "products", fetch = FetchType.LAZY)
	private List<Orders> orders;
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public Categories getCategories() {
		return categories;
	}
	public void setCategories(Categories categories) {
		this.categories = categories;
	}
	public List<Orders> getOrders() {
		return orders;
	}
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	
	
}
