package com.lino4000.ChatAps.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

	private String htLink;
	private String port;

    @FXML
    private TextField addressBar;

    private String adrsLink;

    @FXML
    private WebView web;

    private WebEngine engine;

    public Controller() {
    	this.port = ":8080";
    	this.htLink = "http://";
    }
    
    public void go(ActionEvent actionEvent){
        adrsLink = addressBar.getText().toString();
        engine.load(htLink+adrsLink);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        engine = web.getEngine();
        engine.load(htLink+"localhost"+this.port);
    }
}