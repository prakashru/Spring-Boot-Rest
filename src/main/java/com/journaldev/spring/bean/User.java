package com.journaldev.spring.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;

@ApiModel(description="All details about the user")
@Entity
public class User {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=2, message="Name should be more then two char.") //Validation on name. Same should have min 2 chars
	private String name;
	@Past(message="Date of Birth should not be future date.")
	private Date DoB;
	
	
	
	public User(Integer id, String name, Date doB) {
		super();
		this.id = id;
		this.name = name;
		DoB = doB;
	}
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", DoB=" + DoB + "]";
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDoB() {
		return DoB;
	}
	public void setDoB(Date doB) {
		DoB = doB;
	}
	
	
	protected User() {
		
	}
	
	
}
