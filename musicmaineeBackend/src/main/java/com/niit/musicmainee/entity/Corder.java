package com.niit.musicmainee.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Table
@Entity
@Component
public class Corder {
	@Id
	private String corder_id;
	private String b_address;
	private String s_address;
	private double tot_price;
    private String user_id;
    private String product_id;
    private String payment;
    
    
	public Corder() {
		this.corder_id = "corder" + UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getCorder_id() {
		return corder_id;
	}
	public void setCorder_id(String corder_id) {
		this.corder_id = corder_id;
	}
	
	public String getB_address() {
		return b_address;
	}
	public void setB_address(String b_address) {
		this.b_address = b_address;
	}
	public String getS_address() {
		return s_address;
	}
	public void setS_address(String s_address) {
		this.s_address = s_address;
	}
	public double getTot_price() {
		return tot_price;
	}
	public void setTot_price(double tot_price) {
		this.tot_price = tot_price;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
    
}
