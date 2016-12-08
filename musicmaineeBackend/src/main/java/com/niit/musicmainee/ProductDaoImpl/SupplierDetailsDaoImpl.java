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

import com.niit.musicmainee.Dao.SupplierDetailsDao;
import com.niit.musicmainee.entity.CategoryDetails;
import com.niit.musicmainee.entity.Product;
import com.niit.musicmainee.entity.SupplierDetails;

@Repository("supplierdetailsDao")
@EnableTransactionManagement

public class SupplierDetailsDaoImpl implements SupplierDetailsDao
{
@Autowired
private SessionFactory sessionFactory;

public SupplierDetailsDaoImpl(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
}

@Transactional
public boolean saveorupdate(SupplierDetails supplierdetails)
{
	System.out.println("yes");
	try {
		System.out.println("yes");
		System.out.println(supplierdetails.getSupplier_id());
		System.out.println(supplierdetails.getSupplier_name());
		System.out.println(supplierdetails.getSupplier_address());
		System.out.println(supplierdetails.getSupplier_description());
		sessionFactory.getCurrentSession().saveOrUpdate(supplierdetails);
		return true;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}	
}

@Transactional
public boolean delete(String supplier_id)
{
	try {
		SupplierDetails obj=new SupplierDetails();
		obj.setSupplier_id(supplier_id);
		sessionFactory.getCurrentSession().delete(obj);
		return true;
	}
	catch (Exception e) 
	{
		e.printStackTrace();
		return false;
	}
	
}

@Transactional
public SupplierDetails get(String supplier_id)
{
	   String hql="from SupplierDetails where supplier_id='" +supplier_id+ "'";
	   Query q=sessionFactory.getCurrentSession().createQuery(hql);
	   List<SupplierDetails> l1=(List<SupplierDetails>)q.list();
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
public List<SupplierDetails> list()
{
	   List<SupplierDetails> supplierdetails = (List<SupplierDetails>)sessionFactory.getCurrentSession().createCriteria(SupplierDetails.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	   return supplierdetails;
}

@Transactional
public  void editSupplier(SupplierDetails supplierdetails)
{
	Session session=sessionFactory.getCurrentSession();
	session.update(supplierdetails);
	session.flush();
	session.close();
}
}
