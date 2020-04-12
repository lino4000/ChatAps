package com.lino4000.ChatAps.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import de.mkammerer.argon2.Argon2Factory.Argon2Types;

import javax.swing.SwingUtilities;

import java.awt.Font;
import java.time.Duration;
import java.time.Instant;

import javax.swing.UIManager;

public class MainScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6891107083658713796L;
	private JPanel pnMain;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		FlatLightLaf.install();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainScreen() {
		
		setTitle("ChatAPS");
		setName("MainScreen");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		pnMain = new JPanel();
		pnMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		pnMain.setLayout(new BorderLayout(0, 0));
		setContentPane(pnMain);
		
		pnMain.add(new pnLogin());
		
		UIManager.put("TextField.font", new Font("Console", Font.PLAIN, 20) );

		SwingUtilities.updateComponentTreeUI(this);
		
	    char[] password = "Hello World!".toCharArray();
	    Instant beginHash = Instant.now();

	    Argon2 argon2 = Argon2Factory.create(Argon2Types.ARGON2id);
	    System.out.println(String.format("Creating hash for password '%s'.", password));

	    String hash = argon2.hash(4, 1024 * 1024, 8, password);
	    System.out.println(String.format("Encoded hash is '%s'.", hash));

	    Instant endHash = Instant.now();
	    System.out.println(String.format(
	        "Process took %f s",
	        Duration.between(beginHash, endHash).toMillis() / 1024.0
	        ));

	    Instant beginVerify = Instant.now();
	    System.out.println("Verifying hash...");

//	    boolean success = argon2.verify(hash, password);
	    System.out.println(argon2.verify(hash, password) ? "Success!" : "Failure!");

	    Instant endVerify = Instant.now();
	    System.out.println(String.format(
	        "Process took %f s",
	        Duration.between(beginVerify, endVerify).toMillis() / 1024.0
	        ));
   }
}
