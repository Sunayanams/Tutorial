package com.niit.musicmainee.ProductDaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import com.niit.musicmainee.Dao.ProductDao;
import com.niit.musicmainee.entity.CategoryDetails;
import com.niit.musicmainee.entity.Product;
@Repository("productDao")
@EnableTransactionManagement
public class ProductDaoImpl implements ProductDao
{
    @Autowired
    private SessionFactory sessionFactory;
	
	
	
	public ProductDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
    public boolean saveorupdate(Product product)
    {
    	
		System.out.println("yes");
		try {
			System.out.println("yes");
			sessionFactory.getCurrentSession().saveOrUpdate(product);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
	
		} 
    }
	@Transactional
    public boolean delete(String product_id)
    
	{
    	try {
			Product obj=new Product();
			obj.setProduct_id(product_id);
			sessionFactory.getCurrentSession().delete(obj);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} 
    }
    
   @Transactional
   public Product get(String product_id)
   {
	   String hql="from Product where product_id='" +product_id+ "'";
	   Query q=sessionFactory.getCurrentSession().createQuery(hql);
	   List<Product> l1=(List<Product>)q.list();
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
   public List<Product> getbycat(String category_id)
   {
	   String hql="from Product where category_id='" +category_id+ "'";
	   Query q=sessionFactory.getCurrentSession().createQuery(hql);
	   List<Product> l1=(List<Product>)q.list();
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
   public List<Product> list()
   {
	   List<Product> product = (List<Product>)sessionFactory.getCurrentSession().createCriteria(Product.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	   return product;
   }
   
   @Transactional
   public void editProduct(Product product)
   {
   	Session session=sessionFactory.getCurrentSession();
   	session.update(product);
   	session.flush();
   	session.close();
   }

   
   
}
