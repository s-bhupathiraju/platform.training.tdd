package com.ebsco.platform.training.tdd.begin.app.model.builder;

import com.ebsco.platform.training.tdd.begin.app.model.User;
// Test Fixture for User
public class UserBuilder {
	private Long id;
	private String firstName;
	private String lastName;
	
	public UserBuilder() {
		super();
	}
	
	public UserBuilder(Long id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public User build() {
		User user = new User(id, firstName, lastName);
		return user;
	}
	
	public UserBuilder id(Long id) {
		this.id = id;
		return this;
	}
	
	public UserBuilder firstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	
	public UserBuilder lastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	
	
}
