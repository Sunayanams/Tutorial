package com.niit.musicmainee.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Table
@Entity
@Component
public class Billingadd {
	@Id
	private String billingadd_id;
	@OneToOne
	@JoinColumn(name="c_id")
	private Customer customer;
	private String b_address;

	public Billingadd() {
		this.billingadd_id = "billing" + UUID.randomUUID().toString().substring(30).toUpperCase();
	}

	public String getBillingadd_id() {
		return billingadd_id;
	}

	public void setBillingadd_id(String billingadd_id) {
		this.billingadd_id = billingadd_id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getB_address() {
		return b_address;
	}

	public void setAddress(String b_address) {
		this.b_address = b_address;
	}
	

}
