package com.niit.musicmainee.ProductDaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.musicmainee.Dao.ShippmentaddDao;
import com.niit.musicmainee.entity.Cart;
import com.niit.musicmainee.entity.Shippmentadd;

@Repository("shippmentaddDao")
@EnableTransactionManagement
public class ShippmentaddDaoImpl implements  ShippmentaddDao
{
	@Autowired
	private SessionFactory  sessionFactory;
	
	public ShippmentaddDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public boolean save(Shippmentadd shippmentadd)
	{
		System.out.println("yes");
		try {
			System.out.println("yes");
			sessionFactory.getCurrentSession().save(shippmentadd);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;

		} 
	}
	
	@Transactional
	public boolean update(Shippmentadd shippmentadd)
	{
		System.out.println("yes");
		try {
			System.out.println("yes");
			sessionFactory.getCurrentSession().update(shippmentadd);;
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;

		} 
	}
	
	@Transactional
	public boolean delete(String shippmentadd_id)
    {
    	try {
    		Shippmentadd obj=new Shippmentadd();
			obj.setShippmentadd_id(shippmentadd_id);
			sessionFactory.getCurrentSession().delete(obj);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} 
    }	
	
	@Transactional
	public Shippmentadd get(String shippmentadd_id)
	   {
		   String hql="from Shippmentadd where shippmentadd_id='" + shippmentadd_id+ "'";
		   Query q=sessionFactory.getCurrentSession().createQuery(hql);
		   List<Shippmentadd> l1=(List<Shippmentadd>)q.list();
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
	public List<Shippmentadd> list()
	   {
		   List<Shippmentadd> shippmentadd = (List<Shippmentadd>)sessionFactory.getCurrentSession().createCriteria(Cart.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		   return shippmentadd;
	   }
}
