package com.rest.hteoas.practice.model;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

public class Users extends ResourceSupport {

	private String userName;
	private int salary;
	
	public Users(String userName, int salary) {
		super();
		this.userName = userName;
		this.salary = salary;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}

	

}
