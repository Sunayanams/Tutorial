package com.niit.musicmaine.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.musicmainee.Dao.CategoryDetailsDao;
import com.niit.musicmainee.Dao.ProductDao;
import com.niit.musicmainee.Dao.SupplierDetailsDao;
import com.niit.musicmainee.entity.CategoryDetails;
import com.niit.musicmainee.entity.Product;
import com.niit.musicmainee.entity.SupplierDetails;

@Controller
public class HomeController 
{
	@Autowired
	CategoryDetailsDao categorydetailsDao;
	
	@Autowired
	SupplierDetailsDao supplierdetailsDao; 
   
	@Autowired
	Product product;
	
	@Autowired
	ProductDao productDao; 
	
	@RequestMapping("/")
	public ModelAndView index(HttpSession session,Model model)
	{
		System.out.println(1);
		ModelAndView obj1=new ModelAndView("index");
		List<CategoryDetails> lcategorydetails=(List<CategoryDetails>) categorydetailsDao.list();
		List<SupplierDetails> lsupplierdetails=(List<SupplierDetails>) supplierdetailsDao.list();
		  List<Product> list=(List<Product>)productDao.list();
		if(list==null || list.isEmpty())
		{
		   obj1.addObject("msg","no product added");
		}
		else
		{
			obj1.addObject("list",list);
		}
		 if(lcategorydetails==null || lcategorydetails.isEmpty())
			{
			    
				obj1.addObject("mes","retrived failed");
				session.setAttribute("s", "false");
				System.out.println("no data found");
				return obj1;
			}
	     else
	     {
	    	 obj1.addObject("lcategorydetails", lcategorydetails);
	    	 session.setAttribute("lcategorydetails", lcategorydetails);
	    	for(CategoryDetails p:lcategorydetails)
	    	 {
	    		 System.out.println("category details");
	    		 System.out.println(p.getCategory_id());
	    		 System.out.println(p.getCategory_name());
	    		 System.out.println(p.getCategory_description());
	    	 }
	     }
		 if(lsupplierdetails==null || lsupplierdetails.isEmpty())
			{
			    
				obj1.addObject("mes","retrived failed");
				session.setAttribute("s", "false");
				System.out.println("no data found");
				return obj1;
			}
	     else
	     {
	    	 obj1.addObject("lsupplierdetails", lsupplierdetails);
	    	 session.setAttribute("lsupplierdetails", lsupplierdetails);
	    	for(SupplierDetails p:lsupplierdetails)
	    	 {
	    		 System.out.println("supplier details");
	    		 System.out.println(p.getSupplier_id());
	    		 System.out.println(p.getSupplier_name());
	    		 System.out.println(p.getSupplier_address());
	    		 System.out.println(p.getSupplier_description());
	    		 
	    	 }
	     }
		System.out.println(1);
		return obj1; 
	}

}
