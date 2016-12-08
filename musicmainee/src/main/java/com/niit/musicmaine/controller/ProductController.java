package com.niit.musicmaine.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.musicmainee.Dao.CategoryDetailsDao;
import com.niit.musicmainee.Dao.ProductDao;
import com.niit.musicmainee.Dao.SupplierDetailsDao;
import com.niit.musicmainee.entity.CategoryDetails;
import com.niit.musicmainee.entity.Product;
import com.niit.musicmainee.entity.SupplierDetails;
import com.niit.musicmainee.fileinput.Imageupload;

@Controller

public class ProductController
{
	@Autowired
	Product product;
	@Autowired
	ProductDao productDao;
	
	@Autowired
	CategoryDetailsDao categorydetailsDao;
	@Autowired
	CategoryDetails categorydetails;
	
	@Autowired
	SupplierDetailsDao supplierdetailsDao; 
	@Autowired 
	SupplierDetails supplierdetails;
	
	String path="C:\\Users\\Sony\\workspace\\musicmainee\\src\\main\\webapp\\WEB-INF\\resources\\img\\"; 
	int f=0;
	@RequestMapping(value="/addproduct")
	public ModelAndView product(Model model,HttpSession session)
	{
		List<CategoryDetails> lcategorydetails=(List<CategoryDetails>) categorydetailsDao.list();
		List<SupplierDetails> lsupplierdetails=(List<SupplierDetails>) supplierdetailsDao.list();
		System.out.println(1);
		ModelAndView obj=new ModelAndView("product");
		product.setCategory(categorydetails);
		product.setSupplier(supplierdetails);
		obj.addObject("pro", product);
		obj.addObject("lsupplierdetails", lsupplierdetails);
		obj.addObject("lcategorydetails", lcategorydetails);
		
		Product p1=(Product)session.getAttribute("pro1");
		if(p1==null)
		{
			System.out.println("invalid sorry");
		}
		else
		{
			if(f==1)
			{
				obj.addObject("name", p1.getProduct_name());
				obj.addObject("price", p1.getProduct_price());
				obj.addObject("quantity", p1.getProduct_quantity());
				obj.addObject("des", p1.getProduct_description());	
			}
			else
			{
				obj.addObject("name", " ");
				obj.addObject("price", " ");
				obj.addObject("quantity", " ");
				obj.addObject("des", " ");	
			}
			
			
		}
		List<Product> list=(List<Product>) productDao.list();
		if(list==null || list.isEmpty())
		{
			System.out.println("list is empty");
		}
		else
		{
			for(Product l:list)
			{
				System.out.println(l.getProduct_name());
				System.out.println(l.getProduct_price());
				System.out.println(l.getProduct_quantity());
				System.out.println(l.getProduct_description());
				System.out.println(l.getImage());
			}
		}
		obj.addObject("addpro", list);
		System.out.println("product is working");
		return obj; 
	}
	
	
	@RequestMapping(value="/Product",method =RequestMethod.POST)
	public ModelAndView productadd(@ModelAttribute("pro")Product product,HttpSession s)
	{
		System.out.println("1");
		System.out.println("file=");
		product.getProduct_id();
		product.getProduct_name();
		product.getProduct_price();
		product.getProduct_quantity();
		product.getProduct_description();
		product.getCategory();
		product.getSupplier();
		ModelAndView obj=new ModelAndView("redirect:"+"/addproduct");
		Product pa=(Product)s.getAttribute("pro1");
		if(pa==null)
		{
		if(productDao.saveorupdate(product)==true)
		{
			Imageupload.upload(path,product.getImg(),product.getProduct_id()+".jpg");
			product.setImage(product.getProduct_id()+".jpg");
			productDao.saveorupdate(product);
			ModelAndView obj1=new ModelAndView("redirect:"+"/addproduct");
			System.out.println("save and update is working");
		    return obj1;	
		}
		else
		{
			System.out.println("sorry");
			return new ModelAndView("addproduct");
		}
		}
		else
		{
			product.setProduct_id(pa.getProduct_id());
		
		if(productDao.saveorupdate(product)==true)
		{
			f--;
			System.out.println("Edit is working");
		    return obj;	
		}
		else
		{
			System.out.println("sorry");
			return new ModelAndView("addproduct");
		}
		}
	}

	@RequestMapping(value="pdelete/{product_id}")
	public String delete(@PathVariable(value="product_id")String product_id) throws Exception
	{
		System.out.println("b delete");
		productDao.delete(product_id);
		System.out.println("A delete");
		return "redirect:/addproduct";
	}
	
	
	@RequestMapping("/pedit/{product_id}")
	public String pedit(@PathVariable("product_id")String product_id, ModelMap model, HttpSession session)
			throws Exception
			{
		     f++;
		     Product p=(Product)productDao.get(product_id);
		     if(p==null)
		     {
		    	 System.out.println("sorry");
		     }
		     else
		     {
		    	 System.out.println("pro ="+p.getProduct_name()+" "+p.getProduct_price()+" "+p.getProduct_quantity()+" "+p.getProduct_description()+" "+p.getCategory()+" "+p.getSupplier());
		     }
		     session.setAttribute("pro1", p);
		     model.addAttribute("edit", product);
		     model.addAttribute("pro", this.productDao.list());
		     return "redirect:/addproduct";
			}
	
	@RequestMapping("/View/{product_id}")
	public ModelAndView pview(@PathVariable("product_id")String product_id,Model model,HttpSession session)
	{
		System.out.println(1);
		System.out.println(product_id);
		Product p1=(Product)productDao.get(product_id);
	     if(p1==null)
	     {
	    	 System.out.println("sorry");
	     }
	     else
	     {
	    	 System.out.println("pro ="+p1.getProduct_name()+" "+p1.getProduct_price()+" "+p1.getProduct_quantity()+" "+p1.getProduct_description()+" "+p1.getCategory()+" "+p1.getSupplier()+" "+p1.getImage());
	     }
	     session.setAttribute("pro1", p1);
	     model.addAttribute("view", product);
	     model.addAttribute("pro", this.productDao.list());
		 return new ModelAndView("viewproduct");
	}
}
	
	
