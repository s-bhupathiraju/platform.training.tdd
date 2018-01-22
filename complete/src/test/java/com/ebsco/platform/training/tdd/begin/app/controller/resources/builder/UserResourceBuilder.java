package com.ebsco.platform.training.tdd.begin.app.controller.resources.builder;

import com.ebsco.platform.training.tdd.begin.app.model.User;

// Test Fixture for UserResource
public class UserResourceBuilder {
	private Long rid;
	private String firstName;
	private String lastName;
	
	public UserResourceBuilder() {
		super();
	}
	
	public UserResourceBuilder(Long rid, String firstName, String lastName) {
		super();
		this.rid = rid;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public User build() {
		User user = new User(rid, firstName, lastName);
		return user;
	}
	
	public UserResourceBuilder rid(Long rid) {
		this.rid = rid;
		return this;
	}
	
	public UserResourceBuilder firstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	
	public UserResourceBuilder lastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	
	
}
