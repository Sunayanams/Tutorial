package com.niit.musicmainee;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.musicmainee.Dao.ProductDao;
import com.niit.musicmainee.entity.CategoryDetails;
import com.niit.musicmainee.entity.Product;
import com.niit.musicmainee.entity.SupplierDetails;

public class ProductTest 
{
	
   public static void main(String a[])
   {
	   AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		
		ProductDao productDao=(ProductDao)context.getBean("productDao");
		Product product=(Product)context.getBean("product");
		System.out.println(1);
		
		CategoryDetails obj= new CategoryDetails();
		obj.setCategory_id("hu5685");
		
		SupplierDetails obj1= new SupplierDetails();
		obj1.setSupplier_id("hdmk568");
		
		product.setProduct_id("hjy54");
		product.setProduct_name("jack");
		product.setProduct_price(35871);
		product.setProduct_quantity(3);
		product.setProduct_description("welcome");	
		product.setCategory(obj);
		product.setSupplier(obj1);
		System.out.println(2);
		
		if(productDao.saveorupdate(product)==true)
		{
			System.out.println(3);
			System.out.println("saved");
		}
		else
		{
			System.out.println(4);
			System.out.println("sorry");
		}
		
//		if(productDao.delete("hdhhh1022")==true)
//		{
//			System.out.println("done");
//		}
//		else
//		{
//			System.out.println("sorry");
//		}
		
		
		
		
//		
//		Product l1 = (Product)productDao.get("hdhhh1022");
//		if(l1==null)
//		{
//			System.out.println("there is no record found");
//		}
//		else
//		{
//			System.out.println(l1.getCategory_id()+l1.getProduct_id()+l1.getSupplier_id()+l1.getProduct_name());
//		}
//		
		
		List<Product> lproduct=(List<Product>) productDao.list();
		if(lproduct==null || lproduct.isEmpty())
		{
			System.out.println("no data found");
		}
		else
		{
			for(Product p:lproduct)
			{
				System.out.println(p.getProduct_id());
				System.out.println(p.getProduct_name());
				System.out.println(p.getProduct_price());
				System.out.println(p.getProduct_description());
				System.out.println(p.getProduct_quantity());
//				System.out.println(p.getSupplier_id());
//				System.out.println(p.getCategory_id());
				
				
			}
		}
   }
	
}
