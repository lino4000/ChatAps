package com.lino4000.ChatAps.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lino4000.ChatAps.model.Message;
import com.lino4000.ChatAps.repository.MessageRepository;
import com.lino4000.ChatAps.repository.UserRepository;

@Service
public class MessageService {
	
	@Autowired
	private MessageRepository messageRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public void add(Message message) {
		messageRepository.save(Message
				.builder()
				.content(message.getContent())
				.user(userRepository.findByUsername(message.getSender()))
				.build()
				);
	}

}
