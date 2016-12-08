package com.niit.musicmainee.ProductDaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.musicmainee.Dao.RoleDao;
import com.niit.musicmainee.entity.Product;
import com.niit.musicmainee.entity.Role;

@Repository("roleDao")
@EnableTransactionManagement

public class RoleDaoImpl implements RoleDao
{
@Autowired
private SessionFactory  sessionFactory;

public RoleDaoImpl(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
}

@Transactional
public boolean save(Role role)
{
	System.out.println("yes");
	try {
		System.out.println("yes");
		sessionFactory.getCurrentSession().save(role);
		return true;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;

	} 
}
	
	@Transactional
    public boolean delete(String role_id)
    {
    	try {
			Role obj=new Role();
			obj.setRole_id(role_id);
			sessionFactory.getCurrentSession().delete(obj);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} 
    }	

	@Transactional
	   public Role get(String role_id)
	   {
		   String hql="from Role where role_id='" +role_id+ "'";
		   Query q=sessionFactory.getCurrentSession().createQuery(hql);
		   List<Role> l1=(List<Role>)q.list();
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
	   public List<Role> list()
	   {
		   List<Role> role = (List<Role>)sessionFactory.getCurrentSession().createCriteria(Role.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		   return role;
	   }
	   
	
}
