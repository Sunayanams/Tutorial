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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.musicmainee.Dao.CartDao;
import com.niit.musicmainee.Dao.CartItemsDao;
import com.niit.musicmainee.Dao.CorderDao;
import com.niit.musicmainee.Dao.ProductDao;
import com.niit.musicmainee.Dao.UserDetailsDao;
import com.niit.musicmainee.entity.Cart;
import com.niit.musicmainee.entity.CartItems;
import com.niit.musicmainee.entity.Corder;
import com.niit.musicmainee.entity.Product;
import com.niit.musicmainee.entity.UserDetails;


@Controller
public class OrderController 
{
	@Autowired
	Corder corder;
	@Autowired
	CorderDao corderDao;
	
	@Autowired
	UserDetailsDao userDetailsDao;
	@Autowired
    UserDetails u;
	
	@Autowired
	ProductDao productDao;
	@Autowired
	Product product;
	
	@Autowired
	Cart cart;
	@Autowired
	CartDao cartDao;
	
	@Autowired
	CartItemsDao cartitemsDao;
	@Autowired
	CartItems cartitems;
	
   
	@RequestMapping("/Shippmentadd")
	public String Buyall(Model model, HttpSession session)throws Exception
	{
		return "shippmentaddress";
	}
	
	@RequestMapping("/Shippmentadd/{product_id}")
	public ModelAndView Shippment(@PathVariable("product_id")String product_id,Model model, HttpSession session)
	{
		System.out.println("i am coming");
	    ModelAndView obj=new ModelAndView("shippmentaddress");
    	product=(Product)productDao.get(product_id);
    	if(product==null)
    	{
    		System.out.println("sorry");
    	}
    	else
    	{
    		System.out.println("product="+product.getProduct_name()+" "+product.getProduct_price()+" "+product.getProduct_quantity()+" "+product.getProduct_description()+" "+product.getCategory()+" "+product.getSupplier()+" "+product.getImg());
    	}
    	session.setAttribute("pro123", product);
    	return obj;
			
	}
	
	@RequestMapping("/billingadd")
	public ModelAndView billing(@RequestParam("ShippmentAddress")String sa)
	{
		ModelAndView obj=new ModelAndView("billingaddress");
		corder.setS_address(sa);
		return obj;
	}
	
	@RequestMapping("/payment")
	public ModelAndView payment(@RequestParam("BillingAddress")String sa)
	{
		ModelAndView obj=new ModelAndView("payment");
		corder.setB_address(sa);
		return obj;
	}
	
	@RequestMapping("/confirmorder")
	public ModelAndView confirmorder(@RequestParam("optradio")String sa,HttpSession s)
	{
		System.out.println("I am coming");
		ModelAndView obj=new ModelAndView("thankyou");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	if (!(authentication instanceof AnonymousAuthenticationToken))
		{
			String currentUserName= authentication.getName();
			u=(UserDetails)userDetailsDao.getName(currentUserName);
			
			if(s.getAttribute("pro123")==null)
			{
				cart=cartDao.get(u.getUser_id());
				List<CartItems> lis=cartitemsDao.get(cart.getCart_id());
				for(CartItems l:lis)
				{
					Corder obs=new Corder();
					obs.setPayment(sa);
					obs.setUser_id(u.getUser_id());
					obs.setTot_price(l.getTotal_price());
					System.out.println(l.getProduct_id());
					obs.setProduct_id(l.getProduct_id());
					obs.setB_address(corder.getB_address());
					obs.setS_address(corder.getS_address());
					System.out.println(l.getProduct_id());
					corderDao.save(obs);
					CartItems caI=l;
					cartitemsDao.delete(caI);
				}
				cart.setGrand_total("0.0");
				cartDao.saveorupdate(cart);
				obj.addObject("l", lis);
			}
			else
			{
				corder.setPayment(sa);
				corder.setUser_id(u.getUser_id());
				corder.setProduct_id(product.getProduct_id());
				corder.setTot_price(product.getProduct_price());
				corder.setCorder_id(corder.getCorder_id());
				if(corderDao.save(corder)==true)
				{
				obj.addObject("l", corder);	
				System.out.println("webflow is complited");
				return obj;
				}
			}
		}
		if(u==null)
		{
			System.out.println("sorry i am not getting user");
		}
		else
		{
		}
		return obj;
	}
	
	@RequestMapping("/cancel")
	public ModelAndView cancel()
	{
		ModelAndView obj=new ModelAndView("redirect:"+"/");
		return obj;
	}

}
