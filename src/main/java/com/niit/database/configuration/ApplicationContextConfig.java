package com.niit.database.configuration;

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

import com.niit.database.dao.ProductDAO;
import com.niit.database.dao.ProductDAOImpl;
import com.niit.database.model.ProductTable;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.niit.database")

public class ApplicationContextConfig {@Bean(name="dataSource")
public DataSource getH2DataSource() {
	DriverManagerDataSource dataSource=new DriverManagerDataSource();
	dataSource.setDriverClassName("org.h2.Driver");
	dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
	dataSource.setUsername("sa");
	dataSource.setPassword("");
	
	return dataSource;
}

private Properties getHibernateProperties() {
	Properties properties=new Properties();
	properties.put("hibernate.show_sql", "true");
	properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	properties.put("hibernate.hbm2ddl.auto","update");
	
	return properties;		
}

@Autowired
@Bean(name="sessionFactory")
public SessionFactory getSessionFactory(DataSource dataSource) {
	LocalSessionFactoryBuilder sessionBuilder=new LocalSessionFactoryBuilder(dataSource);
	sessionBuilder.addProperties(getHibernateProperties());
	sessionBuilder.addAnnotatedClass(ProductTable.class);
	

	return sessionBuilder.buildSessionFactory();
}

@Autowired
@Bean(name="transactionManager")
public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
	HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
	
	return transactionManager;
}

@Autowired
@Bean(name = "productDAO")
public ProductDAO getProductDAO(SessionFactory sessionFactory) {
	   
	return new ProductDAOImpl(sessionFactory);
}


}
