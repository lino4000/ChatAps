package com.lino4000.ChatAps.view;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

import org.jdesktop.swingx.prompt.PromptSupport;

import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.JButton;

public class pnLogin extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7478884314418770783L;
	private JTextField tfUser;
	private JTextField tfPass;

	/**
	 * Create the panel.
	 */
	public pnLogin() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 250, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, panel, 300, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 350, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, panel, 500, SpringLayout.WEST, this);
		add(panel);
		GridLayout gl_panel = new GridLayout(3, 1, 0, 2);
		panel.setLayout(gl_panel);
		
		tfUser = new JTextField();
		panel.add(tfUser);
		tfUser.setColumns(10);
		PromptSupport.setPrompt("Usuário",tfUser);
		
		tfPass = new JTextField();
		panel.add(tfPass);
		tfPass.setColumns(10);
		PromptSupport.setPrompt("Senha",tfPass);
		
		JButton btnLogin = new JButton("Acessar");
		btnLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(btnLogin);

	}
}
