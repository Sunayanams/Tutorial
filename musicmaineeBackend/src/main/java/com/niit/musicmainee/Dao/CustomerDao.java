package com.niit.musicmainee.Dao;

import java.util.List;

import com.niit.musicmainee.entity.Cart;
import com.niit.musicmainee.entity.Customer;

public interface CustomerDao
{

	public boolean save(Customer customer);
	
	public boolean update(Customer customer);
	
	public boolean delete(String c_id);
	
	public Customer get(String user_id);
	
	public List<Customer> list();

	
}
