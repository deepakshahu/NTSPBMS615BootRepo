package com.nit;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class BootMvcProj15I18nApplication {
	
	@Bean(name = "localeResolver")  //fixed bean id
	public SessionLocaleResolver createSLResolver() {
		System.out.println("BootMvcProj15I18nApplication.createSLResolver()");
		SessionLocaleResolver resolver = new SessionLocaleResolver();
		resolver.setDefaultLocale(new Locale("en","US"));
		return resolver;
	}
	
	@Bean
	public LocaleChangeInterceptor createLCInterceptor() {
		System.out.println("BootMvcProj15I18nApplication.createLCInterceptor()");
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		interceptor.setParamName("lang");
		return interceptor;
	}

	public static void main(String[] args) {
		SpringApplication.run(BootMvcProj15I18nApplication.class, args);
	}

}
