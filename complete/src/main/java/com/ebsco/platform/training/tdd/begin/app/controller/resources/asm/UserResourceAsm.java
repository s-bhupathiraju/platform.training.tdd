package com.ebsco.platform.training.tdd.begin.app.controller.resources.asm;



import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.ebsco.platform.training.tdd.begin.app.controller.UserController;
import com.ebsco.platform.training.tdd.begin.app.controller.resources.UserResource;
import com.ebsco.platform.training.tdd.begin.app.model.User;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

@Component
public class UserResourceAsm extends ResourceAssemblerSupport<User,UserResource>{

	public UserResourceAsm() {
		super(UserController.class, UserResource.class);
	}

	@Override
	public UserResource toResource(User user){
		UserResource nodeUserResource = new UserResource(user.getId(), user.getFirstName(), user.getLastName());
		
		nodeUserResource.add(linkTo(methodOn(UserController.class).findOne(user.getId())).withSelfRel());
		return nodeUserResource;
	}
}