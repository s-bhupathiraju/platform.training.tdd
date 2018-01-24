package com.ebsco.platform.training.tdd.begin.app.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebsco.platform.training.tdd.begin.app.dto.FormattedGreetingDTO;
import com.ebsco.platform.training.tdd.begin.app.dto.GreetingDTO;
import com.ebsco.platform.training.tdd.begin.app.model.User;
import com.ebsco.platform.training.tdd.begin.app.repository.UserRepository;
import com.ebsco.platform.training.tdd.begin.app.service.MessageFormatService;
import com.ebsco.platform.training.tdd.begin.app.service.components.TimeLoggingComponent;

@Service
public class MessageFormatServiceImpl implements MessageFormatService {
	
	private static final Logger log = LoggerFactory.getLogger(MessageFormatServiceImpl.class);

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TimeLoggingComponent timeLoggingComponent;

	@Override
	public FormattedGreetingDTO formatGreetingMessage(GreetingDTO greeting) {
		
		return null;
	}

}
