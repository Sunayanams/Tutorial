package com.niit.musicmainee.Dao;

import java.util.List;

import com.niit.musicmainee.entity.Cart;
import com.niit.musicmainee.entity.Corder;

public interface CorderDao 
{
	public boolean save(Corder corder);

	public boolean delete(String user_id);

	public Corder get(String user_id);

	public List<Corder> list();
}
