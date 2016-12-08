package com.niit.musicmainee;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.musicmainee.Dao.CategoryDetailsDao;
import com.niit.musicmainee.Dao.SupplierDetailsDao;
import com.niit.musicmainee.entity.CategoryDetails;
import com.niit.musicmainee.entity.Product;
import com.niit.musicmainee.entity.SupplierDetails;

public class SupplierDetailsTest 
{
 public static void main(String a[])
 {
	 AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	 context.scan("com.niit.*");
	 context.refresh();
	 
	  SupplierDetailsDao supplierdetailsDao  =(SupplierDetailsDao )context.getBean("supplierdetailsDao");
	  SupplierDetails  supplierdetails=( SupplierDetails)context.getBean("supplierDetails");
	   System.out.println(1);
	   
//	   supplierdetails.setSupplier_id("hdmk568");
	   supplierdetails.setSupplier_name("asd");
	   supplierdetails.setSupplier_address("bangalore");
	   supplierdetails.setSupplier_description("hi");
	   System.out.println(2);
	   
	   if(supplierdetailsDao.saveorupdate(supplierdetails)==true)
		{
			System.out.println(3);
			System.out.println("saved");
		}
	   else
		{
			System.out.println(4);
			System.out.println("sorry");
		}
	   
//        if(supplierdetailsDao.delete("jfj87")==true)
//        {
//        	System.out.println("done");
//        }
//        else
//        {
//        	System.out.println("sorry");
//        }

     SupplierDetails l1= (SupplierDetails)supplierdetailsDao.get("hdmk568");
     if(l1==null)
     {
    	 System.out.println("there is no record found");
     }
     else
     {
    	 System.out.println(l1.getSupplier_id()+l1.getSupplier_name()+l1.getSupplier_description());
     }
     
     List<SupplierDetails> lsupplierdetails=(List<SupplierDetails>) supplierdetailsDao.list();
     if(lsupplierdetails==null || lsupplierdetails.isEmpty())
		{
			System.out.println("no data found");
		}
     else
     {
    	 for(SupplierDetails p:lsupplierdetails)
    	 {
    		 System.out.println(p.getSupplier_id());
    		 System.out.println(p.getSupplier_name());
    		 System.out.println(p.getSupplier_description());
    		 System.out.println(p.getSupplier_address());
    	 }
    		 
     }
 }
}
