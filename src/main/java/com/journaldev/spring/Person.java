package com.journaldev.spring;

import org.springframework.stereotype.Component;

@Component
public class Person {

	private String name;
	private char[] password;
	

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
