package com.lino4000.ChatAps.repository;

import org.springframework.data.repository.CrudRepository;

import com.lino4000.ChatAps.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsername(String username);
	User findById(Integer id);
}