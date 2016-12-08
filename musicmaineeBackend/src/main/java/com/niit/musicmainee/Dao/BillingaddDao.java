package com.niit.musicmainee.Dao;

import java.util.List;

import com.niit.musicmainee.entity.Billingadd;
import com.niit.musicmainee.entity.Cart;

public interface BillingaddDao 
{
	public boolean save(Billingadd billingadd);
	
	public boolean update(Billingadd billingadd);
	
	public boolean delete(String billingadd_id);
	
	public Billingadd get(String billingadd_id);
	
	public List<Billingadd> list();
}

