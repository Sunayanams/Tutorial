package com.niit.musicmaine.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.musicmainee.Dao.RoleDao;
import com.niit.musicmainee.Dao.UserDetailsDao;
import com.niit.musicmainee.entity.Role;
import com.niit.musicmainee.entity.UserDetails;
@Controller
public class SignUpController 
{ 
	
	@Autowired
	UserDetailsDao userdetailsDao;
	
	@Autowired
	UserDetails userdetails;
	
	@Autowired
	Role role;
	
	@Autowired
	RoleDao roleDao;
	
	@RequestMapping(value="/signup" )
	public ModelAndView Signup(Model model)
	{
		System.out.println(1);
		ModelAndView obj=new ModelAndView("signup");
		obj.addObject("chose","jfdjfjfjfj");
		obj.addObject("user",userdetails);
		System.out.println("signup is working");
		return obj; 
	}
	
	
	@RequestMapping(value="/Submit",method =RequestMethod.POST)
	public ModelAndView register(@ModelAttribute("user")UserDetails userdetails,@RequestParam("pwd2")String a,@RequestParam("user_name")String p,@RequestParam("dateofbirth")String d)
	{
		System.out.println(d);
		System.out.println(100);
		if(userdetails.getPassword().equals(a))
		{
//			u.setUser_name(p);
			//u.setUser_dob(q);
			ModelAndView obj=new ModelAndView("index");
			System.out.println("*****************************");
			System.out.println(userdetails.getUser_name());
			System.out.println(userdetails.getUser_id());
			System.out.println(userdetails.getEmail_id());
			System.out.println(userdetails.getPassword());
			System.out.println(userdetails.getUser_address());
			
//			System.out.println(q);
//			System.out.println(d);
			System.out.println(userdetails.getGender());
			System.out.println(userdetails.getUser_phoneno());
			
			userdetails.setUser_dob(d);
			System.out.println(userdetails.getUser_dob());
			System.out.println("****************************");
			if(userdetailsDao.save(userdetails)==true)
				{ 
				role.setUser_name(userdetails.getEmail_id());
			    if(roleDao.save(role)==true)
			    {
					System.out.println("save and update is working");
				    return obj;
				}
			    return obj;
				}
			else
			{
				System.out.println("sorry");
				return new ModelAndView("signup"); 
			}
		 }
			else
			{
				ModelAndView obj=new ModelAndView("signup");
				System.out.println(200);
				obj.addObject("password", "password is wrong");
				return obj;		
				
			}
	}
}
