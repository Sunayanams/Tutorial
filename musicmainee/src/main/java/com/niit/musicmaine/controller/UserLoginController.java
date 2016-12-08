package com.niit.musicmaine.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.musicmainee.Dao.UserDetailsDao;
import com.niit.musicmainee.entity.UserDetails;
@Controller
public class UserLoginController
{
	
	@Autowired
	UserDetailsDao userdetailsDao;
	
	@RequestMapping("/login")
	public String Login(@RequestParam(value="error",required=false) String error,@RequestParam(value="logout",required=false) String logout,Model model)
	{
		if(error!=null)
			model.addAttribute("error","Invalid username and password");
		
		if(logout!=null)
			model.addAttribute("logout","You have logged out successfully");
		return "loginpage";
//		ModelAndView obj=new ModelAndView("loginpage");
//		obj.addObject("chose","");
//		//model.addAttribute("hi", "Hi welcome to my website");
//		System.out.println("login is working");
//		return obj; 
	}
	
	@RequestMapping("/j_spring_security_check")
	public ModelAndView sub(@RequestParam("email")String e,@RequestParam("pwd")String pwd,HttpSession session)
	{
		System.out.println(e+" "+pwd);
		ModelAndView obj=new ModelAndView("redirect:"+"/");
		UserDetails u=(UserDetails)userdetailsDao.isvalidate(e, pwd);
		if(u==null)
		{
		ModelAndView obj1=new ModelAndView("loginpage");
		obj1.addObject("mes","login failed");
		
		session.setAttribute("s", "false");
	       return obj1;  
		}
		else
		{	    
			    session.setAttribute("user", u);
//			    session.getAttribute("user");
			    UserDetails us=(UserDetails)session.getAttribute("user");
//			    session.getAttribute(arg0);
			    session.setAttribute("s","true");
			    if(u.getRole_name()=="ROLE_ADMIN") System.out.println("welcome admin");
		    	if(u.getRole_name()=="ROLE_USER")System.out.println("welcome user");
//		    	if(u.getRole_id()==3)System.out.println("welcome user");
		    	System.out.println("login is working");
		    	return obj; 
		}
		//model.addAttribute("hi", "Hi welcome to my website");
		}
	
	
	@RequestMapping("/logout")
	public String Logout(HttpSession session,HttpServletRequest request)
	{
		String n="/index";
		session.invalidate();
		session=request.getSession(true);
		System.out.println("logout is working");
		return "redirect:/";
	}
}
