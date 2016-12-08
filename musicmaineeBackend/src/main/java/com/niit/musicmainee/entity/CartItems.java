package com.niit.musicmainee.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class CartItems {
	@Id
	private String cartitems_id;
	private String user_id;
	private String c_id;
	private String product_id;
	private String product_name;
	private int quantity;
	private double total_price;
	@ManyToOne
	@JoinColumn(name = "cart_id")
	private Cart cart;

	public CartItems() {
		this.cartitems_id = "cartitems" + UUID.randomUUID().toString().substring(30).toUpperCase();
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getCartitems_id() {
		return cartitems_id;
	}

	public void setCartitems_id(String cartitems_id) {
		this.cartitems_id = cartitems_id;
	}

	public String getC_id() {
		return c_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}

}
