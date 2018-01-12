package com.ebsco.platform.training.tdd.begin.service.impl;

import org.springframework.stereotype.Service;

import com.ebsco.platform.training.tdd.begin.model.FormattedGreetingDTO;
import com.ebsco.platform.training.tdd.begin.model.GreetingDTO;
import com.ebsco.platform.training.tdd.begin.service.MessageFormatService;

@Service
public class MessageFormatServiceImpl implements MessageFormatService {

	@Override
	public FormattedGreetingDTO formatGreetingMessage(GreetingDTO greeting) {

		if (greeting.getName() == null) {
			throw new IllegalArgumentException("Greeting name must not be null");
		}

		if (greeting.getPrefix() != null && greeting.getSuffix() != null) {
			return new FormattedGreetingDTO(

					greeting.getPrefix() + greeting.getName() + greeting.getSuffix());

		} else if (greeting.getPrefix() != null) {

			return new FormattedGreetingDTO(greeting.getPrefix() + greeting.getName());

		} else if (greeting.getSuffix() != null) {
			return new FormattedGreetingDTO(

					greeting.getName() + greeting.getSuffix());
		} else {
			return new FormattedGreetingDTO("Hi " + greeting.getName());
		}

	}

}
