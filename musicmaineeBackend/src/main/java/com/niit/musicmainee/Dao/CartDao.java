package com.niit.musicmainee.Dao;

import java.util.List;

import com.niit.musicmainee.entity.Cart;

public interface CartDao {
	public boolean saveorupdate(Cart cart);

//	public boolean update(Cart cart);
	
	public boolean delete(String cart_id);

	public Cart get(String user_id);

	public List<Cart> list();
}
