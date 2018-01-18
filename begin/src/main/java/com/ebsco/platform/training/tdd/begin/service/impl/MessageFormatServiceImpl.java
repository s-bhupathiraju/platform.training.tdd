package com.ebsco.platform.training.tdd.begin.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebsco.platform.training.tdd.begin.dto.FormattedGreetingDTO;
import com.ebsco.platform.training.tdd.begin.dto.GreetingDTO;
import com.ebsco.platform.training.tdd.begin.model.User;
import com.ebsco.platform.training.tdd.begin.repository.UserRepository;
import com.ebsco.platform.training.tdd.begin.service.MessageFormatService;

@Service
public class MessageFormatServiceImpl implements MessageFormatService {
	
	private static final Logger log = LoggerFactory.getLogger(MessageFormatServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	public FormattedGreetingDTO formatGreetingMessage(GreetingDTO greeting) {
		return null;
	}

}
