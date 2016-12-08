package com.niit.musicmainee.entity;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class SupplierDetails 
{ 
	@Id
	private String supplier_id; 
	private String supplier_name;
	private String supplier_description;
	private String supplier_address;
	
	@OneToMany(mappedBy="supplier")
	List<Product> pro;
	
	
	public SupplierDetails()
	{
		this.supplier_id = "supplier"+UUID.randomUUID().toString().substring(34).toUpperCase();
	}
	public List<Product> getPro() {
		return pro;
	}
	public void setPro(List<Product> pro) {
		this.pro = pro;
	}
	public String getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}
	public String getSupplier_name() {
		return supplier_name;
	}
	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}
	public String getSupplier_description() {
		return supplier_description;
	}
	public void setSupplier_description(String supplier_description) {
		this.supplier_description = supplier_description;
	}
	public String getSupplier_address() {
		return supplier_address;
	}
	public void setSupplier_address(String supplier_address) {
		this.supplier_address = supplier_address;
	}

}
