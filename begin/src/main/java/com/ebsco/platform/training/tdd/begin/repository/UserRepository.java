package com.ebsco.platform.training.tdd.begin.repository;

import java.util.List;
import com.ebsco.platform.training.tdd.begin.model.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByLastName(String lastName);
}