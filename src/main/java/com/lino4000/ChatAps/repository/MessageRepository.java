package com.lino4000.ChatAps.repository;

import org.springframework.data.repository.CrudRepository;

import com.lino4000.ChatAps.model.Message;

public interface MessageRepository extends CrudRepository<Message, Long>{

	
}