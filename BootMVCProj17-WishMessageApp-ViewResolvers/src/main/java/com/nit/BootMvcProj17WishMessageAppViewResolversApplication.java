package com.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.XmlViewResolver;

@SpringBootApplication
public class BootMvcProj17WishMessageAppViewResolversApplication {
	
	/*@Bean
	public ViewResolver createIRVResolver() {
		System.out.println("BootMvcProj17WishMessageAppViewResolversApplication.createIRVResolver()");
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		return resolver;  //takes InternalResourceView or JstlView as the default View class
	}*/
	
	/*@Bean
	public ViewResolver createUBVResolver() {
		System.out.println("BootMvcProj17WishMessageAppViewResolversApplication.createUBVResolver()");
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		//resolver.setViewClass(InternalResourceView.class);
		resolver.setViewClass(JstlView.class);
		return resolver;
	}*/
	
	/*@Bean
	public ViewResolver createRBVResolver() {
		System.out.println("BootMvcProj17WishMessageAppViewResolversApplication.createRBVResolver()");
		ResourceBundleViewResolver resolver = new ResourceBundleViewResolver();
		resolver.setBasename("com/nit/commons/views");
		return resolver;
	}*/
	
	@Bean
	public ViewResolver createXVResolver() {
		System.out.println("BootMvcProj17WishMessageAppViewResolversApplication.createXVResolver()");
		XmlViewResolver resolver = new XmlViewResolver();
		resolver.setLocation(new ClassPathResource("com/nit/cfgs/views.xml"));
		return resolver;
	}

	public static void main(String[] args) {
		SpringApplication.run(BootMvcProj17WishMessageAppViewResolversApplication.class, args);
	}

}
