package com.niit.musicmainee.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table
@Component
public class Product {
	@Id
	private String product_id;
	private String product_name;
	private double product_price;
	private int product_quantity;
	private String product_description;
	private String image;
	@Transient
	private MultipartFile img;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private CategoryDetails category;

	@ManyToOne
	@JoinColumn(name = "supplier_id")
	private SupplierDetails supplier;

	public Product() {
		this.product_id = "product" + UUID.randomUUID().toString().substring(30).toUpperCase();
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public MultipartFile getImg() {
		return img;
	}

	public void setImg(MultipartFile img) {
		this.img = img;
	}

	public SupplierDetails getSupplier() {
		return supplier;
	}

	public void setSupplier(SupplierDetails supplier) {
		this.supplier = supplier;
	}

	public CategoryDetails getCategory() {
		return category;
	}

	public void setCategory(CategoryDetails category) {
		this.category = category;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public double getProduct_price() {
		return product_price;
	}

	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}

	public int getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}

	public String getProduct_description() {
		return product_description;
	}

	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}

}
