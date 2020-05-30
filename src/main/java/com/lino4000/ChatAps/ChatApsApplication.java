package com.lino4000.ChatAps;

import javafx.application.Application;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lino4000.ChatAps.view.Screen;

@SpringBootApplication
public class ChatApsApplication {
	
	public static void main(String[] args) {
		Application.launch(Screen.class, args);	
	}
}
