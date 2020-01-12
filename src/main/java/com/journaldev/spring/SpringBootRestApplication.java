package com.journaldev.spring;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class SpringBootRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApplication.class, args);
	}
	
	
	//For Internationalization process below configuration needs to set 
	@Bean
	public LocaleResolver localeResoulver() {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
	    localeResolver.setDefaultLocale(Locale.US);
		
		return localeResolver;
		
		//AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		//localeResolver.setDefaultLocale(Locale.US);
		//return localeResolver;
	}
	
	@Bean
	public ResourceBundleMessageSource bundleMessageSource() {
		
		ResourceBundleMessageSource messageSource = new 
				ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}
}
