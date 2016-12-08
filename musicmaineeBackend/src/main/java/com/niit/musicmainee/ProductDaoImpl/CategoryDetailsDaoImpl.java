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

import com.niit.musicmainee.Dao.CategoryDetailsDao;
import com.niit.musicmainee.entity.CategoryDetails;
import com.niit.musicmainee.entity.SupplierDetails;

@Repository("categorydetailsDao")
@EnableTransactionManagement
public class CategoryDetailsDaoImpl implements CategoryDetailsDao {
	@Autowired
	private SessionFactory sessionFactory;

	public CategoryDetailsDaoImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean saveorupdate(CategoryDetails categorydetails)
	{

		System.out.println("yes");
		try {
			System.out.println("yes");
			sessionFactory.getCurrentSession().saveOrUpdate(categorydetails);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	@Transactional
	public boolean update(CategoryDetails categorydetails)
	{

		System.out.println("yes");
		try {
			System.out.println("yes");
			sessionFactory.getCurrentSession().update(categorydetails);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	@Transactional
	public boolean delete(String category_id)
	{
		try {
			CategoryDetails obj=new CategoryDetails();
			obj.setCategory_id(category_id);
			sessionFactory.getCurrentSession().delete(obj);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
@Transactional
public CategoryDetails get(String category_id)
{
	String hql="from CategoryDetails where category_id='" +category_id+ "'";
	 Query q=sessionFactory.getCurrentSession().createQuery(hql);
	 List<CategoryDetails> l1=(List<CategoryDetails>)q.list();
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
public List<CategoryDetails> list()
{
	   List<CategoryDetails> categorydetails = (List<CategoryDetails>)sessionFactory.getCurrentSession().createCriteria(CategoryDetails.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	   return categorydetails;
}


}
