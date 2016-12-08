package com.niit.musicmainee;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.musicmainee.Dao.CategoryDetailsDao;
import com.niit.musicmainee.Dao.ProductDao;
import com.niit.musicmainee.entity.CategoryDetails;
import com.niit.musicmainee.entity.Product;
import com.niit.musicmainee.entity.SupplierDetails;

public class CategoryDetailsTest 
{
   public static void main(String a[])
   {
	   AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	   context.scan("com.niit.*");
	   context.refresh();
	   
	   CategoryDetailsDao categorydetailsDao =(CategoryDetailsDao)context.getBean("categorydetailsDao");
	   CategoryDetails categorydetails=(CategoryDetails)context.getBean("categoryDetails");
	   ProductDao productDao=(ProductDao)context.getBean("productDao");
	   Product product=(Product)context.getBean("product");
	   System.out.println(1);
	   
//	   categorydetails.setCategory_id("hu5685");
	   categorydetails.setCategory_name("bhg");
	   categorydetails.setCategory_description("kjhifd");
	   System.out.println(2);
	   
	   if(categorydetailsDao.saveorupdate(categorydetails)==true)
		{
			System.out.println(3);
			System.out.println("saved");
		}
	   else
		{
			System.out.println(4);
			System.out.println("sorry");
		}
	   
//	   if(categorydetailsDao.delete("hu5685")==true)
//	   {
//		   System.out.println("done");
//	
//	   }
//	   else
//	   {
//		   System.out.println("sorry");
//	   }
	   
	   CategoryDetails l1= (CategoryDetails)categorydetailsDao.get("hu5685");
	     if(l1==null)
	     {
	    	 System.out.println("there is no record found");
	    	 
	     }
	     else
	     {
	    	 System.out.println(l1.getCategory_id()+l1.getCategory_name()+l1.getCategory_description());
	    	 List<Product> list=(List<Product>)productDao.getbycat("hu5685");
	    	 categorydetails.setPro(list);
	    	 List<Product> list2=categorydetails.getPro();
	    	 for(Product p:list2)
	    	 {
	    		 System.out.println("Product Name"+p.getProduct_name());
	    	 }
	     }
	 

	     List<CategoryDetails> lcategorydetails=(List<CategoryDetails>) categorydetailsDao.list();
	     
	     if(lcategorydetails==null || lcategorydetails.isEmpty())
			{
				System.out.println("no data found");
			}
	     else
	     {
	    	for(CategoryDetails p:lcategorydetails)
	    	 {
	    		 System.out.println(p.getCategory_id());
	    		 System.out.println(p.getCategory_name());
	    		 System.out.println(p.getCategory_description());
	    	 }
	     }
  }
		
}
