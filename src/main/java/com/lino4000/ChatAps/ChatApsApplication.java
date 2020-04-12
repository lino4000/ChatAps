package com.lino4000.ChatAps;

//import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class ChatApsApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ChatApsApplication.class)
			.web(WebApplicationType.NONE) // .REACTIVE, .SERVLET
	        .run(args);
		new java.util.Timer().schedule( 
		        new java.util.TimerTask() {
		            @Override
		            public void run() {
		            	new SpringApplicationBuilder(ChatApsApplication.class)
		                .web(WebApplicationType.SERVLET) // .REACTIVE, .SERVLET
		                .run(args);
		            }
		        }, 
		        10000 
		);
	}

}
