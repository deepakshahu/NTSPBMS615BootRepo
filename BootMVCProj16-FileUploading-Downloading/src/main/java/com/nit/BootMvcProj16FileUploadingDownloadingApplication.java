package com.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
public class BootMvcProj16FileUploadingDownloadingApplication {
	
	@Bean
	public ViewResolver createIRVR() {
		System.out.println("BootMvcProj16FileUploadingDownloadingApplication.createIRVR()");
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/pages1/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver createCMResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setMaxUploadSizePerFile(50*1024*1024);
		resolver.setMaxUploadSize(-1);  //all files together how much file size is allowed, -1 indicates no limit
		return resolver;
	}

	public static void main(String[] args) {
		SpringApplication.run(BootMvcProj16FileUploadingDownloadingApplication.class, args);
	}

}
