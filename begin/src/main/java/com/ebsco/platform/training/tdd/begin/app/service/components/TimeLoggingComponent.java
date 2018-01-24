package com.ebsco.platform.training.tdd.begin.app.service.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ebsco.platform.training.tdd.begin.app.dto.FormattedGreetingDTO;
import com.ebsco.platform.training.tdd.begin.app.dto.GreetingDTO;
import com.ebsco.platform.training.tdd.begin.app.model.User;
import com.ebsco.platform.training.tdd.begin.app.repository.UserRepository;
import com.ebsco.platform.training.tdd.begin.app.service.MessageFormatService;

@Component
public class TimeLoggingComponent {
	
	private static final Logger log = LoggerFactory.getLogger(TimeLoggingComponent.class);

	public Long logTime() {
		Long time = System.currentTimeMillis();
		log.info("Current Time: ", System.currentTimeMillis());
		return time;
	}

}
