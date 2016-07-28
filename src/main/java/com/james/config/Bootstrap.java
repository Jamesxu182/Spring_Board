package com.james.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class Bootstrap implements WebApplicationInitializer {

	private AnnotationConfigWebApplicationContext rootContext;
	private AnnotationConfigWebApplicationContext servletContext;
	
	@Override
	public void onStartup(ServletContext container) throws ServletException {
		// TODO Auto-generated method stub
		container.getServletRegistration("default").addMapping("/resources/*");
		
		rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(RootContextConfiguration.class);
		container.addListener(new ContextLoaderListener(rootContext));
		
		servletContext = new AnnotationConfigWebApplicationContext();
		servletContext.register(ServletContextConfiguration.class);
		
		ServletRegistration.Dynamic dispatcher = container.addServlet("Dispatcher", new DispatcherServlet(servletContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}

}
