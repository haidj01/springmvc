package com.dkim.springmvc.init;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext sc) throws ServletException {
		System.out.println("on start up");
		AnnotationConfigWebApplicationContext  webContext = new AnnotationConfigWebApplicationContext ();
		webContext.register(WebAppConfig.class);
		System.out.println("web context register..");
		sc.addListener(new ContextLoaderListener(webContext));
		System.out.println("add Listener");
		ServletRegistration.Dynamic dispatcher = sc.addServlet("dispatcher", new DispatcherServlet(webContext));
				 
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		
	}

}
