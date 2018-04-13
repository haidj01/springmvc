package com.dkim.springmvc.init;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.engine.jdbc.dialect.spi.DatabaseMetaDataDialectResolutionInfoAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
//import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.JstlView;


@Configuration
@EnableWebMvc
@ComponentScan("com.dkim.springmvc.*")
@PropertySource("/WEB-INF/resources/application.properties")
public class WebAppConfig extends WebMvcConfigurerAdapter {
	
	@Resource
	Environment env;
	
	private final String PROPERTY_DATABASE_DRIVER     ="database.driver";
	private final String PROPERTY_DATBASE_URL           ="database.url";
	private final String PROPERTY_DATABASE_USER        ="database.user";
	private final String PROPERTY_DATABASE_PASSWORD="database.password";
	private final String PROPERTY_DATABASE_DIALECT=    "hibernate.dialect";
	
	@Bean
	 public ViewResolver viewResolver() {
	      InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	      viewResolver.setViewClass(JstlView.class);
	      viewResolver.setPrefix("/WEB-INF/views/jsp/");
	      viewResolver.setSuffix(".jsp");
	      System.out.println("app name :"+env.getProperty("applicaton.name"));
	      return viewResolver;
	   }
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty(PROPERTY_DATABASE_DRIVER));
		dataSource.setUrl(env.getProperty(PROPERTY_DATBASE_URL));
		dataSource.setUsername(env.getProperty(PROPERTY_DATABASE_USER));
		dataSource.setPassword(env.getProperty(PROPERTY_DATABASE_PASSWORD));
		
		System.out.println("dataSource ");
		
		return dataSource;
	}
	
	  @Bean
	   public LocalSessionFactoryBean sessionFactory() {
	      LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
	      
	      localSessionFactoryBean.setDataSource(dataSource());
	      localSessionFactoryBean.setPackagesToScan(
	        new String[] { "com.dkim.springmvc.model" });
	      localSessionFactoryBean.setHibernateProperties(hibernateProperties());
	      
	      return localSessionFactoryBean;
	   }
	  
//	   @Bean
//	   public HibernateTransactionManager transactionManager() {
//	  
//	      HibernateTransactionManager txManager
//	       = new HibernateTransactionManager();
//	      txManager.setSessionFactory(sessionFactory());
//	 
//	      return txManager;
//	   }
	  
	  
	  Properties hibernateProperties() {
	      return new Properties() {
	         {
	            setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
	            setProperty("hibernate.show_sql","true");
	         }
	      };
	  }
}
