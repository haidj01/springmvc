package com.dkim.springmvc.init;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import jdk.nashorn.internal.ir.annotations.Reference;

@Configuration
@EnableWebMvc
@ComponentScan("com.dkim.springmvc.controller")
@PropertySource("/WEB-INF/resources/application.properties")
public class WebAppConfig extends WebMvcConfigurerAdapter {
	
	@Reference
	Environment env;
	
	@Bean
	   public ViewResolver viewResolver() {
	      InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	      //viewResolver.setViewClass(JstlView.class);
	      viewResolver.setPrefix("/WEB-INF/views/jsp/");
	      viewResolver.setSuffix(".jsp");

	      return viewResolver;
	   }
}
