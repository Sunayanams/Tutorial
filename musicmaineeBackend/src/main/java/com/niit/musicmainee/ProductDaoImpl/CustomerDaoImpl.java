package com.niit.musicmainee.ProductDaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.musicmainee.Dao.CustomerDao;
import com.niit.musicmainee.entity.Cart;
import com.niit.musicmainee.entity.Customer;

@Repository("customerDao")
@EnableTransactionManagement
public class CustomerDaoImpl implements CustomerDao
{
	@Autowired
	private SessionFactory  sessionFactory;
	
	public CustomerDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public boolean save(Customer customer)
	{
		System.out.println("yes");
		try {
			System.out.println("yes");
			sessionFactory.getCurrentSession().save(customer);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;

		} 
	}
	
	@Transactional
	public boolean update(Customer customer)
	{
		System.out.println("yes");
		try {
			System.out.println("yes");
			sessionFactory.getCurrentSession().update(customer);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;

		} 
	}
	
	@Transactional
	public boolean delete(String c_id)
    {
    	try {
    		Customer obj=new Customer();
			obj.setC_id(c_id);
			sessionFactory.getCurrentSession().delete(obj);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} 
    }	
	
	@Transactional
	public Customer get(String user_id)
	   {
		   String hql="from Customer where  user_id='" +user_id+ "'";
		   Query q=sessionFactory.getCurrentSession().createQuery(hql);
		   List<Customer> l1=(List<Customer>)q.list();
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
	public List<Customer> list()
	   {
		   List<Customer> customer = (List<Customer>)sessionFactory.getCurrentSession().createCriteria(Cart.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		   return customer;
	   }
}
