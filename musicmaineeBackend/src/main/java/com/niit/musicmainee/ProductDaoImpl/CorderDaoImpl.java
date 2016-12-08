package com.niit.musicmainee.ProductDaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.musicmainee.Dao.CorderDao;
import com.niit.musicmainee.entity.Corder;

@Repository("corderDao")
@EnableTransactionManagement
public class CorderDaoImpl implements CorderDao
{

	@Autowired
	private SessionFactory  sessionFactory;
	
	public CorderDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public boolean save(Corder corder)
	{
		System.out.println("yes");
		try {
			System.out.println("yes");
			sessionFactory.getCurrentSession().saveOrUpdate(corder);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;

		} 
	}
	
	@Transactional
	public boolean delete(String user_id)
    {
    	try {
			Corder obj=new Corder();
			obj.setUser_id(user_id);
			sessionFactory.getCurrentSession().delete(obj);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} 
    }	
	
	@Transactional
	public Corder get(String  user_id)
	   {
		   String hql="from Corder where  user_id='" + user_id+ "'";
		   Query q=sessionFactory.getCurrentSession().createQuery(hql);
		   List<Corder> l1=(List<Corder>)q.list();
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
	   public List<Corder> list()
	   {
		   List<Corder> corder = (List<Corder>)sessionFactory.getCurrentSession().createCriteria(Corder.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		   return corder;
	   }
	   
}
