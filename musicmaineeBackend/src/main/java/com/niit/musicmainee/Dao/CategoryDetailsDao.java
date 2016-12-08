package com.niit.musicmainee.Dao;

import java.util.List;

import com.niit.musicmainee.entity.CategoryDetails;

public interface CategoryDetailsDao
{
  public boolean saveorupdate(CategoryDetails categorydetails);
  public boolean update(CategoryDetails categorydetails);
  public boolean delete(String category_id);
  public CategoryDetails get(String category_id);
  public List<CategoryDetails> list();
  
}
