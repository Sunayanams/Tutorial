package com.niit.musicmainee;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.musicmainee.Dao.RoleDao;
import com.niit.musicmainee.Dao.UserDetailsDao;
import com.niit.musicmainee.entity.CategoryDetails;
import com.niit.musicmainee.entity.Role;
import com.niit.musicmainee.entity.UserDetails;

public class UserDetailsTest 
{
  public static void main(String a[])
  {
	  AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	  context.scan("com.niit.*");
	  context.refresh();
	  
	  UserDetailsDao userdetailsDao =(UserDetailsDao)context.getBean("userdetailsDao");
	  UserDetails  userdetails=(UserDetails)context.getBean("userDetails");
	  RoleDao roleDao=(RoleDao)context.getBean("roleDao");
	  Role role=(Role)context.getBean("role");
	  
	  System.out.println(1);
	  
//	  userdetails.setUser_id("hgf345");
	  userdetails.setUser_name("john");
	  userdetails.setUser_address("gcfk");
	  userdetails.setUser_dob("12/03/1992");
	  userdetails.setUser_phoneno("1234567898");
	  userdetails.setRole_name("ROLE_USER");
	  userdetails.setGender("male");
	  userdetails.setEmail_id("jdnsajdsj@gmail.com");
	  userdetails.setPassword("sasa");
	  System.out.println(2);
	  
	 
	  if(userdetailsDao.save(userdetails)==true)
		{
		    role.setUser_name(userdetails.getEmail_id());
		    role.setRole_name("ROLE_USER");
		    role.setEnabled(true);
		    if(roleDao.save(role)==true)
		    {
			System.out.println(3);
			System.out.println("saved");
		    }
		}
	   else
		{
			System.out.println(4);
			System.out.println("sorry");
		}
	  
//	  if(userdetailsDao.delete("hgf345")==true)
//		   {
//			   System.out.println("done");
//		
//		   }
//		   else
//		   {
//			   System.out.println("sorry");
//		   }
//	  
	  UserDetails l1= (UserDetails)userdetailsDao.get("hgf345");
	     if(l1==null)
	     {
	    	 System.out.println("there is no record found");
	     }
	     else
	     {
	    	 System.out.println("record found");
	     }
	     
	     
	     List<UserDetails> luserdetails=(List<UserDetails>) userdetailsDao.list();
	     if(luserdetails==null || luserdetails.isEmpty())
			{
				System.out.println("no data found");
			}
	     else
	     {
	    	 for(UserDetails p:luserdetails)
	    	 {
	    		 System.out.println(p.getUser_id());
	    		 System.out.println(p.getUser_name());
	    		 System.out.println(p.getUser_address());
	    		 System.out.println(p.getUser_dob());
	    		 System.out.println(p.getUser_phoneno());
	    	     System.out.println("admin");
	    		 System.out.println(p.getGender());
	    		 System.out.println(p.getEmail_id());
	    		 System.out.println(p.getPassword());
	    		 
	    	 }
	     }
	     
	     
	     UserDetails l=(UserDetails)userdetailsDao.isvalidate("jdnsajdsj@gmail.com", "sasa");
	     if(l==null)
	     {
	    	 System.out.println("user is not found");
	     }
	     else
	     {
	    	if(l.getRole_name()=="ROLE_ADMIN") System.out.println("welcome admin");
	    	if(l.getRole_name()=="ROLE_USER")System.out.println("welcome user");
//	    	if(l.getRole_id()==3)System.out.println("welcome user");
	     }
  }
}
