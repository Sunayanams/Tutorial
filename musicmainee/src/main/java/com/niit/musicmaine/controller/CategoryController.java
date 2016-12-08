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
import org.springframework.web.servlet.ModelAndView;

import com.niit.musicmainee.Dao.CategoryDetailsDao;
import com.niit.musicmainee.Dao.ProductDao;
import com.niit.musicmainee.entity.CategoryDetails;
import com.niit.musicmainee.entity.Product;

@Controller
public class CategoryController {

	@Autowired
	CategoryDetails categorydetails;

	@Autowired
	CategoryDetailsDao categorydetailsDao;

	public CategoryDetails getCategorydetails() {
		return categorydetails;
	}

	public void setCategorydetails(CategoryDetails categorydetails) {
		this.categorydetails = categorydetails;
	}

	public CategoryDetailsDao getCategorydetailsDao() {
		return categorydetailsDao;
	}

	public void setCategorydetailsDao(CategoryDetailsDao categorydetailsDao) {
		this.categorydetailsDao = categorydetailsDao;
	}

	@Autowired
	Product product;

	@Autowired
	ProductDao productDao;
	
	int f=0;

	@RequestMapping(value = "/addcategory")
	public ModelAndView Login(Model model,HttpSession session) {
		System.out.println(1);
		ModelAndView obj = new ModelAndView("category");
		obj.addObject("cat", categorydetails);
   	    CategoryDetails c1 = (CategoryDetails) session.getAttribute("cat1");
   	    if(c1==null)
   	    {
   	    	System.out.println("sorry");
   	    }
   	    else
   	    {
   	    	if(f==1)
   	    	{
   	      	obj.addObject("name", c1.getCategory_name());
   	      	obj.addObject("des", c1.getCategory_description());
   	    	}
   	    	else
   	    	{
   	    		obj.addObject("name"," ");
   	   	      	obj.addObject("des"," ");
   	      	    		
   	    	}
   	    }
 
   	    List<CategoryDetails> list = (List<CategoryDetails>) categorydetailsDao.list();
		if (list == null || list.isEmpty()) {
			System.out.println("list is empty");
		} else {
			for (CategoryDetails l : list) {
				// System.out.println(l.getCategory_id());
				System.out.println(l.getCategory_name());
				System.out.println(l.getCategory_description());
			}
		}
		obj.addObject("add", list);
		System.out.println("category is working");
		return obj;

	}

	@RequestMapping(value = "/Reg", method = RequestMethod.POST)
	public ModelAndView reg(@ModelAttribute("cat")CategoryDetails categorydetails,HttpSession s)
	{
		System.out.println(2);
		ModelAndView obj=new ModelAndView("redirect:"+"/addcategory");
        CategoryDetails ca = (CategoryDetails) s.getAttribute("cat1");
		 if(ca==null)
		 {
			 if(categorydetailsDao.saveorupdate(categorydetails) == true)
              {
				System.out.println("save and update is working");
				 return obj;
			} 
			else 
			{
				System.out.println("sorry");
				return new ModelAndView("addcategory");
			} 

		 }
		 else
		 {
			 categorydetails.setCategory_id(ca.getCategory_id());
			 if(categorydetailsDao.saveorupdate(categorydetails) == true)
             {
				 f--;
				System.out.println("Edit is working");
				 return obj;
			} 
			else 
			{
				System.out.println("sorry");
				return new ModelAndView("addcategory");
			}
			 
		 }
	 } 

               
		
	@RequestMapping(value = "/cat/{category_id}", method = RequestMethod.GET)
	public ModelAndView getproductBycat(@PathVariable("category_id") String id) {
		List<Product> list2 = null;
		ModelAndView obj = new ModelAndView("index");
		System.out.println("id is mapped: " + id);
		System.out.println("hi");
		list2 = (List<Product>) productDao.getbycat(id);
		categorydetails.setPro(list2);
		List<Product> list = categorydetails.getPro();
		for (Product p : list) {
			System.out.println("Product Name" + p.getProduct_name());
		}
		obj.addObject("list", list2);
		return obj;
	}

	@RequestMapping(value = "cdelete/{category_id}")
	public String delete(@PathVariable(value = "category_id") String category_id) {
		System.out.println("b delete");
		categorydetailsDao.delete(category_id);
		System.out.println("A delete");
		return "redirect:/addcategory";
	}


	@RequestMapping("/cedit/{category_id}")
	public String cedit(@PathVariable("category_id") String category_id, ModelMap model, HttpSession session)
			throws Exception {
		f++;
		CategoryDetails c = (CategoryDetails) categorydetailsDao.get(category_id);
		//CategoryDetails ch = (CategoryDetails) categorydetailsDao.get(category_id);
		if(c==null)
		{
			System.out.println("sorry");
		}
		else
		{
			System.out.println(" cat ="+c.getCategory_name()+" "+c.getCategory_id());
		}
		session.setAttribute("cat1",c);
		model.addAttribute("edit", categorydetails);
		model.addAttribute("cat", this.categorydetailsDao.list());
		return "redirect:/addcategory";

	}

}
