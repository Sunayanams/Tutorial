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

@Table
@Entity
@Component
public class Customer {
	@Id
	private String c_id;
	private String c_name;
	private String c_phoneno;
	private String c_emailid;
	@OneToOne
	@JoinColumn(name="billingadd_id")
	private Billingadd billingadd;
	@OneToMany(mappedBy="customer",cascade=CascadeType.ALL)
	private List<Shippmentadd> shippmentadd;
	
	private String user_id;
	@OneToOne
	@JoinColumn(name="cart_id")
	private Cart cart;

	public Customer() {
		this.c_id = "cust" + UUID.randomUUID().toString().substring(30).toUpperCase();
	}

	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_phoneno() {
		return c_phoneno;
	}

	public void setC_phoneno(String c_phoneno) {
		this.c_phoneno = c_phoneno;
	}

	public String getC_emailid() {
		return c_emailid;
	}

	public void setC_emailid(String c_emailid) {
		this.c_emailid = c_emailid;
	}

	public Billingadd getBillingadd() {
		return billingadd;
	}

	public void setBillingadd(Billingadd billingadd) {
		this.billingadd = billingadd;
	}

	public List<Shippmentadd> getShippmentadd() {
		return shippmentadd;
	}

	public void setShippmentadd(List<Shippmentadd> shippmentadd) {
		this.shippmentadd = shippmentadd;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	

}
