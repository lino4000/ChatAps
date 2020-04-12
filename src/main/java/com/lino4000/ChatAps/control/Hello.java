package com.lino4000.ChatAps.control;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

	@GetMapping("/")
	public String HelloMessage() {
		return "Yep, It works!!!";
	}
}
