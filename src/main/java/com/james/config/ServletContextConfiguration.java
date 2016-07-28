package com.james.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan(
		basePackages = "com.james",
		useDefaultFilters = false,
		includeFilters = @ComponentScan.Filter(Controller.class)
		)
public class ServletContextConfiguration {
	
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setViewClass(JstlView.class);
		
		viewResolver.setPrefix("/WEB-INF/view/");		
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
}
