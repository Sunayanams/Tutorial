package com.niit.musicmainee.ProductDaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.musicmainee.Dao.BillingaddDao;
import com.niit.musicmainee.entity.Billingadd;
import com.niit.musicmainee.entity.Cart;

@Repository("billingaddDao ")
@EnableTransactionManagement

public class BillingaddDaoImpl implements BillingaddDao
{
	@Autowired
	private SessionFactory  sessionFactory;
	
	public BillingaddDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public boolean save(Billingadd billingadd)
	{
		System.out.println("yes");
		try {
			System.out.println("yes");
			sessionFactory.getCurrentSession().save(billingadd);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;

		} 
	}
	
	@Transactional
	public boolean update(Billingadd billingadd)
	{
		System.out.println("yes");
		try {
			System.out.println("yes");
			sessionFactory.getCurrentSession().update(billingadd);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;

		} 
	}
	
	@Transactional
	public boolean delete(String billingadd_id)
    {
    	try {
    		Billingadd obj=new Billingadd();
			obj.setBillingadd_id(billingadd_id);
			sessionFactory.getCurrentSession().delete(obj);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} 
    }	
	
	@Transactional
	public Billingadd get(String billingadd_id)
	   {
		   String hql="from Billingadd where billingadd_id='" + billingadd_id+ "'";
		   Query q=sessionFactory.getCurrentSession().createQuery(hql);
		   List<Billingadd> l1=(List<Billingadd>)q.list();
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
	public List<Billingadd> list()
	   {
		   List<Billingadd> billingadd = (List<Billingadd>)sessionFactory.getCurrentSession().createCriteria(Cart.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		   return billingadd;
	   }
}
