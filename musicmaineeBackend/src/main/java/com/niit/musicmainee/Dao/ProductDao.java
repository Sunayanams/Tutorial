package com.niit.musicmainee.Dao;

import java.util.List;

import com.niit.musicmainee.entity.Product;

public interface ProductDao 
{
  public boolean saveorupdate(Product product);
  public boolean delete(String product_id);
  public Product get(String product_id);
  public List<Product> list();
  public List<Product> getbycat(String category_id);
  void editProduct(Product product);
}
