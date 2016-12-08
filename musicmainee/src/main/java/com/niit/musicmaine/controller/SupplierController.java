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
import org.springframework.web.servlet.ModelAndView;

import com.niit.musicmainee.Dao.SupplierDetailsDao;
import com.niit.musicmainee.entity.SupplierDetails;

@Controller

public class SupplierController 
{
	@Autowired 
	SupplierDetails supplierdetails;
	
	@Autowired
	SupplierDetailsDao supplierdetailsDao;
	
	int f=0;
	@RequestMapping(value="/addsupplier")
	public ModelAndView Login(Model model,HttpSession session)
	{
		System.out.println(1);
		ModelAndView obj=new ModelAndView("supplier");
		obj.addObject("sup",supplierdetails);
		SupplierDetails s1=(SupplierDetails) session.getAttribute("sup1");
		if(s1==null)
		{
			System.out.println("invalis sorry");
		}
		else
		{
			if(f==1)
			{
				obj.addObject("name", s1.getSupplier_name());
				obj.addObject("des", s1.getSupplier_description());
				obj.addObject("add", s1.getSupplier_address());
			}
			else
			{
				obj.addObject("name", " ");
				obj.addObject("des", " ");
				obj.addObject("add", " ");
			}
			
		}
		
		List<SupplierDetails> list=(List<SupplierDetails>)supplierdetailsDao.list();
		if(list==null || list.isEmpty())
		{
			System.out.println("list is empty");
		}
		else
		{
			for(SupplierDetails l:list)
			{
				System.out.println(l.getSupplier_name());
				System.out.println(l.getSupplier_address());
				System.out.println(l.getSupplier_description());
			}
		}
		obj.addObject("addsup",list);
		System.out.println("supplier is working");
		return obj; 
	}
	
	@RequestMapping(value="/Supplier",method =RequestMethod.POST)
	public ModelAndView supplier(@ModelAttribute("sup")SupplierDetails supplierdetails,@RequestParam("supplier_address")String add,HttpSession s)
	{
		System.out.println(2);
		System.out.println(add);
		supplierdetails.setSupplier_address(add);
		supplierdetails.getSupplier_id();
		supplierdetails.getSupplier_name();
		supplierdetails.getSupplier_address();
		supplierdetails.getSupplier_description();
		ModelAndView obj=new ModelAndView("redirect:"+"/addsupplier");
		SupplierDetails sa=(SupplierDetails) s.getAttribute("sup1");
		if(sa==null)
		{	
		if(supplierdetailsDao.saveorupdate(supplierdetails)==true)
		{
			System.out.println("save and update is working");
		    return obj;	
		}
		else
		{
			System.out.println("sorry");
			return new ModelAndView("addsupplier");
		}
		}
		else
		{
			supplierdetails.setSupplier_id(sa.getSupplier_id());
			if(supplierdetailsDao.saveorupdate(supplierdetails)==true)
			{
				f--;
				System.out.println("Edit is working");
			    return obj;	
			}
			else
			{
				System.out.println("sorry");
				return new ModelAndView("addsupplier");
			}
		}
	}
	
	
	@RequestMapping(value="sdelete/{supplier_id}")
	public String delete(@PathVariable(value="supplier_id")String supplier_id)
	{
		System.out.println("b delete");
		supplierdetailsDao.delete(supplier_id);
		System.out.println("A delete");
		return "redirect:/addsupplier";
	}
	

	@RequestMapping("/sedit/{supplier_id}")
	public String sedit(@PathVariable("supplier_id")String supplier_id, ModelMap model, HttpSession session)
	throws Exception
	{
		f++;
		SupplierDetails s=(SupplierDetails)supplierdetailsDao.get(supplier_id);
		if(s==null)
		{
			System.out.println("sorry");
		}
		else
		{
			System.out.println("sup ="+s.getSupplier_name()+" "+s.getSupplier_description());
		}
	     session.setAttribute("sup1", s);
	     model.addAttribute("edit", supplierdetails);
	     model.addAttribute("sup", this.supplierdetailsDao.list());
	     return "redirect:/addsupplier";
	}
}


