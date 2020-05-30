package com.lino4000.ChatAps.controller;

import java.util.Collections;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lino4000.ChatAps.model.Message;
import com.lino4000.ChatAps.model.Login;
import com.lino4000.ChatAps.service.MessageService;
import com.lino4000.ChatAps.service.UserService;

@Controller
public class ChatController {
	
	@Autowired
	UserService user;
	@Autowired
	MessageService messages;
	
	@GetMapping("/")
	public String getLoginPage() {
		user.hash();
		return "index";
	}

	@RequestMapping(path = "/", method = RequestMethod.POST)
	public ModelAndView loginAttempt(Login login) {
		if ( user.verifyPassword(login) ) {
			ModelAndView mav = new ModelAndView("chat", Collections.singletonMap("login", login));
			mav.addObject("username", login.getUsername());
			return mav;
		}
		else return new ModelAndView("error", Collections.singletonMap("login", login));
	}

	@MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public Message sendMessage(@Payload Message message) {
		messages.add(message);
        return message;
    }
	
	@MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public Message addUser(@Payload Message message, SimpMessageHeaderAccessor headerAccessor) {
		headerAccessor.getSessionAttributes().put("username", message.getSender());
        return message;
    }
	
}
