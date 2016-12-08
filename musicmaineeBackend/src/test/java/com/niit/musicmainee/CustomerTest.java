//package com.niit.musicmainee;
//
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import com.niit.musicmainee.Dao.CartDao;
//import com.niit.musicmainee.Dao.CustomerDao;
//import com.niit.musicmainee.Dao.UserDetailsDao;
//import com.niit.musicmainee.entity.Billingadd;
//import com.niit.musicmainee.entity.Cart;
//import com.niit.musicmainee.entity.Customer;
//import com.niit.musicmainee.entity.UserDetails;
//
//public class CustomerTest 
//{
//  public static void main(String args[]) 
//  {
//	  AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
//	  context.scan("com.niit.*");
//	  context.refresh();
//	  System.out.println(1); 
//		 
//	  CustomerDao customerDao  =(CustomerDao )context.getBean("customerDao");
//	  Customer  customer=( Customer)context.getBean("customer");
//	  UserDetailsDao userdetailsDao =(UserDetailsDao)context.getBean("userdetailsDao");
//      UserDetails  userdetails=(UserDetails)context.getBean("userDetails");
//      CartDao cartDao=(CartDao)context.getBean("cartDao");
//      Cart cart=(Cart)context.getBean("cart");
//      
//      
//      
//	  Customer cus=(Customer)customerDao.get("userEE8968");
//	  if(cus==null)
//	  {
//		  UserDetails u=(UserDetails)userdetailsDao.get("userEE8968");
//		  System.out.println("not a user");
//		  
//		  customer.setC_name(u.getUser_name());
//		  customer.setC_emailid(u.getEmail_id());
//		  customer.setC_phoneno(u.getUser_phoneno());
//		  customer.setUser_id(u.getUser_id());
////		  customer.setCart(cart);
//		  if(customerDao.save(customer)==true)
//		  {
//			  System.out.println("u are a new customer");
//		  }
//		  
//		  
//	  }
//	  else
//	  {
//		  System.out.println("cart is there");
//	  }
//	  Cart c=(Cart)cartDao.get(cus.getC_id());
//	  if(c==null)
//	  {
//		  cart.setCustomer(cus);
//		  cart.setGrand_total("0");
//		  if(cartDao.saveorupdate(cart)==true)
//		  {
//			  cus.setCart(cart);
//			  if(customerDao.update(cus)==true)
//			  {
//				  System.out.println("update is done");
//			  }
//			 System.out.println("new cart is created"); 
//		  }
//	  }
//	  else
//	  {
//		  System.out.println("u have a cart");
//	  }
//	  
//	  
//  }
//}
