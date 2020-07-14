package com.tataaia.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@PropertySource(value= {"classpath:application.properties"})
@Configuration
public class DBConfig {
	
	@Value("${jdbc.driverclassname}")
	private String driverClass;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.username}")
	private String userName;
	@Value("${jdbc.password}")
	private String password;
	@Value("${hibernate.dialect}")
	private String dialect;
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource ds=new DriverManagerDataSource(url,userName,password);
		ds.setDriverClassName(driverClass);
		return ds;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean factory=new LocalSessionFactoryBean();
		factory.setDataSource(getDataSource());
		factory.setHibernateProperties(hibernateProperties());
		factory.setPackagesToScan("com.tataaia.model.*");
		return factory;
	}
	public Properties hibernateProperties() {
		Properties prop=new Properties();
		prop.put("hibernate.dilect", dialect);
		prop.put("hibernate.hbm2ddl.auto", "create");
		prop.put("hibernate.show_sql", true);
		prop.put("hibernate.format_sql",true);
		return prop;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transManager(SessionFactory factory) {
		HibernateTransactionManager tm=new HibernateTransactionManager();
		tm.setSessionFactory(factory);
		return tm;
	}
}
