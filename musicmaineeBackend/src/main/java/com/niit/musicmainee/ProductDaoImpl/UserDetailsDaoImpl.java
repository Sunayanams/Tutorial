package com.niit.musicmainee.ProductDaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.musicmainee.Dao.UserDetailsDao;
import com.niit.musicmainee.entity.CategoryDetails;
import com.niit.musicmainee.entity.UserDetails;

@Repository("userdetailsDao")
@EnableTransactionManagement
public class UserDetailsDaoImpl implements UserDetailsDao 
{
   @Autowired
   private SessionFactory sessionFactory;

   public UserDetailsDaoImpl(SessionFactory sessionfactory)
   {
	   this.sessionFactory = sessionfactory;
   }
  
    @Transactional
    public boolean save(UserDetails userdetails)
    {
    	try {
			System.out.println("yes");
			System.out.println(userdetails.getUser_name());
			System.out.println(userdetails.getUser_id());
			System.out.println(userdetails.getEmail_id());
			System.out.println(userdetails.getPassword());
			System.out.println(userdetails.getUser_address());
			System.out.println(userdetails.getGender());
			System.out.println(userdetails.getUser_phoneno());
			System.out.println(userdetails.getUser_dob());
			sessionFactory.getCurrentSession().saveOrUpdate(userdetails);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
    }
    
//    @Transactional
//    public boolean update(UserDetails userdetails)
//    {
//    	try {
//			System.out.println("yes");
//			System.out.println(userdetails.getUser_name());
//			System.out.println(userdetails.getUser_id());
//			System.out.println(userdetails.getEmail_id());
//			System.out.println(userdetails.getPassword());
//			System.out.println(userdetails.getUser_address());
//			System.out.println(userdetails.getGender());
//			System.out.println(userdetails.getUser_phoneno());
//			System.out.println(userdetails.getUser_dob());
//			sessionFactory.getCurrentSession().saveOrUpdate(userdetails);
//			return true;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return false;
//		}
//    }
    @Transactional
    public boolean delete(String id)
    {
    	try {
			UserDetails obj=new UserDetails();
			obj.setUser_id(id);
			sessionFactory.getCurrentSession().delete(obj);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
    }
    @Transactional
    public UserDetails getName(String E_id)
    {
     String hql="from UserDetails where email_id='" +E_id+ "'";
   	 Query q=sessionFactory.getCurrentSession().createQuery(hql);
   	 List<UserDetails> l1=(List<UserDetails>)q.list();
   	 if(l1==null || l1.isEmpty())
   	   {
   		   return null;
   	   }
   	   else
   	   {
   		   return l1.get(0);
   	   }
    }
    
    
    
    @Transactional
    public UserDetails get(String user_id)
    {
    	String hql="from UserDetails where user_id='" +user_id+ "'";
    	 Query q=sessionFactory.getCurrentSession().createQuery(hql);
    	 List<UserDetails> l1=(List<UserDetails>)q.list();
    	 if(l1==null || l1.isEmpty())
    	   {
    		   return null;
    	   }
    	   else
    	   {
    		   return l1.get(0);
    	   }
    }
    
    @Transactional
    public List<UserDetails> list()
    {
    	List<UserDetails> userdetails = (List<UserDetails>)sessionFactory.getCurrentSession().createCriteria(UserDetails.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
 	   return userdetails;
    }
    
    @Transactional
    public UserDetails isvalidate(String email_id,String password)
    {
    	String hql="from UserDetails where email_id='" +email_id + "' and password='" +password+ "'";
    	Query q=sessionFactory.getCurrentSession().createQuery(hql);
    	 List<UserDetails> l1=(List<UserDetails>)q.list();
    	 if(l1==null || l1.isEmpty())
  	   {
  		   return null;
  	   }
  	   else
  	   {
  		   return l1.get(0);
  	   }
    }

}
