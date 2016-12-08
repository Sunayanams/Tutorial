package com.niit.musicmainee.Dao;

import java.util.List;

import com.niit.musicmainee.entity.SupplierDetails;

public interface SupplierDetailsDao 
{
	  public boolean saveorupdate(SupplierDetails supplierdetails);
	  public boolean delete(String supplier_id);
	  public SupplierDetails get(String supplier_id);
	  public List<SupplierDetails> list();
	  void editSupplier(SupplierDetails supplierdetails);
}
