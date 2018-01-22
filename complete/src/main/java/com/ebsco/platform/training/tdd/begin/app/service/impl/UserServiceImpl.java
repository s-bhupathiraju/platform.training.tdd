package com.ebsco.platform.training.tdd.begin.app.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebsco.platform.training.tdd.begin.app.model.User;
import com.ebsco.platform.training.tdd.begin.app.repository.UserRepository;
import com.ebsco.platform.training.tdd.begin.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	public User findOne(Long id) {
		return userRepository.findOne(id);
	}

}
