package com.journaldev.spring.endpoints;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InternationalizationController {
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping(path="/hello-world")
	public String helloWorldInternationalized(@RequestHeader(name="Accept-Language", required=false) Locale locale) {
			return messageSource.getMessage("good.morning.message", null, locale);
		
	}

}
