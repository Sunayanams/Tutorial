package com.niit.musicmainee.ProductDaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.musicmainee.Dao.CartItemsDao;
import com.niit.musicmainee.entity.CartItems;
import com.niit.musicmainee.entity.Role;

@Repository("cartitemsDao")
@EnableTransactionManagement
public class CartItemsDaoImpl implements CartItemsDao
{

	@Autowired
	private SessionFactory  sessionFactory;

	public CartItemsDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean save(CartItems cartitems)
	{
		System.out.println("yes");
		try {
			System.out.println("yes");
			sessionFactory.getCurrentSession().save(cartitems);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;

		} 
	}
	
//	@Transactional
//	public boolean update(CartItems cartitems)
//	{
//		System.out.println("yes");
//		try {
//			System.out.println("yes");
//			sessionFactory.getCurrentSession().saveOrUpdate(cartitems);
//			return true;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return false;
//
//		} 
//	}
		
		@Transactional
		public boolean delete(CartItems cartitems)
	    {
	    	try {
				
				sessionFactory.getCurrentSession().delete(cartitems);
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			} 
	    }	

		@Transactional
		public boolean prodelete(CartItems cartitems)
		{
			try
			{
			sessionFactory.getCurrentSession().delete(cartitems);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} 
		}
		
		@Transactional
		public  CartItems getbyCartItems(String id)
		   {
			   String hql="from CartItems where cartitems_id='" +id+ "'";
			   Query q=sessionFactory.getCurrentSession().createQuery(hql);
			   List<CartItems> l1=(List<CartItems>)q.list();
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
		public  List<CartItems> get(String cart_id)
		   {
			   String hql="from CartItems where cart_id='" +cart_id+ "'";
			   Query q=sessionFactory.getCurrentSession().createQuery(hql);
			   List<CartItems> l1=(List<CartItems>)q.list();
			   if(l1==null || l1.isEmpty())
			   {
				   return null;
			   }
			   else
			   {
				   return l1;
			   }
		   }
		
		@Transactional
		   public List<CartItems> list()
		   {
			   List<CartItems> cartitems = (List<CartItems>)sessionFactory.getCurrentSession().createCriteria(Role.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			   return cartitems;
		   }
		   
		
}
