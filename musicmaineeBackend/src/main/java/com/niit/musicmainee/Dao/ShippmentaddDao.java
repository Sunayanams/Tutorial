package com.niit.musicmainee.Dao;

import java.util.List;

import com.niit.musicmainee.entity.Shippmentadd;

public interface ShippmentaddDao 
{
	public boolean save(Shippmentadd shippmentadd);
	
	public boolean update(Shippmentadd shippmentadd);
	
	public boolean delete(String shippmentadd_id);
	
	public Shippmentadd get(String shippmentadd_id);
	
	public List<Shippmentadd> list();
}
