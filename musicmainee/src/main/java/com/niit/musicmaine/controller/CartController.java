package com.niit.musicmaine.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.musicmainee.Dao.CartDao;
import com.niit.musicmainee.Dao.CartItemsDao;
import com.niit.musicmainee.Dao.ProductDao;
import com.niit.musicmainee.Dao.UserDetailsDao;
import com.niit.musicmainee.entity.Cart;
import com.niit.musicmainee.entity.CartItems;
import com.niit.musicmainee.entity.Product;
import com.niit.musicmainee.entity.UserDetails;

@Controller
public class CartController 
{
 @Autowired
 Cart cart;
 @Autowired
 CartDao cartDao;
 
 @Autowired
 UserDetails u;
 @Autowired
 UserDetailsDao userDetailsDao;
 
 @Autowired
 Product product;
 @Autowired
 ProductDao productDao;
 
 @Autowired
 CartItems cartitems;
 @Autowired
 CartItemsDao cartitemsDao;
	
 @RequestMapping("/addtocart/{product_id}") 
 public ModelAndView addtocart(@PathVariable("product_id")String product_id,Model model)
 {
	System.out.println("add to cart");
	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	if (!(authentication instanceof AnonymousAuthenticationToken))
	{
		System.out.println("i am coming");
		String currentUserName= authentication.getName();
		u=(UserDetails)userDetailsDao.getName(currentUserName);
		if(u==null)
		{
		 System.out.println("sorry");	
		}
		else
		{
			System.out.println("i am happy");
		   Cart	c=(Cart)cartDao.get(u.getUser_id());
			  if(c==null)
			  {
				 cart.setc_id("cust70E075");
				 cart.setUser_id(u.getUser_id());
				 System.out.println("I have add to ent");
				 cartDao.saveorupdate(cart);
				 Product p=(Product)productDao.get(product_id);
				 cartitems.setProduct_id(p.getProduct_id());
				 cartitems.setProduct_name(p.getProduct_name());
				 cartitems.setQuantity(1);
				 cartitems.setCart(cart);
				 cartitems.setC_id("cust70E075");
				 cartitems.setUser_id(u.getUser_id());
				 cartitems.setTotal_price(cartitems.getQuantity()*p.getProduct_price());
				 if(cartitemsDao.save(cartitems)==true);
				 {
					 double gt;
					 String g=cart.getGrand_total();
				      double t=cartitems.getTotal_price();
				      if(g==null)
				      {
				    	 gt=0; 
				      }
				      else
				      {
				        gt=Double.parseDouble(g);
				      }
				      gt=gt+t;
					  String gt1=String.valueOf(gt);
					  cart.setGrand_total(gt1);
					  cartDao.saveorupdate(cart);
					  System.out.println("cart is created as well item is add to cartList");
				 }
			    }
			  else
			  {
				  Product p=(Product)productDao.get(product_id);
				  CartItems cit=new CartItems();
				  cit.setProduct_id(p.getProduct_id());
				  cit.setProduct_name(p.getProduct_name());
				  cit.setQuantity(1);
				  cit.setCart(c);
				  cit.setC_id("cust70E075");
				  cit.setUser_id(u.getUser_id());
				  cit.setTotal_price(cit.getQuantity()*p.getProduct_price());	
				  if(cartitemsDao.save(cit)==true)
					 {
					      double gt;
					      String g=c.getGrand_total();
					      double t=cit.getTotal_price();
					      if(g==null)
					      {
					    	 gt=0; 
					      }
					      else
					      {
					        gt=Double.parseDouble(g);
					      }
					     gt=gt+t;
					     String gt1=String.valueOf(gt);
					     c.setGrand_total(gt1);
					     if(cartDao.saveorupdate(c)==true)
					    	 System.out.println("cart is updated");
						 System.out.println("Item is add to cartlist");
					 }
			  }
		}
	}
	 return new ModelAndView("redirect:"+"/");	
//	 return new ModelAndView("viewproduct");
 }
 
 @RequestMapping("/cart")
 public ModelAndView cart(Model model)
 {
	 ModelAndView obj=new ModelAndView("cartitems");
	 System.out.println("h2");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken))
		{
			System.out.println("i am coming");
			String currentUserName= authentication.getName();
			u=(UserDetails)userDetailsDao.getName(currentUserName);
			if(u==null)
			{
				System.out.println("Sorry");
			}
			else
			{
				System.out.println("i have money");
				Cart c=(Cart)cartDao.get(u.getUser_id());
				if(c==null)
				{
					obj.addObject("msg", "U have no cart Items Added");
				}
				else
				{
					obj.addObject("userdetails", c.getCart_id());
				List<CartItems> li=(List<CartItems>)cartitemsDao.get(c.getCart_id());
				if(li==null ||li.isEmpty())
				{
					obj.addObject("msg", "U have no cart Items Added");
				}
				else
				{
					for(CartItems l:li)
					{
						System.out.println(l.getUser_id());
						System.out.println(l.getCartitems_id());
						System.out.println(l.getTotal_price());
						System.out.println(l.getProduct_id());
						System.out.println(l.getProduct_name());
					}
					Cart c1 = (Cart)cartDao.get(u.getUser_id());
					obj.addObject("c1",c1.getGrand_total());
					obj.addObject("l", li);
				}
				}
			}
		}
		return obj;
 }
 

 @RequestMapping("/remove/{cartitems_id}")
 public ModelAndView remove(@PathVariable(value="cartitems_id")String id,Model model)
 { 
	 double g=0.0,h;
	 ModelAndView obj= new ModelAndView("redirect:"+"/cart");
	 System.out.println("m coming");
	 System.out.println(id);
	 cartitems=cartitemsDao.getbyCartItems(id);
	 g=cartitems.getTotal_price();
	 cart=cartDao.get(cartitems.getUser_id());
	 cartitems.setCartitems_id(id);
	 if(cartitemsDao.prodelete(cartitems)==true)
	 {
		 System.out.println("i am happy");
		 String g1=cart.getGrand_total();
		 h=Double.parseDouble(g1);
		 h=h-g;
		 String j=String.valueOf(h);
		 cart.setGrand_total(j);
		 cartDao.saveorupdate(cart);
	 }
	 return obj;
 }
 
 @RequestMapping("/remove2/{userdetails}")
 public ModelAndView remove2(@PathVariable(value="userdetails")String id, Model model)
 { 
	 System.out.println("Remove working");
	 ModelAndView obj=new ModelAndView("redirect:"+"/cart");
	 String uid=null;
	 List<CartItems> l=(List<CartItems>)cartitemsDao.get(id);
	 for(CartItems l2:l)
	 {
		 uid=cartitems.getUser_id();
		 cartitems=l2;
		 cartitemsDao.delete(cartitems);
	 }
	 cart=cartDao.get(uid);
	 cart.setGrand_total("0.0");
	 cartDao.saveorupdate(cart);
	 obj.addObject("msg", "no cart is added");
	 return obj;
 }
		
}
