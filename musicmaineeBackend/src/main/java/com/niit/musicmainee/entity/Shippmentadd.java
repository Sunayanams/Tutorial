package com.niit.musicmainee.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Table
@Entity
@Component
public class Shippmentadd {
	@Id
	private String shippmentadd_id;
	@ManyToOne
	@JoinColumn(name="c_id")
	private Customer customer;
	private String s_address;

	public Shippmentadd() {
		this.shippmentadd_id = "shippment" + UUID.randomUUID().toString().substring(30).toUpperCase();
	}

	public String getShippmentadd_id() {
		return shippmentadd_id;
	}

	public void setShippmentadd_id(String shippmentadd_id) {
		this.shippmentadd_id = shippmentadd_id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getAddress() {
		return s_address;
	}

	public void setS_address(String s_address) {
		this.s_address = s_address;
	}
	
}
