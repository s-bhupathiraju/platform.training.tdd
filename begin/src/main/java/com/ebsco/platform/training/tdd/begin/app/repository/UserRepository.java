package com.ebsco.platform.training.tdd.begin.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ebsco.platform.training.tdd.begin.app.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByLastName(String lastName);
}