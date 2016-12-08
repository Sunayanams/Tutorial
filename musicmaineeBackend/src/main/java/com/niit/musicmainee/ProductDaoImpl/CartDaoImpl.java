package com.niit.musicmainee.ProductDaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.musicmainee.Dao.CartDao;
import com.niit.musicmainee.Dao.RoleDao;
import com.niit.musicmainee.entity.Cart;
import com.niit.musicmainee.entity.Role;
@Repository("cartDao")
@EnableTransactionManagement
public class CartDaoImpl implements CartDao
{
	
	@Autowired
	private SessionFactory  sessionFactory;

	public CartDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean saveorupdate(Cart cart)
	{
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(cart);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;

		} 
	}
	
//	@Transactional
//	public boolean update(Cart cart)
//	{
//		try {
//			sessionFactory.getCurrentSession().saveOrUpdate(cart);
//			return true;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return false;
//
//		} 
//	}
	
		
		@Transactional
		public boolean delete(String cart_id)
	    {
	    	try {
				Cart obj=new Cart();
				obj.setCart_id(cart_id);
				sessionFactory.getCurrentSession().delete(obj);
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			} 
	    }	

		@Transactional
		public Cart get(String  user_id)
		   {
			   String hql="from Cart where  user_id='" + user_id+ "'";
			   Query q=sessionFactory.getCurrentSession().createQuery(hql);
			   List<Cart> l1=(List<Cart>)q.list();
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
		   public List<Cart> list()
		   {
			   List<Cart> cart = (List<Cart>)sessionFactory.getCurrentSession().createCriteria(Cart.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			   return cart;
		   }
		   
		
	}
