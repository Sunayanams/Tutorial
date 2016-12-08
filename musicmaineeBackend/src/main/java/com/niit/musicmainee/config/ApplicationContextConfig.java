package com.niit.musicmainee.config;


import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.niit.musicmainee.entity.Product;
import com.niit.musicmainee.entity.Role;
import com.niit.musicmainee.entity.Shippmentadd;
import com.niit.musicmainee.entity.SupplierDetails;
import com.niit.musicmainee.entity.Billingadd;
import com.niit.musicmainee.entity.Cart;
import com.niit.musicmainee.entity.CartItems;
import com.niit.musicmainee.entity.CategoryDetails;
import com.niit.musicmainee.entity.Corder;
import com.niit.musicmainee.entity.Customer;
import com.niit.musicmainee.entity.UserDetails;
import com.niit.musicmainee.Dao.BillingaddDao;
import com.niit.musicmainee.Dao.CartDao;
import com.niit.musicmainee.Dao.CartItemsDao;
import com.niit.musicmainee.Dao.CategoryDetailsDao;
import com.niit.musicmainee.Dao.CorderDao;
import com.niit.musicmainee.Dao.CustomerDao;
import com.niit.musicmainee.Dao.ProductDao;
import com.niit.musicmainee.Dao.RoleDao;
import com.niit.musicmainee.Dao.ShippmentaddDao;
import com.niit.musicmainee.Dao.SupplierDetailsDao;
import com.niit.musicmainee.Dao.UserDetailsDao;
import com.niit.musicmainee.ProductDaoImpl.BillingaddDaoImpl;
import com.niit.musicmainee.ProductDaoImpl.CartDaoImpl;
import com.niit.musicmainee.ProductDaoImpl.CartItemsDaoImpl;
import com.niit.musicmainee.ProductDaoImpl.CategoryDetailsDaoImpl;
import com.niit.musicmainee.ProductDaoImpl.CorderDaoImpl;
import com.niit.musicmainee.ProductDaoImpl.CustomerDaoImpl;
import com.niit.musicmainee.ProductDaoImpl.ProductDaoImpl;
import com.niit.musicmainee.ProductDaoImpl.RoleDaoImpl;
import com.niit.musicmainee.ProductDaoImpl.ShippmentaddDaoImpl;
import com.niit.musicmainee.ProductDaoImpl.SupplierDetailsDaoImpl;
import com.niit.musicmainee.ProductDaoImpl.UserDetailsDaoImpl;


@Configuration
@ComponentScan("com.niit.*")
@EnableTransactionManagement
public class ApplicationContextConfig {
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");
		Properties connectionproperties = new Properties();
		connectionproperties.setProperty("hibernate.connection.pool_size","10");
		connectionproperties.setProperty("hibernate.hbm2ddl.auto","update");
		connectionproperties.setProperty("hibernate.show_sql","true");
		connectionproperties.setProperty("hibernate.dialect","org.hibernate.dialect");
		return dataSource;
	}
		
	private Properties getHibernateProperties(){
		Properties properties = new Properties();
	    properties.put("hibernate.show_sql","true");
	    properties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
	    
	    return properties;
	}

	@Autowired 
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(CategoryDetails.class);
		sessionBuilder.addAnnotatedClass(SupplierDetails.class);
		sessionBuilder.addAnnotatedClass(UserDetails.class);
		sessionBuilder.addAnnotatedClass(Role.class);
		sessionBuilder.addAnnotatedClass(Cart.class);
		sessionBuilder.addAnnotatedClass(CartItems.class);
		sessionBuilder.addAnnotatedClass(Customer.class);
		sessionBuilder.addAnnotatedClass(Billingadd.class);
		sessionBuilder.addAnnotatedClass(Shippmentadd.class);
		sessionBuilder.addAnnotatedClass(Corder.class);
		return sessionBuilder.buildSessionFactory();
		
	}
	  
	@Autowired
	@Bean(name = "transcationManager")
	public HibernateTransactionManager getTranscationManager(SessionFactory sessionFactory){
		HibernateTransactionManager transcationManager = new HibernateTransactionManager(sessionFactory);
		return transcationManager;
	}
	
	@Autowired
	@Bean(name = "productDao")
	public ProductDao Product(SessionFactory sessionFactory){
		return new ProductDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name = "categorydetailsDao")
	public CategoryDetailsDao CategoryDetails(SessionFactory sessionFactory){
		return new CategoryDetailsDaoImpl (sessionFactory);
	}
	
	@Autowired
	@Bean(name = "supplierdetailsDao")
	public SupplierDetailsDao SupplierDetails(SessionFactory sessionFactory){
		return new  SupplierDetailsDaoImpl (sessionFactory);
	}
	
	@Autowired
	@Bean(name = "userdetailsDao")
	public UserDetailsDao  UserDetails(SessionFactory sessionFactory){
		return new   UserDetailsDaoImpl (sessionFactory);
	}
	
	@Autowired
	@Bean(name ="roleDao")
	public RoleDao  Role(SessionFactory sessionFactory){
		return new   RoleDaoImpl (sessionFactory);
	}
	
	@Autowired
	@Bean(name ="cartDao")
	public CartDao  Cart(SessionFactory sessionFactory){
		return new   CartDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name ="cartitemsDao")
	public CartItemsDao  CartItems(SessionFactory sessionFactory){
		return new   CartItemsDaoImpl (sessionFactory);
	}
	
	@Autowired
	@Bean(name ="customerDao")
	public CustomerDao  Customer(SessionFactory sessionFactory){
		return new  CustomerDaoImpl  (sessionFactory);
	}
	
	@Autowired
	@Bean(name ="billingaddDao")
	public BillingaddDao  Billingadd(SessionFactory sessionFactory){
		return new  BillingaddDaoImpl  (sessionFactory);
	}
	
	@Autowired
	@Bean(name ="shippmentaddDao")
	public ShippmentaddDao  Shippmentadd(SessionFactory sessionFactory){
		return new  ShippmentaddDaoImpl  (sessionFactory);
	}
	
	@Autowired
	@Bean(name ="corderDao")
	public CorderDao  Corder(SessionFactory sessionFactory){
		return new  CorderDaoImpl (sessionFactory);
	}
}
