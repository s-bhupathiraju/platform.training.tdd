package com.ebsco.platform.training.tdd.begin.app.controller;

import java.net.MalformedURLException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ebsco.platform.training.tdd.begin.app.controller.resources.UserResource;
import com.ebsco.platform.training.tdd.begin.app.controller.resources.asm.UserResourceAsm;
import com.ebsco.platform.training.tdd.begin.app.dto.FormattedGreetingDTO;
import com.ebsco.platform.training.tdd.begin.app.dto.GreetingDTO;
import com.ebsco.platform.training.tdd.begin.app.exception.UserNotFoundException;
import com.ebsco.platform.training.tdd.begin.app.model.User;
import com.ebsco.platform.training.tdd.begin.app.service.MessageFormatService;
import com.ebsco.platform.training.tdd.begin.app.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private MessageFormatService messageFormatService;

	@Autowired
	private UserService userService;

	@Autowired
	private UserResourceAsm userResourceAsm;

	public UserController(MessageFormatService messageFormatService) {
		this.messageFormatService = messageFormatService;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/formatgreeting", consumes = "application/json", produces = "application/json;charset=UTF-8")
	public ResponseEntity<FormattedGreetingDTO> formatGreeting(@RequestBody GreetingDTO greetingDTO)
			throws MalformedURLException {
		return new ResponseEntity<FormattedGreetingDTO>(messageFormatService.formatGreetingMessage(greetingDTO),
				HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserResource> findOne(@PathVariable Long id) {

		Optional<User> user = userService.findOne(id);

		if (!user.isPresent()) {
			throw new UserNotFoundException();
		}

		UserResource userResource = userResourceAsm.toResource(user.get());
		return new ResponseEntity<UserResource>(userResource, HttpStatus.OK);
	}

}
