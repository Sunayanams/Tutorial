package com.niit.musicmainee.entity;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Cart {
	@Id
	private String cart_id;
	
	private String c_id;
	 
	private String user_id;
	
	private String grand_total;

	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
	private List<CartItems> cartItems;

	public Cart() {
		this.cart_id = "cart" + UUID.randomUUID().toString().substring(30).toUpperCase();
	}

	public String getCart_id() {
		return cart_id;
	}

	public void setCart_id(String cart_id) {
		this.cart_id = cart_id;
	}

	public String getc_id() {
		return c_id;
	}

	public void setc_id(String c_id) {
		this.c_id = c_id;
	}

	public String getGrand_total() {
		return grand_total;
	}

	public void setGrand_total(String grand_total) {
		this.grand_total = grand_total;
	}

	public List<CartItems> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItems> cartItems) {
		this.cartItems = cartItems;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

}
