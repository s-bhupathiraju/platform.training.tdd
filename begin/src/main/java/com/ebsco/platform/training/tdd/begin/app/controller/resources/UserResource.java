package com.ebsco.platform.training.tdd.begin.app.controller.resources;


import java.util.Date;
import java.util.UUID;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

import com.ebsco.platform.training.tdd.begin.app.model.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import lombok.Data;

/**
 * @author sbhupathiraju
 *
 */
@Relation(collectionRelation = "users")
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class UserResource extends ResourceSupport {

	private Long rid;
	private String firstName;
	private String lastName;

	
	public UserResource() {
		super();
	}


	public UserResource(Long rid, String firstName, String lastName) {
		super();
		this.rid = rid;
		this.firstName = firstName;
		this.lastName = lastName;
	}


	public User toUser() {
		User user = new User(this.rid, this.firstName, this.lastName);
		return user;
	}

}