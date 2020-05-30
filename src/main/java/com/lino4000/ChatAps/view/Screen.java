package com.lino4000.ChatAps.view;

import java.io.File;
import java.net.URL;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.lino4000.ChatAps.ChatApsApplication;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Screen extends Application {
	
	private ConfigurableApplicationContext context;
	
	public void init() throws Exception {
		ApplicationContextInitializer<GenericApplicationContext> initializer =
				ac -> {
					ac.registerBean(Application.class, () -> Screen.this);
					ac.registerBean(Parameters.class, this::getParameters);
					ac.registerBean(HostServices.class, this::getHostServices);
				};
		this.context = new SpringApplicationBuilder()
				.sources(ChatApsApplication.class)
				.initializers(initializer)
				.run(getParameters().getRaw().toArray(new String[0]));
	}

    @Override
    public void start(Stage primaryStage) throws Exception{
    	URL url = new File("src/main/resources/fxml/Screen.fxml").toURI().toURL();
    	Parent root = FXMLLoader.load(url);
        primaryStage.setTitle("Gotta Chat");
        primaryStage.setScene(new Scene(root, 800, 600));
//        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

}