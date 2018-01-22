package com.ebsco.platform.training.tdd.begin.app.service;

import java.util.Optional;

import com.ebsco.platform.training.tdd.begin.app.model.User;

public interface UserService {
	public Optional<User> findOne(Long id);
}
