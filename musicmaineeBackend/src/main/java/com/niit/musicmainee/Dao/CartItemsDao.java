package com.niit.musicmainee.Dao;

import java.util.List;

import com.niit.musicmainee.entity.CartItems;

public interface CartItemsDao {
	public boolean save(CartItems cartitems);
	
//	public boolean update(CartItems cartitems);

	public boolean delete(CartItems cartitems);
	
	public boolean prodelete(CartItems cartitems);

	public List<CartItems> get(String cart_id);

	public List<CartItems> list();
	
	public CartItems getbyCartItems(String id);
}
