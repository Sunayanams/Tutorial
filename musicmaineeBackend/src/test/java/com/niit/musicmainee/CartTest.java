package com.niit.musicmainee;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.musicmainee.Dao.CartDao;
import com.niit.musicmainee.Dao.CartItemsDao;
import com.niit.musicmainee.Dao.CustomerDao;
import com.niit.musicmainee.Dao.ProductDao;
import com.niit.musicmainee.entity.Cart;
import com.niit.musicmainee.entity.CartItems;
import com.niit.musicmainee.entity.Customer;
import com.niit.musicmainee.entity.Product;

public class CartTest 
{
	public static void main(String a[])
	 {
		 AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		 context.scan("com.niit.*");
		 context.refresh();
		 
		 CartDao cartDao  =(CartDao )context.getBean("cartDao");
		 Cart  cart=( Cart)context.getBean("cart");
		 CartItemsDao cartitemsDao = (CartItemsDao) context.getBean("cartitemsDao");
		 CartItems cartitems = (CartItems) context.getBean("cartItems");
		 ProductDao productDao=(ProductDao)context.getBean("productDao");
		 Product product=(Product)context.getBean("product");
		 Customer customer=(Customer)context.getBean("customer");
		 CustomerDao customerDao=(CustomerDao)context.getBean("customerDao");
		 
		 System.out.println(1);
		 
		 
		 Cart c=(Cart)cartDao.get("cust70E075");
		  if(c==null)
		  {
			  System.out.println("cart is not there");
		  }
		  else
		  {
			  Product p=(Product)productDao.get("productFC6828");	
			  cartitems.setProduct_id(p.getProduct_id());
			  cartitems.setQuantity(4);
			  cartitems.setCart(c);
			  cartitems.setC_id("cust70E075");
			  cartitems.setTotal_price(cartitems.getQuantity()*p.getProduct_price());	
			  if(cartitemsDao.save(cartitems)==true)
				 {
				      String g=c.getGrand_total();
				      double t=cartitems.getTotal_price();
				      
				     double gt=Double.parseDouble(g);
				     gt=gt+t;
				     String gt1=String.valueOf(gt);
				     c.setGrand_total(gt1);
				     if(cartDao.saveorupdate(c)==true)
				    	 System.out.println("cart is updated");
					 System.out.println("Item is add to cartlist");
				 }
		  }
		 
		 
		 //cart.setGrand_total(cartitems.getTotal_price()+cart.getGrand_total());
		
		 
//		 List<CartItems> l= (List<CartItems>) cartitemsDao.get("cart7F7AD7");
//		 for(CartItems l1: l)
//		 {
//			System.out.println(l1.getCart_id()); 
//			System.out.println(l1.getCartitems_id());
//			System.out.println(l1.getProduct_id());
//			System.out.println(l1.getUser_id());
//			System.out.println(l1.getQuantity());
//			System.out.println(l1.getTotal_price());
//		 }
		 
	     }
	}

