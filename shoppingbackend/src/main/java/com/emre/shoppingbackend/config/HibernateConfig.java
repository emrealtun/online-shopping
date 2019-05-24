package com.emre.shoppingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"com.emre.shoppingbackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {
	
		private final static String DATABASE_URL ="jdbc:mysql://localhost/onlineshopping?useSSL=false";
		private final static String DATABASE_DRIVER ="com.mysql.cj.jdbc.Driver";
		private final static String DATABASE_DIALECT="org.hibernate.dialect.MySQL5InnoDBDialect";
		private final static String DATABASE_USERNAME ="root";
		private final static String DATABASE_PASSWORD ="Emre1234.";
		
		@Bean
		public DataSource getDataSource()
		{
			BasicDataSource ds = new BasicDataSource();
			
			ds.setDriverClassName(DATABASE_DRIVER);
			ds.setUrl(DATABASE_URL);
			ds.setUsername(DATABASE_USERNAME);
			ds.setPassword(DATABASE_PASSWORD);
					
			return ds;
		}
			
		@Bean
		public SessionFactory getSessionFactory(DataSource dataSource)
		{
			LocalSessionFactoryBuilder builder =new LocalSessionFactoryBuilder(dataSource);
			
			builder.addProperties(getHibernateProperties());
			builder.scanPackages("com.emre.shoppingbackend.dto");

			return  builder.buildSessionFactory();
		}
		
		
		
		private  Properties getHibernateProperties()
		{
			Properties  prop = new Properties();
			prop.put("hibernate.dialect", DATABASE_DIALECT);
			prop.put("hibernate.show_sql","true");
			prop.put("hibernate.format_sql","true");

			return prop;
		}
		
		@Bean
		public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
		{
			HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		
			return transactionManager;
			
		}
}

	