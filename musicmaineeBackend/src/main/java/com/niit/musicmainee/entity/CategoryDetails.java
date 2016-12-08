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
public class CategoryDetails 
{
	@Id
	private String category_id; 
	private String category_name; 
	private String category_description;
	
	@OneToMany(mappedBy="category")
	List<Product> pro;
	
	
	public CategoryDetails() 
	{
		this.category_id = "category"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	public List<Product> getPro() {
		return pro;
	}
	public void setPro(List<Product> pro) {
		this.pro = pro;
	}
	public String getCategory_id() {
		return category_id;
	}
	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
	
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public String getCategory_description() {
		return category_description;
	}
	public void setCategory_description(String category_description) {
		this.category_description = category_description;
	}
	
 
}
